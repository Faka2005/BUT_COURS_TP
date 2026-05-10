import Animal from "./Animal.mjs";

/**
 * Un Lapin est un animal qui peut se cacher,
 * un lapin caché à une vitesse de 0
 */
export default class Rabbit extends Animal {
    /**
     * @type boolean
     * @private
     * true si caché
     */
    #hidden

    /**
     * Peremt de contruire le lapin
     * visible avec une vitesse de zéro et
     * un nom chosi
     * @param name le nom choisi
     * @type string
     */
    constructor(name) {
        super(name)
        this.#hidden=false
    }

    /**
     * Permet au lapin se cacher,
     * un lapin caché est arrété
     */
    hide(){
        this.stop()
        this.#hidden=true
        
    }

    /**
     * Permet de rendre le lapin visible
     */
    show(){
        this.#hidden=false
    }

    /**
     * Pour les tests
    */
    toString(){
        return JSON.stringify(
            {name: super.name, speed: super.speed, hidden: this.#hidden})
    }
}
