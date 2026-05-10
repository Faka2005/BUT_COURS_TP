package exo2

/* NE PAS MODIFIER CETTE CLASSE */

enum class TypeVaisseau(val tonnage: Int) {
    CHASSEUR(30),
    CORVETTE(100),
    CARGO(50_000),
    FREGATE(3_000),
    CROISEUR(10_000),
}