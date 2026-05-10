package tp9.dao

import tp9.model.Fruit

interface FruitDAO {

    /**
     * Donne tous les fruits stockés, triés par le nom des fruits.
     *
     * @return une liste de fruits.
     *
     * @throws ImportFruitsException si une erreur survient lors de l'importation des données
     */
    fun donneLesFruits(): List<Fruit>


    /**
     * Donne les fruits stockés coutant moins que [prix], triés par le prix des fruits.
     *
     * @param prix le prix plancher.
     * @return une liste de prix.
     *
     * @throws ImportFruitsException si une erreur survient lors de l'importation des données
     */
    fun donneLesFruitsCoutantMoinsQue(prix: Double): List<Fruit>

    /**
     * Donne le fruit nommé [nom] si on le trouve dans le stockage.
     *
     * @param nom le nom du fruit à rechercher.
     * @return le fruit ou [null] si [nom] ne correspond à aucun fruit.
     *
     * @throws ImportFruitsException si une erreur survient lors de l'importation des données
     *
     */
    fun donneLeFruit(nom: String): Fruit?

    /**
     * Enregistre les [fruits] présents dans la liste ; écrase les fruits présent
     * précédemment dans le stockage
     *
     * @param fruits une liste de fruits à enregistrer
     */
    fun enregistreLesFruits(fruits: List<Fruit>)

    /**
     * Ajoute un [fruit] dans le stockage
     *
     * @param fruit le fruit à ajouter
     * @throws FruitDejaPresentException si le fruit est déjà présent dans le stockage
     */
    fun ajouteUnFruit(fruit: Fruit)
}