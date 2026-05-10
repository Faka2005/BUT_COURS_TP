package hashtables

import kotlin.math.abs

/**
 * Classe abstraite représentant une table de hachage abstraite
 *
 * @param <E> le type des éléments manipulés par la table de hachage
 * @param size la taille de la table de hachage
 * @param hash la fonction de hachage à utiliser
 * @constructor la fonction de hachage à appliquer sur les éléments
 * @constructor construit une table de hachage
 */

abstract class HashtableA<E>(
        protected val size: Int,
        protected val hash: (E) -> Int
    ) : IHashtable<E> {

    protected var nbElements = 0
    override fun nbElements(): Int {
        return nbElements
    }

    protected fun index(element: E): Int {
        return abs(hash(element)) % size
    }

}