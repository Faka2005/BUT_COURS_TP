package Calcul

fun division_euclidienne(a: Int, b: Int): Pair<Int, Int> {

    // Préconditions
    require(a >= 0) { "a doit être un entier naturel" }
    require(b > 0) { "b doit être strictement positif" }

    // Initialisation
    var q = 0
    var r = a

    // Invariant : a = q*b + r && r >= 0
    check(a == q * b + r && r >= 0)

    // Algorithme
    while (r >= b) {
        val oldR = r

        // Progression
        r -= b
        q += 1

        // Invariant
        check(a == q * b + r && r >= 0)

        // Variant (décroissant)
        assert(r < oldR)
    }

    // Postcondition
    assert(a == q * b + r)
    assert(r in 0 until b)

    return Pair(q, r)
}
