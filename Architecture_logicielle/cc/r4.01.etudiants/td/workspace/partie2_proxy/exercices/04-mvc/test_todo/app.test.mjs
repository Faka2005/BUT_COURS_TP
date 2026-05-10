"use strict"
import { describe, it, before, beforeEach, after } from "node:test"
import supertest from "supertest"
import server from "../server.mjs";
import {mongoose} from "mongoose";
import assert from "node:assert";

let mongod=null
let maConnexion = null
const requestWithSupertest = supertest(server)


//Utilise l'environnement du serveur (TEST, DEV, PROD)
describe("Test de l'application", function () {
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
    it("GET /user", async ()=> {
        const response = await requestWithSupertest.get("/api/v0/user");
        assert.equal(response.status,200)

    });

    it("GET /user/XXX not found", async  ()=> {
        const response = await requestWithSupertest.get("/api/v0/user/XXX");
        assert.equal(response.status,404)
        assert.deepEqual(response.body,{ message: 'user not found' })

    });

    it("POST /user add a valid user", async  ()=> {
        const response = await requestWithSupertest.post("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJo', password: 'pass'})
        assert.equal(response.status,201)
        assert.deepEqual(response.body,{login: 'JoJo', password: 'pass'})
    });

    it("POST /user add a invalid user wrong attribut", async  ()=> {
        const response = await requestWithSupertest.post("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login2: 'JoJo', password: 'pass'})
        assert.equal(response.status,400)
        assert.deepEqual(response.body,{message: "not added"})
    });

    it("POST /user add a invalid user missing attribut on existing login", async  ()=> {
        const response = await requestWithSupertest.post("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJo'})
        assert.equal(response.status,400)
        assert.deepEqual(response.body,{message: "not added"})
    });

    it("POST /user an existing user", async  ()=> {
        const response = await requestWithSupertest.post("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJo', password : '4321'})
        assert.equal(response.status,400)
        assert.deepEqual(response.body,{message: "not added"})
    });

    it("DELETE /user an existing user", async  ()=> {
        const response = await requestWithSupertest.delete("/api/v0/user/JoJo")

        assert.equal(response.status,200)
        assert.deepEqual(response.body,{message: "user deleted"})
    });

    it("DELETE /user an unexisting user", async  ()=> {
        const response = await requestWithSupertest.delete("/api/v0/user/XXXX")
        assert.equal(response.status,400)
        assert.deepEqual(response.body,{message: "user not deleted"})
    });

    it("GET /user find an existing user", async  ()=> {
        await requestWithSupertest.delete("/api/v0/user/JoJo")
        await requestWithSupertest.post("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJo', password : '4321'})
        const response = await requestWithSupertest.get("/api/v0/user/JoJo")
        assert.equal(response.status,200)
        assert.deepEqual(response.body,{login: 'JoJo', password : '4321'})
    });

    it("PUT /user update an existing user with correct parameters", async  ()=> {
        const response = await requestWithSupertest.put("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJo', password : '1234'})

        assert.equal(response.status,200)
        assert.deepEqual(response.body,{login: 'JoJo', password : '1234'})
    });

    it("PUT /user update an existing user with missing parameters", async  ()=> {
        const response = await requestWithSupertest.put("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJo'})

        assert.equal(response.status,400)
        assert.deepEqual(response.body,{ message: 'invalid paramters'})
    });

    it("PUT /user update an unexisting user with correct parameters", async  ()=> {
        const response = await requestWithSupertest.put("/api/v0/user")
            .set('Content-type', 'application/json')
            .send({login: 'JoJoX', password: '1234'})

        assert.equal(response.status,400)
        assert.deepEqual(response.body,{ message: 'not updated'})
    });
});

