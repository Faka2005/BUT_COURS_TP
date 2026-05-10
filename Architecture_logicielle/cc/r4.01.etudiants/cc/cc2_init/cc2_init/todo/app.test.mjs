"use strict"
import { describe, it, before, beforeEach, after } from "node:test"
import supertest from "supertest"
import server from "../server.mjs";
import {mongoose} from "mongoose";
import assert from "node:assert";


let mongod=null
let maConnexion = null
const requestWithSupertest = supertest(server)
const APIPATH = process.env.API_PATH || '/api/v0'

describe("Test de l'application", function () {
    before(async () => {
        await mongoose.connection.close()
        const {MongoMemoryServer} = await import('mongodb-memory-server')
        mongod = await MongoMemoryServer.create();
        const uri = mongod.getUri();
        maConnexion = await mongoose.connect(uri)
    })
    beforeEach(async () => {
        const response = await requestWithSupertest.delete(APIPATH+"/gourmand");
    })

    after(async () => {
        await mongod.stop()
        maConnexion.disconnect()
    })



    //-------------------------------------------------------------
    // TODO Ajouter vos tests
    //-------------------------------------------------------------

    it("DELETE un gourmand existant", async  ()=> {
        const gourmand = {nom: "user"}
        const result = await requestWithSupertest.delete(APIPATH+"/gourmand/user")
        assert.deepEqual(result.status, 200)
    });

    it("DELETE un gourmand inexistant", async  ()=> {
        const result = await requestWithSupertest.delete(APIPATH+"/gourmand/user")
        assert.deepEqual(result.status, 404)
    });

})
