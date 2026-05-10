package hashtables

/**
 * Une premiere implémentation d'une table de hachage,
 * sans gestion des collisions
 *
 * @param <E> le type des éléments manipulés
 * @constructor construit une table de hachage
 * @param size la taille de la table de hachage
 * @param hash la fonction de hachage à utiliser
 */
class SimpleHashtable<E>(
    size: Int,
    hash: (E) -> Int)
    : HashtableA<E>(size, hash) {

    private var table : Array<Any?>

    init {
        table = arrayOfNulls<Any?>(size)
    }

    @Suppress("UNCHECKED_CAST")
    private fun get(index : Int) : E {
        requireNotNull(table[index])
        return (table[index] as E)
    }

    override fun add(element: E): Boolean {
        TODO("Not yet implemented")
    }


    override fun get(element: E): E? {
        TODO("Not yet implemented")
    }

    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(element: E): Boolean {
        TODO("Not yet implemented")
    }


}