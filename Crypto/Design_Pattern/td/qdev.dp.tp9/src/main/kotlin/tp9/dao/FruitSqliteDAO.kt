package tp9.dao

import tp9.model.Fruit

/**
 * connecte à une base de données SQLite pour gérer les fruits
 * @param fullPath le chemin complet vers le fichier SQLite contenant la base de données
 * @param table le nom de la table contenant les fruits
 */
class FruitSqliteDAO(fullPath: String, table: String) : FruitDAO {
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