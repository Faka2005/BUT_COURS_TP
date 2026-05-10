package algorithme

fun Algorithme(P: Array<IntArray>, n: Int) {
    // =========================
    // Préconditions
    // =========================
    require(P.size == n && P.all { it.size == n }) { "La matrice P doit être carrée n x n" }
    require(n >= 1) { "Le graphe doit contenir au moins un sommet" }

    // =========================
    // Initialisation
    // =========================
    val areteI = IntArray(n + 1)       // Père de chaque sommet 2..n
    val areteM = IntArray(n + 1)       // Sommet interne le plus proche pour chaque sommet externe
    val Nprime = mutableSetOf(1)       // Sommets internes
    val domM = mutableSetOf<Int>()     // Sommets externes

    for (e in 2..n) {
        areteM[e] = 1                  // Initialement, tous reliés au sommet 1
        domM.add(e)
    }

    // =========================
    // Invariant initial
    // =========================
    require(Nprime.contains(1)) { "Erreur : la racine 1 doit être incluse dans Nprime." }
    for (e in domM) {
        val i = areteM[e]
        require(i in Nprime) { "Erreur : sommet externe $e n'a pas de sommet interne valide." }
    }

    var V = n - Nprime.size
    require(V >= 0) { "Erreur : la variante V ne peut pas être négative à l'initialisation." }

    // =========================
    // Boucle principale (Algorithme de Prim)
    // =========================
    while (Nprime.size < n) {
        // =========================
        // Progression
        // =========================
        var minCout = Int.MAX_VALUE
        var eMin = -1
        var iMin = -1

        for (e in domM) {
            val i = areteM[e]
            if (P[e - 1][i - 1] < minCout) {
                minCout = P[e - 1][i - 1]
                eMin = e
                iMin = i
            }
        }

        // Étendre l'arbre
        areteI[eMin] = iMin
        Nprime.add(eMin)
        domM.remove(eMin)

        // Mise à jour des arêtes candidates
        for (e in domM) {
            val i = areteM[e]
            if (P[e - 1][eMin - 1] < P[e - 1][i - 1]) {
                areteM[e] = eMin
            }
        }

        // =========================
        // Invariant
        // =========================
        require(Nprime.contains(1)) { "Erreur : la racine 1 doit toujours être dans Nprime." }
        for (e in domM) {
            val i = areteM[e]
            require(i in Nprime) { "Erreur : sommet externe $e n'a pas de sommet interne proche valide." }
        }

        // =========================
        // Variant
        // =========================
        V = n - Nprime.size
        require(V >= 0) { "Erreur : la variante V ne peut pas être négative." }
    }

    // =========================
    // Postconditions
    // =========================
    for (e in 2..n) {
        require(areteI[e] in 1..n) { "Erreur : le sommet $e n'a pas de père valide." }
    }

    require(Nprime.size == n) { "Erreur : tous les sommets ne sont pas couverts par l'arbre." }
    val nbAretes = areteI.count { it != 0 }  // 0 signifie pas de père
    require(nbAretes == n - 1) { "Erreur : le nombre d'arêtes n'est pas correct." }

    // =========================
    // Affichage final
    // =========================
    println("Arbre de recouvrement minimal :")
    for (e in 2..n) {
        val pere = areteI[e]
        val poids = P[e - 1][pere - 1]
        println("Sommet $e → père $pere (poids $poids)")
    }
}
