import ErreureGourmand from "./ErreureGourmand.mjs";
import Gateau from "./GateauModele.mjs";
/**
 * Un gourmand a un nom et peut avoir des gateaux,
 * deux gateaux ne peuvent avoir le même nom.
 * Le nom est stocké en majuscule.
 */
export default class Gourmand {
    /**
     * Le nom
     */
    #nom
    /**
     * un tableau d'objets au format {gateau: un_gateau, nombre: le_nombre_de_gateaux_correspondant}
     */
    #gateaux
    constructor(nom) {
        if (nom==null || nom == undefined  ||
            !(typeof nom === 'string' || nom instanceof String) || nom.trim().length==0)
            throw new ErreureGourmand("Nom non valide")
        this.#nom = nom.toUpperCase()
        this.#gateaux=[]
    }

    get nom() {
        return this.#nom
    }

    /**
     * Renvoie les gateaux trié par nom puis par calories croissants
     * @returns {*}
     */
    get gateaux(){
        return this.#gateaux.toSorted((e1,e2)=>{
            if (e1.gateau.nom < e2.gateau.nom)
                return -1
            if (e1.gateau.nom > e2.gateau.nom)
                return 1
            //cas impossible ici
            return e1.gateau.calories - e2.gateau.calories
        })
    }
    achete(gateau){
        if (! (gateau instanceof Gateau))
            throw ErreureGourmand("Seul des gateaux peuvent-être mangés")

        const index = this.#gateaux.findIndex((element) => element.gateau.nom == gateau.nom)
        if (index == -1)
            this.#gateaux.push({gateau: new Gateau(gateau.toJSON()), nombre: 1})
        else {
            if (this.#gateaux[index].gateau.calories != gateau.calories)
                throw new ErreureGourmand("Un gateau avec le même nom et des calories différentes existe déja")
            this.#gateaux[index]={
                gateau : this.#gateaux[index].gateau,
                nombre : this.#gateaux[index].nombre+1
            }
        }
    }
    mange(nom){
        nom = nom.charAt(0).toUpperCase() + nom.slice(1).toLowerCase()
        const index = this.#gateaux.findIndex((element) => element.gateau.nom == nom)
        if (index == -1)
            throw new ErreureGourmand("Le gateau n'est pas présent")
        if (this.#gateaux[index].nombre ==1)
            this.#gateaux.splice(index, 1)
        else
            this.#gateaux[index].nombre--

    }

    /**
     * Renvoie le JSON associé, les gateaux sont triés
     * @returns {{nom, gateaux: *}}
     */
    toJSON() {
        return {
            nom: this.#nom,
            gateaux: this.gateaux.map(e=>{
                return {
                    gateau : e.gateau.toJSON(),
                    nombre : e.nombre
                }
            })
        }
    }

    /**
     * Renvoie true si le grourmand dispose de plus de 1000 Calories en gateaux.
     * @returns {boolean}
     */
    estEnDanger(){
        return this.#gateaux.reduce((acc,e)=>acc+e.gateau.calories*e.nombre,0)>1000

    }
}
