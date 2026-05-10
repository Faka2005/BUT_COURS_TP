import Humain from "./Humain.mjs";
class Etudiant  extends Humain{
    note
    constructor(nom, note) {
        super(nom)
        this.note = note
    }
}

export default Etudiant