"use strict"
import Humain from "./Humain.mjs";
import Etudiant from "./Etudiant.mjs";
import Promotion from "./Promotion.mjs";

const h1 = new Humain("Jojo")
const h2 = new Humain("Raoul")

console.log(Humain.nbHumain)
console.log(h1.nom)

const e1 = new Etudiant("Jojo",10)
const e2 = new Etudiant("Raoul",18)

console.log(e1,e2)

const p1 = new Promotion("S4")
p1.ajouter(e1)
p1.ajouter(e2)
try {
    p1.ajouter(10)
}catch (e) {console.log("ajout impossible")}
console.log(p1)
p1.vider()
console.log(p1)



