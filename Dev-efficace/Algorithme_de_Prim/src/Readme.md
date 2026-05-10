
# Algorithme de Prim en Kotlin

## Auteur et date

* **Auteur :** YMAMOU Yassar
* **Date :** 06 janvier 2026

---

## Environnement de développement

* **Langage :** Kotlin 1.9
* **IDE recommandé :** IntelliJ IDEA 2023.3 ou plus récent
* **JDK :** OpenJDK 17+
* **Système d’exploitation :** Windows / Linux / macOS (Kotlin multiplateforme)

---

## Description du programme

Ce programme implémente **l’algorithme de Prim** pour la construction d’un **arbre de recouvrement de poids minimal (ARPM)** dans un graphe **non orienté, connexe et valué positivement**.

* La fonction principale est `Algorithme(P: Array<IntArray>, n: Int)`.
* Les sommets sont numérotés de **1 à n**.
* La matrice `P` contient les **poids des arêtes** entre tous les sommets.

---


## Utilisation pour l’utilisateur (terminal)

1. **Téléchargez le programme complet** :

    * `src/Main.kt`
    * `src/algorithme/Algorithme.kt`
    * `src/Readme.md` (optionnel pour référence)

   Placez-les tous dans un même dossier sur votre ordinateur.

2. **Installer Kotlin** (si ce n’est pas déjà fait) :

    * Pour Linux/macOS : via [SDKMAN](https://sdkman.io/) ou téléchargement sur [Kotlin CLI](https://kotlinlang.org/docs/command-line.html)
    * Pour Windows : installer le Kotlin compiler CLI ou utiliser Kotlin portable

3. **Ouvrir un terminal** dans le dossier où se trouvent les fichiers.

4. **Compiler le programme** :

```bash
kotlinc src/Main.kt src/algorithme/Algorithme.kt -include-runtime -d Algorithme_de_Prim.jar
```

* `src/Main.kt` et `src/algorithme/Algorithme.kt` → chemins relatifs vers les fichiers source
* `-include-runtime` → inclut la JVM dans le `.jar` pour pouvoir exécuter directement
* `-d Algorithme_de_Prim.jar` → nom du fichier exécutable `.jar` généré

5. **Exécuter le programme** :

```bash
java -jar Algorithme_de_Prim.jar
```

6. **Résultat attendu** :

Pour l’exemple fourni dans `Main.kt` :

```
Arbre de recouvrement minimal :
Sommet 2 → père 1 (poids 2)
Sommet 3 → père 5 (poids 1)
Sommet 4 → père 2 (poids 2)
Sommet 5 → père 1 (poids 1)
```

7. **Modifier le graphe** :

* Éditez le tableau `P` dans `Main.kt` pour changer les poids des arêtes.
* Respectez ces règles :

    * `P[i][i] = 0` pour chaque sommet `i`
    * La matrice doit être **symétrique** (`P[i][j] = P[j][i]`)
    * Tous les poids > 0 pour i ≠ j



## Informations pour l’évaluateur / expérimentateur

* Le programme utilise une **approche classique de Prim** avec deux structures principales :

    * `areteI` : tableau contenant le **père de chaque sommet** dans l’arbre
    * `areteM` : tableau contenant pour chaque sommet externe le **sommet interne le plus proche**
* La complexité temporelle est O(n²) dans la version actuelle (sans tas/priority queue).
* Le code est **annoté pédagogiquement** :

    * Préconditions
    * Initialisation
    * Invariant et variante pour la correction
    * Postconditions
* La fonction affiche directement l’ARPM à la console.
