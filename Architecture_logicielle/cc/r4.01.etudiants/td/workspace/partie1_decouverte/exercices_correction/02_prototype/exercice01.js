"use strict"
const Animal = function (nom) {
    this.nom = nom
}

Animal.prototype.crie = function () {
    return this.nom+" crie"
}


const Chien = function (nom) {
    Animal.call(this,nom)
}

Chien.prototype = Object.create(Animal.prototype);

Chien.prototype.constructor = Chien;

Chien.prototype.crie  = function () {
    return Animal.prototype.crie.call(this)+ " wawa";
}


const raoul = new Chien("Raoul")
console.log(raoul.crie(), raoul)

