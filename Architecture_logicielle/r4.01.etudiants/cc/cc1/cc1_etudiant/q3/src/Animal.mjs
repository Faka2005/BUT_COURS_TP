/**
 * Un animal est représenté par
 * @private #speed sa vitesse
 * @private #name son nom
 */
export default class Animal {
    /**
     * La vitesse
     * @type number
     */
    #speed
    /**
     * Le nom
     * @type string
     */
    #name

    /**
     * Permet de construire un animal avec un nom choisi et une vitesse de 0
     * @param name le nom choisi
     * @throws Error si le nom choisi n'est pas une string
     */
    constructor(name) {
        if (! typeof name == "string" )
            throw new Error()
        this.#speed = 0;
        this.#name = name;
    }

    /**
     * Permet de modifier la vitesse
     * @param speed la vitesse choisie
     * @type number
     * @throws Error si la vitesse choisie est négative
     */
    run(speed) {
        if (this.speed < 0)
            throw new Error()
        this.#speed = speed;
    }

    /**
     * Permet de stopper l'animal
     * La vitesse passe à 0
     */
    stop() {
        this.#speed = 0;
    }

    /**
     * getter pour la vitesse
     * @returns la vitesse
     */
    get speed (){
        return this.#speed
    }

    /**
     * getter pour le nom
     * @returns le nom
     */
    get name (){
        return this.#name
    }
}
