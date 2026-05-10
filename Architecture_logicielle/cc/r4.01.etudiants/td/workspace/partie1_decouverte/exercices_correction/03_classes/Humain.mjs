"use strict"
class Humain {
    #nom
    static nbHumain =0
    constructor(nom) {
        this.#nom = nom
        Humain.nbHumain++
    }

    get nom() {
        return this.#nom
    }
}

export default Humain
