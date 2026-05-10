import mongoose from 'mongoose';
import assert from "node:assert"
import { describe, it, before, beforeEach, after } from "node:test"
import { MongoMemoryServer } from 'mongodb-memory-server';
import Position from "../api/model/position.mjs";
import Station from "../api/model/station.mjs";
import stationDAO from "../api/dao/stationDAO.mjs";

let mongod=null
let maConnexion = null

const obj1 = {
    number: 1,
    name: "01011 - BORNE TEST NANTES 1",
    address: "Borne test 1",
    position: new Position({lat:47.19717795172789,lon: -1.5441557290105266}),
    rental_methods: "creditcard",
    bike_stands: 0,
    available_bike_stands: 0,
    available_bikes: 0,
    last_update: Date.parse("2022-05-23T14:41:50+00:00")
}

const obj2 = {
    number: 2,
    name: "01012 - BORNE TEST NANTES 1",
    address: "Borne test 2",
    position: new Position({lat:48.84302835299519,lon:2.354480034006315}),
    rental_methods: "creditcard",
    bike_stands: 0,
    available_bike_stands: 0,
    available_bikes: 0,
    last_update: Date.parse("2022-05-23T14:41:50+00:00")
}

const obj3 = {
    number: 3,
    name: "01013 - BORNE TEST NANTES 3",
    address: "Borne test 2",
    position: new Position({lat:47.206848,lon:-1.526854}),
    rental_methods: "",
    bike_stands: 0,
    available_bike_stands: 0,
    available_bikes: 0,
    last_update: Date.parse("2022-05-23T14:41:50+00:00")
}

describe('DAO', () => {
    before(async ()=>{
        await mongoose.connection.close()
        const {MongoMemoryServer}  = await import('mongodb-memory-server')
        mongod = await MongoMemoryServer.create();
        const uri = mongod.getUri();
        maConnexion = await mongoose.connect(uri)
    })

    beforeEach(async ()=>{
        await stationDAO.deleteAll()
    })

    it('Empty', async () => {
        //console.log(await dao(maCollection).add(new Station(obj1)))
        assert.deepEqual(await stationDAO.findAll(),[])
        assert.equal(await stationDAO.findOne(0),null)
        assert.equal(await stationDAO.delete(0),0)
        assert.equal(await stationDAO.deleteAll(),0)
    });

    it('Add one', async () => {
        const base1 = new Station(obj1)
        const base2 = new Station(obj1)
        assert.deepEqual(await stationDAO.add(base1),base2)
        assert.deepEqual(await stationDAO.findAll(),[base2])
        assert.equal(await stationDAO.delete(base2.number),1)
        assert.deepEqual(await stationDAO.findAll(),[])
    });

    it('Add one twice', async () => {
        const base1 = new Station(obj1)
        const base2 = new Station(obj1)
        assert.deepEqual(await stationDAO.add(base1),base2)
        assert.equal(await stationDAO.add(base1),null)
        assert.deepEqual(await stationDAO.findAll(),[base2])
    });
    it('Add two', async () => {
        const base11 = new Station(obj1)
        const base12 = new Station(obj1)
        const base21 = new Station(obj2)
        const base22 = new Station(obj2)
        assert.deepEqual(await stationDAO.add(base12),base11)
        assert.deepEqual(await stationDAO.findAll(),[base11])
        assert.deepEqual(await stationDAO.add(base22),base21)
        assert.deepEqual((await stationDAO.findAll())
            .sort((s1,s2)=>s1.number - s2.number),[base11,base21])
        assert.equal(await stationDAO.delete(base11.number),1)
        assert.deepEqual(await stationDAO.findAll(),[base21])
    });

    it('Update one with another', async () => {
        const base11 = new Station(obj1)
        const base12 = new Station(obj1)
        const base21 = new Station(obj2)
        const base22 = new Station(obj2)
        const base23 = new Station(obj2)
        assert.deepEqual(await stationDAO.add(base12),base11)
        assert.equal(await stationDAO.update(base12.number,base22),1)
        assert.deepEqual(await stationDAO.findAll(),[base23])
    });
    it('Update self', async () => {
        const base11 = new Station(obj1)
        const base12 = new Station(obj1)
        const base13 = new Station(obj1)
        assert.deepEqual(await stationDAO.add(base12),base11)
        base13.name="test"
        assert.equal(await stationDAO.update(base13.number,base13),1)
        base11.name="test"
        assert.deepEqual(await stationDAO.findAll(),[base11])
    })

    after(async ()=>{
        await mongod.stop()
        maConnexion.disconnect()
            })
});












