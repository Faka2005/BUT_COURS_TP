import Etudiant from "../03_classes/Etudiant.mjs";
import etudiant from "../03_classes/Etudiant.mjs";

class Promotion {
    nom
    etudiants
    constructor(nom) {
        this.nom = nom
        this.etudiants=[]
    }
    ajouter(etudiant) {

        if (!(etudiant instanceof Etudiant)) {
            throw new Error("etudiant doit-être un étudiant")
        }

        if (this.etudiants.find(e => e == etudiant) != undefined)
            throw new Error("etudiant déjà présent")
        this.etudiants.push(etudiant)
    }

    moyenne() {
        if (this.etudiants.length==0)
            return 0;
        const initialValue = 0;
        const somme = this.etudiants.reduce(
            (accumulator, currentValue) => accumulator + currentValue.note, initialValue
        );
        return somme/this.etudiants.length
    }

    etudiantMoyenneSupPromo() {
        return this.etudiants.filter(e => e.note >= this.moyenne())
    }

    etudiantMoyenneInfPromo() {
        return this.etudiants.filter(e => e.note < this.moyenne())
    }
    retirer(etudiant) {
        if (!(etudiant instanceof Etudiant)) {
            throw new Error("etudiant doit-être un étudiant")
        }
        this.etudiants = this.etudiants.filter(e => e !=etudiant)
    }

    vider() {
        this.etudiants=[]
    }
}

export default Promotion