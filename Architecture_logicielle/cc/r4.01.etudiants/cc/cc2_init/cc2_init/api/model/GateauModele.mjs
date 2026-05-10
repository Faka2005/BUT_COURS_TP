import ErreureGateau from "./ErreureGateau.mjs";
/**
 * Un Gateau est défini par un nom et des calories.
 */
export default class Gateau {
    #nom
    #calories
    constructor(obj) {
        const keys = Object.keys(obj).sort()
        if (keys.length !=2 || keys[0]!="calories" || keys[1]!="nom"
            || !Number.isInteger(obj.calories) || !(typeof obj.nom === 'string' || obj.nom instanceof String)
        || obj.calories < 0)
            throw new ErreureGateau("Paramètres invalides")
        const trim = obj.nom.trim()
        if (trim.length==0)
            throw new ErreureGateau("Paramètres invalides")
        this.#nom = obj.nom.charAt(0).toUpperCase() + obj.nom.slice(1).toLowerCase();
        this.#calories = obj.calories
    }

    get nom() {
        return this.#nom
    }

    get calories() {
        return this.#calories
    }

    toJSON() {
        return {
            nom : this.#nom,
            calories : this.#calories
        }
    }
}
