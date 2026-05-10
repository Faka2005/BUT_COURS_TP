# Avant-propos

L'auteur des exercices ci-dessous est Loïg Jezequel.
Le texte d'origine a été modifié à la marge pour l'année 2025-2026.

Pour faire communiquer deux processus s'exécutant sur une même machine, les systèmes d'exploitation Unix (dont Linux)  proposent un mécanisme appelé _sockets_.
L’idée générale est la suivante : le système créé un espace mémoire comparable à un fichier ; quand un des processus écrit dans ce fichier, l’autre a la possibilité de lire ce qui vient d’être écrit.
Les sockets sont similaires à des connecteurs, qui permettent aux processus d'accéder à cette espace mémoire, via des opérations de lecture et écriture semblables à celles utilisées pour les fichiers.
En Go, le paquet `net` permet de créer et utiliser des sockets.
Pour mettre en place la communication, on utilise une approche client/serveur :
    1. Le serveur demande au système la création d'un socket (le système alloue alors l'espace mémoire), puis se met en écoute (processus 1) ;
    2. Le client demande au système la créaction d'un socket permettant d'interagir avec le serveur (processus 2) ;
    3. Le serveur reçoit la demande de connexion du client et l'accepte (processus 1).
    
À l’issu de ces trois étapes, une voie de communication est ouverte entre les deux processus.
Cette voie est bi-directionnelle : chaque processus peut envoyer et recevoir des données.

La mise au point de programmes commnuiquants est parfois complexe, c'est pourquoi il est conseillé d'intégrer du code de gestion de toutes les erreurs, et des logs verbeux.
Par ailleurs, l'outil `nc` est bien utile pour effectuer des tests de programmes communiquants. Il est conseillé de se renseigner sur l'utilisation de cet outil.


#  Le serveur se met en écoute

La mise en écoute du serveur peut se faire par la fonction `net.Listen`.
Le programme ci-dessous illustre son utilisation.

```go
package main

import (
    "log"
    "net"
    "time"
)

func main ( ) {
    listener, err := net.Listen("unix", "test.sock")
    if err != nil {
        log.Println("Erreur lors de l'appel à net.Listen : ", err)
        return
    }
    defer func(l net.Listener) {
        l.Close()
        log.Println("Connexion fermée")
    }(listener)
    time.Sleep (10 * time.Second)
}
```

  1. Sans l'exécuter, étudier ce programme et expliquer ce qu'il fait.
  2. Compiler et exécuter le programme. Pendant son exécution, lister le contenu du dossier de travai. Lister à nouveau le contenu du dossier de travail après l'exécution du programme. Commenter.
  3. Lancer deux fois le programme depuis le même dossier de travail en moins de 10s. Commenter.


# Établissement de la connexion : côté serveur

Quand un client demande à se connecter, le serveur doit indiquer au système qu'il accepte la connexion.
Le programme ci-dessous montre comment faire.

```go
package main

import (
    "log"
    "net"
    "time"
)

func main ( ) {
    listener, err := net.Listen("unix", "test.sock")
    if err != nil {
        log.Println("Erreur lors de l'appel à net.Listen : ", err)
        return
    }
    defer func(l net.Listener){
        l.Close()
        log.Println("Adresse d'écoute libérée")
    }(listener)

    cnx, err := listener.Accept()
    if err != nil {
        log.Println("Erreur lors de l'appel à listener.Accept : ", err)
        return
    }
    defer func(c net.Conn){
        c.Close()
        log.Println("Connexion fermée")
    }(cnx)

    log.Println("Client connecté")

    time.Sleep (10 * time.Second)

    return
}
```

  1. Compiler et exécuter le programme. Que constate-t-on ?  Faire le lien avec la documentation de la fonction `Accept`.
  2. Forcer la terminaison du programme en utilisant les signaux Unix (via Ctrl+C ou la commande `kill`). Relancer le programme. Décrire le problème rencontré.
  3. Exécuter à nouveau le programme et utiliser l'outil `nc` pour permettre qu'il se termine normalement.


# Établissement de la connexion : côté client

Le programme ci-dessous donne le code pour un client minimal.

```go
package main 

import (
    "log"
    "net"
)

func main() {
    cnx, err := net.Dial("unix", "test.sock")
    if err != nil {
        log.Println("Erreur lors de l'appel à net.Dial : ", err)
        return
    }
    defer func(c net.Conn){
        c.Close()
        log.Println("Connexion fermée")
    }(cnx)

    log.Println("Connexion ouverte")

    return
}
```

   Compiler le programme, puis exécuter le dans les configurations suivantes :
    - dans le même dossier que le serveur, sans que le serveur soit en cours d'exécution ;
    - dans le même dossier que le serveur, alors que le serveur est en cours d'exécution ;
    - dans un autre dossier de travail que le serveur, alors que le serveur est en cours d'exécution.
    Commenter.


# Faire communiquer les processus

Une fois la connexion établie, les deux processus peuvent communiquer.
Pour cela, l'interface `net.Conn` propose les méthodes `Read` et `Write`, qui permettent d'échanger des données sous la forme de tableaux d'octets. 
Ces fonctions bas niveau nécessitent de manipuler les flux d'octets pour en extraire les messages, ce qui est parfois fastidieux. 
Pour faciliter l'écriture du code, on utilisera donc les fonctions du paquet `bufio`, en particulier `Reader.ReadString` et `Writer.WriteString`.


  1. Sur le modèle de la fonction `send_message` dont le code est fourni ci-dessous, écrire une fonction `receive_message`, qui prend en paramètre une variable de type `bufio.Reader*` et qui retourne un résultat de type `string` et un résultat de type `error`.
     Le caractère `\n` sera utilisé comme délimiteur de messages et sera donc retiré du résultat renvoyé.
  2. En utilisant ces fonctions, créer des programmes qui montrent la communication par des sockets entre deux processus selon le protocole suivant :
    - une fois la connexion établie, le serveur envoie le message `hello` ;
    - sur réception du message `hello`, le client répond par le message `start` ;
    - sur réception du message `start`, le serveur répond par le message `ok` ;
    - sur réception du message `ok`, le client répond par le message `data` ;
    - sur réception du message `data`, le serveur répond par le message `ok` ;
    - sur réception du message `ok`, le client répond par le message `end` ;
    - sur réception du message `end`, le serveur se déconnecte et les programmes se terminent.
  3. Intégrer les modifications suivantes dans le code de vos programmes :
    - une fois le client déconnecté, le serveur ne se termine pas mais se met en attente du client suivant ;
    - le client tire un nombre aléatoire entre 1 et 5 et envoie autant de fois le message `data`, en attendant à chaque fois que le serveur réponde par `ok`.


```go
func send_message(out *bufio.Writer, message string) (error) {
        _, err := out.WriteString(message)
        if err != nil {
            return err
        }
        err = out.Flush()
        if err != nil {
            return err
        }
        log.Println("Envoi du message :", message[0:len(message)-1])
        return nil 
}
```

## Communiquer à travers le réseau

Pour faire communiquer des programmes s'exécutant sur machines situées sur un même réseau, il suffit de changer le protocole de communication (actuellement unix) et l’adresse à laquelle on contacte le serveur (actuellement `test.sock`).

Adapter le programme précédent pour qu'il utilise le protocole TCP.
Le serveur doit écouter sur le port 8080.


## Exercice facultatif 

Modifier le programme précédent : les messages `data` sont maintenant suivi d'une ligne de texte quelconque ne contenant qu'un seul retour à la ligne en dernière position et comportant au plus 256 caractères.
Après avoir envoyé le message `ok`, le serveur envoi un second message contenant la ligne reçue.



