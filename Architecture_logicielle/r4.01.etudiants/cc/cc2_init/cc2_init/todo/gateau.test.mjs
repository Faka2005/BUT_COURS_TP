"use strict"
import Gateau from "../api/model/GateauModele.mjs";
import assert from "node:assert"
import { describe, it } from "node:test"

describe("Test de Gateau", function () {
    it("creation OK ne leve pas d'exception",  ()=> {
        assert.doesNotThrow(() => {
            const gateau = new Gateau({nom:"Cookie", calories:100})
        })
    })
    it("creation OK Cookie 100 Calories",  ()=> {
        const gateau = new Gateau({nom:"cOOkie", calories:100})
        assert.equal(gateau.nom,"Cookie")
        assert.equal(gateau.calories,100)
        assert.deepEqual(gateau.toJSON(), {nom:"Cookie", calories:100})
    })
    it("creation KO nom incorrecte",  ()=> {
        assert.throws(()=>  new Gateau({nom:"", calories:100}),{message: "Paramètres invalides"})
        assert.throws(()=>  new Gateau({nom:" ", calories:100}),{message: "Paramètres invalides"})
        assert.throws(()=>  new Gateau({nom: null, calories:100}), {message: "Paramètres invalides"})
        assert.throws(()=>  new Gateau({nom: undefined, calories:100}),{message: "Paramètres invalides"})
        assert.throws(()=>  new Gateau({nom: 123, calories:100}),{message: "Paramètres invalides"})
    })
    it("creation KO calories incorrecte",  ()=> {
        assert.throws(()=>  new Gateau({nom:"JoJo", calories:-1}),{message: "Paramètres invalides"})
        assert.throws(()=>  new Gateau({nom:"JoJo", calories: "1"}),{message: "Paramètres invalides"})
    })
})
