"use strict"

const Etudiant = function (nom='John Do',note=0){
    this.nom = nom
    this.note = note

    this.setNote = function (note) {
        this.note = note
    }

}

const etudiant1 = new Etudiant()
console.log("objet",etudiant1)
console.log("typeof",typeof etudiant1)
console.log("instanceof Etudiant", etudiant1 instanceof Etudiant)
console.log("instanceof Object", etudiant1 instanceof Object)
//objet Etudiant { nom: 'John Do',
//  note: 0, setNote: [Function (anonymous)] }
// typeof object
// instanceof Etudiant true
// instanceof Object true

//ajout d'un attrbut en propre
etudiant1.age = 20;
console.log("etudiant1 age en propre", etudiant1)

//etudiant1 age en propre Etudiant {
//   nom: 'John Do',
//   note: 0,
//   setNote: [Function (anonymous)],
//   age: 20
// }

//Le deuxième étudiant n'a pas d'age
const etudiant2 = new Etudiant("etudiant2",20)
console.log("etudiant 2 sans age",etudiant2)

//etudiant 2 sans age Etudiant {
//   nom: 'etudiant2',
//   note: 20,
//   setNote: [Function (anonymous)]
// }

//Fallback
//le prototype est modifié mais pas l'objet
//l'attribut est en propre n'est pas modifié
Etudiant.prototype.age = 10
console.log("etudiant1 age non modifié",etudiant1)
console.log("etudiant1 prototype",Object.getPrototypeOf(etudiant1))
//etudiant1 age non modifié Etudiant {
//   nom: 'John Do',
//   note: 0,
//   setNote: [Function (anonymous)],
//   age: 20
// }
//etudiant1 prototype { age: 10 }

//ajout du poids au prototype
Etudiant.prototype.poids = 80

console.log("etudiant1 avec poids", etudiant1.poids)
//etudiant1 avec poids 80
console.log(Object.getPrototypeOf(etudiant1))




