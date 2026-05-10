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

//Utilise l'environnement du serveur (TEST, DEV, PROD)
describe("GET /airports", function () {
    before(async () => {
        await mongoose.connection.close()
        const {MongoMemoryServer} = await import('mongodb-memory-server')
        mongod = await MongoMemoryServer.create();
        const uri = mongod.getUri();
        maConnexion = await mongoose.connect(uri)
    })


    after(async ()=>{
        await mongod.stop()
        maConnexion.disconnect()
    })
    it("GET /station", async ()=> {
        const response = await requestWithSupertest.get(APIPATH+"/station");
        assert.equal(response.status,200)
        assert(response.body.length>0)

    });

});


