package tp9.dao

import tp9.model.Fruit
import java.io.File

/**
 * Lit/écrit dans un fichier .CSV pour gérer les fruits
 * @param fichier le fichier .CSV contenant les fruits
 */
class FruitCsvDAO(private val fichier: File) : FruitDAO {
    override fun donneLesFruits(): List<Fruit> {
        TODO("Not yet implemented")
    }

    override fun donneLesFruitsCoutantMoinsQue(prix: Double): List<Fruit> {
        TODO("Not yet implemented")
    }

    override fun donneLeFruit(nom: String): Fruit? {
        TODO("Not yet implemented")
    }

    override fun enregistreLesFruits(fruits: List<Fruit>) {
        TODO("Not yet implemented")
    }

    override fun ajouteUnFruit(fruit: Fruit) {
        TODO("Not yet implemented")
    }


}