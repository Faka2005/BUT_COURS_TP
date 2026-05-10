import mongoose from 'mongoose';
import assert from "node:assert"
import { describe, it, before, beforeEach, after } from "node:test"
import { MongoMemoryServer } from 'mongodb-memory-server';
import stationController from "../api/controller/stationController.mjs";

let mongod=null
let maConnexion = null

describe('Controlleur', () => {
    before(async () => {
        await mongoose.connection.close()
        const {MongoMemoryServer} = await import('mongodb-memory-server')
        mongod = await MongoMemoryServer.create();
        const uri = mongod.getUri();
        maConnexion = await mongoose.connect(uri)
    })

     it("response",async ()=>{
         assert((await stationController.findAll()).length > 0 )
     })

    after(async ()=>{
        await mongod.stop()
        maConnexion.disconnect()
    })
})

