## Avant compilation
Modifier les données du tableau T avec vos données que vous voulez 

## Compilation du projet

Depuis le dossier racine du projet, exécuter la commande suivante :

```bash
kotlinc src -include-runtime -d tri_insertion_selection.jar
```


## Exécution du programme

Lancer ensuite le programme avec :

```bash
java -ea -jar tri_insertion_selection.jar
```

🔹 L’option `-ea` active les assertions utilisées dans le code.

---

##  Résultat attendu

Le programme affiche le tableau trié à l’écran, par exemple :

```text
[0, 1, 2, 25, 32, 84, 87]
```


