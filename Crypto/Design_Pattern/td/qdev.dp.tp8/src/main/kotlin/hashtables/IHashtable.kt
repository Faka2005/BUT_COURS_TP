package hashtables

interface IHashtable<E> {

    /**
     * ajout d'un élément dans la table de hachage
     *
     * @param element élément à ajouter
     * @return true si l'élément est ajouté / false si l'élément est déjà présent
     * @throws CollisionException s'il y a une collision non traitée, cad qu'un autre élément est
     * déjà présent dans la table et qu'on ne peut rien faire
     */
    fun add(element: E): Boolean

    /**
     * recherche un élément dans la table de hachage
     *
     * @param element élément à rechercher
     * @return true si l'élément est présent, false sinon
     */
    operator fun contains(element: E): Boolean

    /**
     * donne l'élément dans la table de hachage égal à l'élément passé en paramètre
     *
     * @param element l'élément à rechercher
     * @return l'élément correspondant à celui passé en paramètre, null si l'élément n'est pas présent
     */
    fun get(element: E): E?

    /**
     * remove l'élément dans la table de hachage
     *
     * @param element l'élément à remove
     * @return true si l'élément est supprimé / false si l'élément n'est pas présent
     */
    fun remove(element: E): Boolean

    /**
     * donne le nombre d'elements ajoutés dans la table de hachage
     * @return le nombre d'éléments contenus dans la table
     */
    fun nbElements() : Int

    /**
     * @return le nombre de collisions évitées
     */
    fun avoidedCollisions() : Int {
        return 0
    }
}
