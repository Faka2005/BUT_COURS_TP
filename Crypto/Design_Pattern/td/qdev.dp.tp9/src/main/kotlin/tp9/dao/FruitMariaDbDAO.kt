package tp9.dao

import tp9.model.Fruit

/**
 * connecte à une base de données MariaDB/MySQL pour gérer les fruits
 * @param host l'adresse du serveur hébergeant la base de données
 * @param database le nom de la base de données
 * @param user le nom de l'utilisateur
 * @param password le mot de passe de l'utilisateur
 * @param table le nom de la table contenant les fruits
 */
class FruitMariaDbDAO(host: String, database: String, user: String, password: String, table: String) : FruitDAO {

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