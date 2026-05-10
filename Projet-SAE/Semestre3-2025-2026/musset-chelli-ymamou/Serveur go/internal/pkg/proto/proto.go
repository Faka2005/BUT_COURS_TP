// Package proto : définitions et utilitaires du protocole
// pour commandes en ligne et transferts binaires utilisés
// par le client et le serveur.

// Fournit :
// - Constantes pour commandes et réponses
// - Utilitaires de lecture/écriture de messages en ligne (terminées par '\n')
// - Aides pour lister les fichiers avec leur taille
// - Gestion sûre des chemins limitée au répertoire servi

package proto

import (
	"bufio"
	"errors"
	"fmt"
	"io"
	"os"
	"path/filepath"
	"strings"
)

// Constantes du protocole
const (
	CmdList      = "List" // Client→Serveur : demander la liste (optionnellement d'un sous-répertoire: "List <relpath>")
	CmdGetPrefix = "Get " // Client→Serveur : demander un fichier précis par son nom
	CmdEnd       = "End"  // Client→Serveur : terminer la session

	// Commandes propres au port de contrôle (connexion unique)
	CmdHidePrefix   = "Hide "     // Contrôle→Serveur : cacher un fichier de la liste
	CmdRevealPrefix = "Reveal "   // Contrôle→Serveur : révéler un fichier précédemment caché
	CmdTerminate    = "Terminate" // Contrôle→Serveur : arrêter le serveur proprement

	// Réponses du serveur
	RespFileCntPrefix = "FileCnt "    // Serveur→Client : nombre de fichiers disponibles
	RespFileUnknown   = "FileUnknown" // Serveur→Client : fichier inconnu
	RespStart         = "Start"       // Serveur→Client : début du flux binaire pour un fichier
	RespOK            = "OK"          // Serveur→Client : accusé de réception / confirmation
)

// ErrClosed : la connexion ou le flux sous-jacent est fermé.
var ErrClosed = errors.New("proto: connection fermer")

// WriteLine : écrit un message de protocole terminé par "\n".
// N'inclut pas de logs ; les appelants doivent journaliser autour.
func WriteLine(w io.Writer, s string) error {
	_, err := io.WriteString(w, s+"\n")
	return err
}

// ReadLine : lit une ligne terminée par "\n" et la renvoie sans le retour de ligne.
// Bloque jusqu'à ce qu'une ligne soit disponible ou qu'une erreur survienne.
func ReadLine(r *bufio.Reader) (string, error) {
	line, err := r.ReadString('\n')
	if err != nil {
		return "", err
	}
	return strings.TrimRight(line, "\r\n"), nil
}

// ParseGetCommand : extrait le nom du fichier depuis "Get <nomfichier>".
func ParseGetCommand(cmd string) (string, bool) {
	if !strings.HasPrefix(cmd, CmdGetPrefix) {
		return "", false
	}
	name := strings.TrimSpace(strings.TrimPrefix(cmd, CmdGetPrefix))
	if name == "" {
		return "", false
	}
	return name, true
}

// ParseHideReveal : extrait le nom de fichier depuis les commandes Hide/Reveal.
func ParseHideReveal(cmd string) (string, string, bool) {
	switch {
	case strings.HasPrefix(cmd, CmdHidePrefix):
		return "Hide", strings.TrimSpace(strings.TrimPrefix(cmd, CmdHidePrefix)), true
	case strings.HasPrefix(cmd, CmdRevealPrefix):
		return "Reveal", strings.TrimSpace(strings.TrimPrefix(cmd, CmdRevealPrefix)), true
	default:
		return "", "", false
	}
}

// FileEntry : représente un fichier disponible pour les clients.
type FileEntry struct {
	Name string
	Size int64
}

// ListFiles : renvoie la liste des entrées (fichiers et dossiers non récursif) du répertoire.
// Convention: les dossiers sont renvoyés avec Size = -1.
// Les fichiers cachés doivent être filtrés par l'appelant via l'état partagé du serveur.
func ListFiles(dir string) ([]FileEntry, error) {
	entries, err := os.ReadDir(dir)
	if err != nil {
		return nil, err
	}
	files := make([]FileEntry, 0, len(entries))
	for _, e := range entries {
		if e.IsDir() {
			files = append(files, FileEntry{Name: e.Name(), Size: -1})
			continue
		}
		if e.Type().IsRegular() {
			info, err := e.Info()
			if err != nil {
				continue
			}
			files = append(files, FileEntry{Name: e.Name(), Size: info.Size()})
		}
	}
	return files, nil
}

// SafeJoinRel : joint baseDir et un chemin relatif (peut contenir des sous-dossiers),
// garantit que le résultat reste dans baseDir. Retourne le chemin complet et le chemin
// relatif normalisé avec séparateurs '/'.
func SafeJoinRel(baseDir, rel string) (string, string, error) {
	if rel == "." || rel == "" {
		rel = ""
	}
	// Normaliser les séparateurs et nettoyer
	rel = filepath.Clean(rel)
	if strings.HasPrefix(rel, "..") {
		return "", "", fmt.Errorf("invalid path: %s", rel)
	}
	full := filepath.Join(baseDir, rel)
	// Vérifier que full est bien dans baseDir
	absBase, err := filepath.Abs(baseDir)
	if err != nil {
		return "", "", err
	}
	absFull, err := filepath.Abs(full)
	if err != nil {
		return "", "", err
	}
	relCheck, err := filepath.Rel(absBase, absFull)
	if err != nil || strings.HasPrefix(relCheck, "..") {
		return "", "", fmt.Errorf("path escapes base: %s", rel)
	}
	// Normaliser en séparateurs '/'
	normRel := filepath.ToSlash(relCheck)
	if normRel == "." {
		normRel = ""
	}
	return absFull, normRel, nil
}

// ParseListCommand : extrait un chemin relatif optionnel depuis "List" ou "List <relpath>".
func ParseListCommand(cmd string) (string, bool) {
	if cmd == CmdList {
		return "", true
	}
	if strings.HasPrefix(cmd, CmdList+" ") {
		path := strings.TrimSpace(strings.TrimPrefix(cmd, CmdList+" "))
		return path, true
	}
	return "", false
}

// SendList : écrit la réponse de liste : FileCnt puis chaque ligne "nom taille".
// L'appelant gère ensuite l'envoi du OK final.
func SendList(w io.Writer, files []FileEntry) error {
	// Test: écrire l'entête avec le nombre de fichiers
	err := WriteLine(w, fmt.Sprintf("%s%d", RespFileCntPrefix, len(files)))
	if err != nil {
		return err
	}
	// Test: écrire chaque entrée "nom taille"
	for _, f := range files {
		err = WriteLine(w, fmt.Sprintf("%s %d", f.Name, f.Size))
		if err != nil {
			return err
		}
	}
	return nil
}

// SendFile : écrit "Start\n" puis copie exactement "size" octets de src vers dst.
// Le client doit envoyer "OK\n" ensuite.
func SendFile(dst io.Writer, src io.Reader, size int64) error {
	// Test: signaler le début du flux binaire au client
	err := WriteLine(dst, RespStart)
	if err != nil {
		return err
	}
	// Copiez la taille exacte des octets ; io.CopyN renvoie une erreur si moins d’octets sont disponibles.
	_, err = io.CopyN(dst, src, size)
	return err
}
