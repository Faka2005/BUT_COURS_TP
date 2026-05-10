package usinghashtables


/**
 * les méthodes de ISet sont documentées comme celle de  MutableSet :
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/
 */
interface ISet<E> {

    fun add(element: E): Boolean
    fun isEmpty(): Boolean

    fun size(): Int
    fun contains(element: E): Boolean

    fun remove(element: E): Boolean

    fun containsAll(elements: Collection<E>): Boolean
    fun addAll(elements: Collection<E>): Boolean

    fun removeAll(elements: Collection<E>): Boolean

    fun retainAll(elements: Collection<E>): Boolean
}