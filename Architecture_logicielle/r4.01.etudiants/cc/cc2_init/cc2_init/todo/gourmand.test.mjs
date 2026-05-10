"use strict"
import Gateau from "../api/model/GateauModele.mjs";
import assert from "node:assert"
import { describe, it } from "node:test"
import Gourmand from "../api/model/GourmandModele.mjs";

describe("Test de Gourmand", function () {
    it("creation OK ne leve pas d'exception",  ()=> {
        assert.doesNotThrow(() => {
            const gourmand = new Gourmand("user")
        })
    })
    it("creation OK Cookie 100 Calories",  ()=> {
        const gourmand = new Gourmand("user")
        assert.equal( gourmand.nom,"USER")
        assert.deepEqual(gourmand.gateaux,[])
    })
    it("creation KO nom incorrecte",  ()=> {
        assert.throws(()=>  new Gourmand(""),{message: "Nom non valide"})
        assert.throws(()=>  new Gourmand(" "),{message: "Nom non valide"})
        assert.throws(()=>  new Gourmand(null), {message: "Nom non valide"})
        assert.throws(()=>  new Gourmand(undefined),{message: "Nom non valide"})
        assert.throws(()=>  new Gourmand(123),{message: "Nom non valide"})
    })
    it("achete OK ne léve pas d'exception",()=>{
        assert.doesNotThrow(() => {
            const gourmand = new Gourmand("user")
            const gateau =new Gateau({nom:"Cookie", calories:100})
            gourmand.achete(gateau)
        })
    })

    it("achete OK un gateau",()=>{
            const gourmand = new Gourmand("user")
            const gateau =new Gateau({nom:"Cookie", calories:100})
            gourmand.achete(gateau)
            assert.deepEqual(
                gourmand.toJSON(),
                {
                    nom: "USER",
                    gateaux: [{
                        gateau: {nom: "Cookie", calories:100},
                        nombre : 1
                    }]
                }
            )
        })

    it("achete OK deux fois le même gateau",()=>{
        const gourmand = new Gourmand("user")
        const gateau =new Gateau({nom:"Cookie", calories:100})
        gourmand.achete(gateau)
        gourmand.achete(gateau)
        assert.deepEqual(
            gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 2
                }]
            }
        )
    })

    it("achete OK deux fois le même gateau et un troisième",()=>{
        const gourmand = new Gourmand("user")
        const gateau1 =new Gateau({nom:"Cookie", calories:100})
        const gateau2 =new Gateau({nom:"Chocolatine", calories:10})
        gourmand.achete(gateau1)
        gourmand.achete(gateau2)
        gourmand.achete(gateau1)
        assert.deepEqual(
            gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Chocolatine", calories:10},
                    nombre : 1
                },
                    {
                        gateau: {nom: "Cookie", calories:100},
                        nombre : 2
                    }]
            }
        )
    })

    it("achete KO achete deux gateau avec le même nom et des calories différentes",()=>{
        const gourmand = new Gourmand("user")
        const gateau1 =new Gateau({nom:"Cookie", calories:100})
        const gateau2 =new Gateau({nom:"Cookie", calories:10})
        gourmand.achete(gateau1)
        assert.throws(()=>gourmand.achete(gateau2),{message: "Un gateau avec le même nom et des calories différentes existe déja"})
        assert.deepEqual(
            gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 1
                }]
            })
    })

    it("mange ok un gateau en quantité 1 parmi 1",()=>{
        const gourmand = new Gourmand("user")
        const gateau1 =new Gateau({nom:"Cookie", calories:100})
        gourmand.achete(gateau1)
        gourmand.mange(gateau1.nom)
        assert.deepEqual(gourmand.gateaux,[])
    })


    it("mange ok un gateau en quantité 2 parmi 1",()=>{
        const gourmand = new Gourmand("user")
        const gateau1 =new Gateau({nom:"Cookie", calories:100})
        gourmand.achete(gateau1)
        gourmand.achete(gateau1)
        assert.deepEqual(gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 2
                }]
            })
        gourmand.mange(gateau1.nom)
        assert.deepEqual(gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 1
                }]
            })
    })

    it("mange ok un gateau en quantité 1 parmi 2",()=>{
        const gourmand = new Gourmand("user")
        const gateau1 =new Gateau({nom:"Cookie", calories:100})
        const gateau2 =new Gateau({nom:"Chocolatine", calories:10})
        gourmand.achete(gateau1)
        gourmand.achete(gateau2)
        assert.deepEqual(gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Chocolatine", calories:10},
                    nombre : 1
                },{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 1
                }]
            })
        gourmand.mange(gateau1.nom)

        assert.deepEqual(
            gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Chocolatine", calories:10},
                    nombre : 1
                }]
            })
    })

    it("mange ok un gateau en quantité 2 parmi 2",()=>{
        const gourmand = new Gourmand("user")
        const gateau1 =new Gateau({nom:"Cookie", calories:100})
        const gateau2 =new Gateau({nom:"Chocolatine", calories:10})
        gourmand.achete(gateau1)
        gourmand.achete(gateau1)
        gourmand.achete(gateau2)
        assert.deepEqual(gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Chocolatine", calories:10},
                    nombre : 1
                },{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 2
                }]
            })
        gourmand.mange(gateau1.nom)
        assert.deepEqual(gourmand.toJSON(),
            {
                nom: "USER",
                gateaux: [{
                    gateau: {nom: "Chocolatine", calories:10},
                    nombre : 1
                },{
                    gateau: {nom: "Cookie", calories:100},
                    nombre : 1
                }]
            })
    })

    it("mange ko un gateau non present",()=>{
        const gourmand = new Gourmand("user")
        assert.throws(()=>gourmand.mange("A"))
    })

    it("Est en ganger",()=>{
        const gourmand = new Gourmand("user")
        assert(!gourmand.estEnDanger())
        gourmand.achete(new Gateau({nom:"Cookie1", calories:500}))
        assert(!gourmand.estEnDanger())
        gourmand.achete(new Gateau({nom:"Cookie2", calories:500}))
        assert(!gourmand.estEnDanger())
        gourmand.achete(new Gateau({nom:"Radis", calories:1}))
        assert(gourmand.estEnDanger())
        gourmand.mange("radis")
        assert(!gourmand.estEnDanger())

    })

})
