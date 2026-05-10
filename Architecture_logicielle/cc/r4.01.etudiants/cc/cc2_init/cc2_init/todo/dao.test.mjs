import mongoose from 'mongoose';
import assert from "node:assert"
import {describe, it, before, beforeEach, after} from "node:test"
import {MongoMemoryServer} from 'mongodb-memory-server';

let mongod = null
let maConnexion = null

import Gourmand from "../api/model/GourmandModele.mjs";
import gourmandDAO from "../api/dao/gourmandDAO.mjs";
import Gateau from "../api/model/GateauModele.mjs";


describe("tests du DAO", function () {
    before(async () => {
        await mongoose.connection.close()
        const {MongoMemoryServer} = await import('mongodb-memory-server')
        mongod = await MongoMemoryServer.create();
        const uri = mongod.getUri();
        maConnexion = await mongoose.connect(uri)
    })

    beforeEach(async () => {
        await gourmandDAO.removeAll()
    })

    after(async () => {
        await mongod.stop()
        maConnexion.disconnect()
    })
    it("Pas de Gourmand", async () => {
        const gourmands = await gourmandDAO.findAll()
        assert.deepEqual(gourmands, [])
        const gourmandXXX = await gourmandDAO.findOne("XXXX")
        assert.equal(gourmandXXX, null)
    })

    it("Un gourmand sans  gateaux", async () => {
        const gourmand = new Gourmand("Jo")
        let gourmandR = await gourmandDAO.addOne(gourmand)
        assert.deepEqual(gourmandR.toJSON(), gourmand.toJSON())
        gourmandR = await gourmandDAO.findOne(gourmand.nom)
        assert.deepEqual(gourmandR.toJSON(), gourmand.toJSON())
        const gourmands = await gourmandDAO.findAll()
        assert.equal(gourmands.length, 1)
        assert.deepEqual([gourmands[0].toJSON()], [gourmand.toJSON()])
    })
    it("Un gourmand avec des gateaux", async () => {
        const gourmand = new Gourmand("Jo")
        gourmand.achete(new Gateau({nom: "Cookie1", calories: 100}))
        gourmand.achete(new Gateau({nom: "Cookie2", calories: 200}))
        gourmand.achete(new Gateau({nom: "Cookie1", calories: 100}))
        gourmand.achete(new Gateau({nom: "Cookie1", calories: 100}))

        let gourmandR = await gourmandDAO.addOne(gourmand)

        assert.deepEqual(gourmandR.toJSON(), gourmand.toJSON())
        gourmandR = await gourmandDAO.findOne(gourmand.nom)
        assert.deepEqual(gourmandR.toJSON(), gourmand.toJSON())
        const gourmands = await gourmandDAO.findAll()
        assert.equal(gourmands.length, 1)
        assert.deepEqual([gourmands[0].toJSON()], [gourmand.toJSON()])
    })
    it("Des gourmands", async () => {
        const gourmand1 = new Gourmand("Jo")
        gourmand1.achete(new Gateau({nom: "Cookie1", calories: 100}))
        gourmand1.achete(new Gateau({nom: "Cookie2", calories: 200}))
        gourmand1.achete(new Gateau({nom: "Cookie1", calories: 100}))
        gourmand1.achete(new Gateau({nom: "Cookie1", calories: 100}))
        const gourmand2 = new Gourmand("Raoul")
        gourmand2.achete(new Gateau({nom: "Pomme", calories: 0}))
        const gourmandR1 = await gourmandDAO.addOne(gourmand1)
        const gourmandR2 = await gourmandDAO.addOne(gourmand2)
        const gourmands = await gourmandDAO.findAll()

        assert.deepEqual(
            gourmands
                .sort((g1, g2) => g1.nom < g2.nom ? -1 : g1.nom > g2.nom ? 1 : 0)
                .map(g => g.toJSON()),
            [gourmand1.toJSON(), gourmand2.toJSON()])
    })

    it("Add KO gourmand existant", async () => {
        const gourmand1 = new Gourmand("Jo")
        await gourmandDAO.addOne(gourmand1)
        try {
            await gourmandDAO.addOne(gourmand1)
            assert(false)
        } catch (e) {
            assert.deepEqual(e, "Le gourmand existe déjà")
        }
    })
    it("Add KO pas un gourmand ", async () => {
        try {
            await gourmandDAO.addOne({xx: 44})
            assert(false)
        } catch (e) {
            assert.deepEqual(e, "gourmand n'est pas un gourmand")
        }
    })

    it("achete OK ne léve pas d'exception", async () => {
        const gourmand1 = new Gourmand("Romeo")
        await gourmandDAO.addOne(gourmand1)
        const gateau = new Gateau({nom: "Cookie", calories: 100})

        try {
            await gourmandDAO.achete("Romeo", gateau)
        } catch (e) {
            assert(false)
        }
    })

    it("achete OK un gateau",async ()=>{
            const gourmand = new Gourmand("Romeo")
            await gourmandDAO.addOne(gourmand)
            const gateau =new Gateau({nom:"Cookie", calories:100})
            await gourmandDAO.achete("Romeo",gateau)

            const gourmandR = await gourmandDAO.findOne("Romeo")
            assert.deepEqual(
                gourmandR.toJSON(),
                {
                    nom: "ROMEO",
                    gateaux: [{
                        gateau: {nom: "Cookie", calories:100},
                        nombre : 1
                    }]
                }
            )
        })

        it("achete OK deux fois le même gateau",async()=>{
            const gourmand = new Gourmand("user")
            const gateau =new Gateau({nom:"Cookie", calories:100})
            await gourmandDAO.addOne(gourmand)
            await gourmandDAO.achete("user",gateau)
            await gourmandDAO.achete("user",gateau)
            const gourmandR = await gourmandDAO.findOne("user")
            assert.deepEqual(
                gourmandR.toJSON(),
                {
                    nom: "USER",
                    gateaux: [{
                        gateau: {nom: "Cookie", calories:100},
                        nombre : 2
                    }]
                }
            )
        })

        it("achete OK deux fois le même gateau et un troisième",async ()=>{
            const gourmand = new Gourmand("user")
            const gateau1 =new Gateau({nom:"Cookie", calories:100})
            const gateau2 =new Gateau({nom:"Chocolatine", calories:10})
            await gourmandDAO.addOne(gourmand)
            await gourmandDAO.achete("user",gateau1)
            await gourmandDAO.achete("user",gateau2)
            await gourmandDAO.achete("user",gateau1)
            const gourmandR = await gourmandDAO.findOne("user")
            assert.deepEqual(
                gourmandR.toJSON(),
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

        it("achete KO achete deux gateau avec le même nom et des calories différentes",async ()=>{
            const gourmand = new Gourmand("user")
            await gourmandDAO.addOne(gourmand)
            const gateau1 =new Gateau({nom:"Cookie", calories:100})
            const gateau2 =new Gateau({nom:"Cookie", calories:10})
            await gourmandDAO.achete("user",gateau1)
            try {
                await gourmandDAO.achete("user",gateau2)
                assert(false)
            }
            catch(e) {
                assert.equal(e, "Achat impossible")
            }
            const gourmandR = await gourmandDAO.findOne("user")
            assert.deepEqual(
                gourmandR.toJSON(),
                {
                    nom: "USER",
                    gateaux: [{
                        gateau: {nom: "Cookie", calories:100},
                        nombre : 1
                    }]
                })
        })

//---------------------------------------------
//TODO Ajouter vos test de removeOne Ici
//---------------------------------------------
    it("Suppression KO vide (pas de gourmand)", async () => {
        const result = await gourmandDAO.removeOne("user")
        assert.equal(result.deletedCount, 0)
        
    })

    it("Suppression KO gourmand non présent", async () => {
        const result = await gourmandDAO.removeOne("user")
        assert.equal(result.deletedCount, 0)
    })

    it("Suppression OK un gourmand présent parmi un", async () => {
        const gourmand = new Gourmand("user")
        await gourmandDAO.addOne(gourmand)
        const result = await gourmandDAO.removeOne("user")
        assert.equal(result.deletedCount, 1)
        
    })

    it("Suppression OK un gourmand présent parmi deux", async () => {
        const gourmand1 = new Gourmand("user1")
        const gourmand2 = new Gourmand("user2")
        await gourmandDAO.addOne(gourmand1)
        await gourmandDAO.addOne(gourmand2)
        const result = await gourmandDAO.removeOne("user1")
        assert.equal(result.deletedCount, 1)
        
    })
})
