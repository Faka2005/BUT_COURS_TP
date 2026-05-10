import algorithme.Algorithme

fun main() {
    // Exemple : graphe avec 5 sommets
    val n = 5
    // Matrice des poids P[i][j] (0 si i == j, symétrique car graphe non orienté)
    val P = arrayOf(
        intArrayOf(0, 2, 3, 3, 1),
        intArrayOf(2, 0, 4, 2, 3),
        intArrayOf(3, 4, 0, 5, 1),
        intArrayOf(3, 2, 5, 0, 7),
        intArrayOf(1, 3, 1, 7, 0)
    )

    // Appel de l'algorithme de Prim
    Algorithme(P, n)
}
