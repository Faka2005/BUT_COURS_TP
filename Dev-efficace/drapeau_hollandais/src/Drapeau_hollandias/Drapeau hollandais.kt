package Drapeau_hollandais

fun drapeau_hollandais(T: Array<Char>): Array<Char> {

    // =========================
    // Préconditions
    // =========================
    require(T.isNotEmpty()) { "T ne doit pas être vide" }
    require(T.all { it in setOf('R', 'W', 'B') }) { "Le tableau doit contenir uniquement 'R', 'W' ou 'B'" }

    // =========================
    // Initialisation
    // =========================
    val S = T.copyOf()      // sauvegarde du sac initial
    var low = 0             // limite gauche pour les rouges
    var mid = 0             // indice courant
    var high = T.size - 1   // limite droite pour les bleus

    // =========================
    // Algorithme (invariant similaire)
    // =========================
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

    // =========================
    // Postconditions
    // =========================
    check(T.sortedArray().contentEquals(S.sortedArray())) {
        "Le sac des éléments n'est pas conservé"
    }

    assert(T.takeWhile { it == 'R' }.all { it == 'R' })
    assert(T.dropWhile { it == 'R' }.takeWhile { it == 'W' }.all { it == 'W' })
    assert(T.dropWhile { it != 'B' }.all { it == 'B' })

    return T
}
