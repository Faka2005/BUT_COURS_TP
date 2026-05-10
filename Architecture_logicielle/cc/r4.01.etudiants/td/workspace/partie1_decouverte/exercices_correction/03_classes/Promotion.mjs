import Etudiant from "./Etudiant.mjs";

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
        this.etudiants.push(etudiant)
    }
    vider() {
        this.etudiants=[]
    }
}

export default Promotion