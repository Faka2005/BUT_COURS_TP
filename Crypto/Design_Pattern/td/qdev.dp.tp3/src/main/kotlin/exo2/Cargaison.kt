package exo2

abstract class Cargaison (private val distance : Int)  {

    private var encombrementActuel = 0.0
    private val marchandises = mutableListOf<Marchandise>()

    enum class CARGAISON (val limite : Double, val facteur : Int) {
        FLUVIALE(300_000.0, 1),
        ROUTIERE(38_000.0, 4),
        AERIENNE(80_000.0, 10)
    }

    fun ajouter(marchandise : Marchandise) : Boolean {
        TODO()
    }

    fun cout() {
        TODO()
    }
    fun rechercher(marchandise : Marchandise) {
        TODO()
    }

    fun encombrement(marchandise : Marchandise) : Double {
        TODO()
    }

    fun limite() : Double {
        TODO()
    }

    fun facteur() : Int {
        TODO()
    }

    companion object {
        fun donne(distance : Int, type : CARGAISON, urgente : Boolean = false) : Cargaison {
            TODO()
        }
    }

}