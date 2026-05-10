"use strict"
import userDAO from "../api/dao/userDAO.mjs";
import User from "../api/model/userModel.mjs";

"use strict"
import {describe, it, before, beforeEach, after} from "node:test"
import {mongoose} from "mongoose";
import assert from 'node:assert';

let mongod = null
let maConnexion = null


describe("Test du DAO", function () {
    before(async () => {
        await mongoose.connection.close()
        const {MongoMemoryServer} = await import('mongodb-memory-server')
        mongod = await MongoMemoryServer.create();
        const uri = mongod.getUri();
        maConnexion = await mongoose.connect(uri)
    })

    beforeEach(async () => {
        await userDAO.removeAll()
    })

    after(async () => {
        await mongod.stop()
        maConnexion.disconnect()
    })


    it("findAll empty", async () => {

        const users = await userDAO.findAll()
        assert.deepEqual(users, [])
    })

    it("findAll one user", async () => {
        const user1 = new User({login: "JoJo", password: "1234"})
        await userDAO.add(user1)
        const users = await userDAO.findAll()
        assert.deepEqual(users, [user1])
    })

    it("findAll two user", async () => {
        const user1 = new User({login: "JoJo", password: "1234"})
        const user2 = new User({login: "Raoul", password: "1234"})
        await userDAO.add(user1)
        await userDAO.add(user2)
        const users = await userDAO.findAll()
        assert.deepEqual(users, [user1, user2])
    })


    it("Add and reject with bad data ", async () => {
        const user = {jj: 12}
        try {
            await userDAO.add(user)
            assert(false)
        } catch (err) {
            assert.equal(err, 'Not a valid user')
        }
    })

    it("Add valid user", async () => {
        const user = new User({login: "JoJo", password: "1234"})
        const userFromBd = await userDAO.add(user)
        assert.deepEqual(userFromBd, user)
    })

    it("Add existing login", async () => {
        const user = new User({login: "JoJo", password: "1234"})
        await userDAO.add(user)
        try {

            await userDAO.add(user)
            assert(false)
        } catch (err) {
            assert.equal(err, 'User already exists')
        }

    })

    it("Remove existing login", async () => {
        const user = new User({login: "JoJo", password: "1234"})
        await userDAO.add(user)
        assert(await userDAO.removeByLogin(user.login))
    })
    it("Remove unexisting login", async () => {
        assert(!(await userDAO.removeByLogin("XXX")))
    })
    it("Update unexisting login", async () => {
        const user = new User({login: "JoJo", password: "1234"})

        assert.equal(await userDAO.update(user), null)
    })
    it("Update existing login", async () => {
        const user = new User({login: "JoJo", password: "1234"})
        await userDAO.add(user)
        user.password = "4321"
        assert.deepEqual(await userDAO.update(user), user)
    })
})


