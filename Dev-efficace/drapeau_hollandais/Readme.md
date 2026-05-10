## Avant compilation


## Explication du code

### Préconditions

```kotlin
require(T.isNotEmpty()) { "T ne doit pas être vide" }
require(T.all { it in setOf('R', 'W', 'B') }) { "Le tableau doit contenir uniquement 'R', 'W' ou 'B'" }
```

* Le tableau `T` ne doit pas être vide.
* Les éléments doivent être uniquement `'R'` (rouge), `'W'` (blanc) ou `'B'` (bleu).
  Cela correspond aux **3 couleurs du drapeau hollandais**.

---

### Initialisation

```kotlin
val S = T.copyOf()      // sauvegarde du sac initial
var low = 0             // limite gauche pour les rouges
var mid = 0             // indice courant
var high = T.size - 1   // limite droite pour les bleus
```

* `S` est une **copie du tableau original** pour vérifier que les éléments sont conservés.
* `low` : indice où finiront les `'R'` à gauche.
* `mid` : indice de l'élément que l’on examine.
* `high` : indice où finiront les `'B'` à droite.

---

### Boucle principale

```kotlin
while (mid <= high) {
    when (T[mid]) {
        'R' -> { // rouge
            echange(T, low, mid)
            low++
            mid++
        }
        'W' -> { // blanc
            mid++
        }
        'B' -> { // bleu
            echange(T, mid, high)
            high--
        }
    }
}
```

1. Si l’élément courant est `'R'` :
   On l’échange avec la limite gauche `low`, puis on avance `low` et `mid`.

2. Si l’élément est `'W'` :
   Il est déjà au bon endroit (zone du milieu), on avance juste `mid`.

3. Si l’élément est `'B'` :
   On l’échange avec la limite droite `high` et on décrémente `high`.
   **Important :** `mid` ne bouge pas car l’élément échangé doit encore être examiné.

**Invariant de boucle :**

* Tous les `'R'` sont à gauche (`T[0..low-1]`).
* Tous les `'W'` sont au milieu (`T[low..mid-1]`).
* Les éléments non examinés sont entre `mid` et `high`.
* Tous les `'B'` sont à droite (`T[high+1..N-1]`).

---

### Postconditions

```kotlin
check(T.sortedArray().contentEquals(S.sortedArray())) {
    "Le sac des éléments n'est pas conservé"
}

assert(T.takeWhile { it == 'R' }.all { it == 'R' })
assert(T.dropWhile { it == 'R' }.takeWhile { it == 'W' }.all { it == 'W' })
assert(T.dropWhile { it != 'B' }.all { it == 'B' })
```

* Vérifie que **tous les éléments du tableau initial sont conservés**.
* Vérifie que tous les `'R'` sont à gauche, `'W'` au milieu, `'B'` à droite.

---

## Tests

### Test 1 : Mélange classique

```kotlin
fun main() {
    val T = arrayOf('B', 'R', 'W', 'B', 'R', 'W', 'R', 'B')
    println("Avant tri : ${T.contentToString()}")
    val T_tri = drapeau_hollandais(T)
    println("Après tri  : ${T_tri.contentToString()}")
}
```

**Sortie attendue :**

```
Avant tri : [B, R, W, B, R, W, R, B]
Après tri  : [R, R, R, W, W, B, B, B]
```

---





## Compilation du projet

Depuis le dossier racine du projet, exécuter la commande suivante :

```bash
kotlinc src -include-runtime -d tri_insertion_selection.jar
```


## Exécution du programme

Lancer ensuite le programme avec :

```bash
java -ea -jar drapeau_hollandais.jar
```

🔹 L’option `-ea` active les assertions utilisées dans le code.

---

##  Résultat attendu

Le programme affiche le tableau trié à l’écran, par exemple :

```text
[0, 1, 2, 25, 32, 84, 87]
```
