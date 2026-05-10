"use strict"
import Humain from "../03_classes/Humain.mjs";
import Etudiant from "../03_classes/Etudiant.mjs";
import Promotion from "./02_promotion.mjs";



const e1 = new Etudiant("Jojo",10)
const e2 = new Etudiant("Raoul",18)


const p1 = new Promotion("S4")
p1.ajouter(e1)
p1.ajouter(e2)
try {
    p1.ajouter(10)
}catch (e) {console.log("ajout impossible")}

try {
    p1.ajouter(e1)
}catch (e) {console.log(e.message)}


console.log(p1)
console.log(p1.moyenne())
console.log(p1.etudiantMoyenneSupPromo())
console.log(p1.etudiantMoyenneInfPromo())
p1.retirer(e1)
console.log(p1)
p1.retirer(e1)
console.log(p1)
p1.vider()
console.log(p1)



