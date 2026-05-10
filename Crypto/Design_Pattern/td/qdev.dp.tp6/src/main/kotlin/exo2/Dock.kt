package exo2

/* NE PAS MODIFIER CETTE CLASSE */

/**
 * représente un dock, cest-à-dire un emplacment où garer des vaisseaux
 * encapsule un tableau en ne laissant acessible que 2 méthodes get() et set()
 *
 * implémentation du design pattern Proxy
 */

class Dock(val size : Int, private val elements : Array<Dockable>) {

    operator fun get(index: Int): Dockable {
        return elements[index]
    }

    operator fun set(index: Int, element: Dockable) {
        elements[index] = element
    }
}