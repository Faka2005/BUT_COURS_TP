package tp9.dao

import tp9.model.Fruit

/**
 * connecte à une base de données H2 pour gérer les fruits
 *  @param fullPath le chemin complet vers le fichier H2 contenant la base de données (sans l'extension .mv.db)
 *  @param table le nom de la table contenant les fruits
 */
class FruitH2DAO(fullPath: String, table: String) : FruitDAO {
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