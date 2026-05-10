import assert from "node:assert"
import { describe, it } from "node:test"
import Stations from "../src/stations.mjs";
import Station from "../src/station.mjs";
import Position from "../src/position.mjs";
const obj1 = {
    number: 1,
    name: "01011 - BORNE TEST NANTES 1",
    address: "Borne test 1",
    position: new Position({lat:47.19717795172789,lon:-1.5441557290105266}),
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
    rental_methods: "",
    bike_stands: 0,
    available_bike_stands: 0,
    available_bikes: 0,
    last_update: Date.parse("2022-05-23T14:41:50+00:00")
}

const obj3 = {
    number: 3,
    name: "01013 - BORNE TEST NANTES 3",
    address: "Borne test 2",
    position: new Position({lat: 47.206848,lon:-1.526854}),
    rental_methods: "",
    bike_stands: 0,
    available_bike_stands: 0,
    available_bikes: 0,
    last_update: Date.parse("2022-05-23T14:41:50+00:00")
}
describe("Stations",()=>{
    it("empty",()=>{
        const stations = new Stations()
        assert.equal(stations.size,0)
        assert.deepEqual(stations.stations,[] )
    })
    it("add bad",()=>{
        const base = new Stations()
        const temp = structuredClone(base)
        assert.throws(()=> base.add({}),{
            name: 'Station Exception'
        })
        assert.deepEqual(base, temp)
    })
    it("add One OK",()=>
    {
        const station = new Station(obj1)
        const stations = new Stations()
        assert.doesNotThrow(()=>stations.add(station))
        assert.equal(stations.size,1)
        assert.deepEqual(stations.stations,[station])
    })
    it("add same twice",()=>
    {
        const station = new Station(obj1)
        const stations = new Stations()
        assert.doesNotThrow(()=>stations.add(station))
        assert.throws(()=>stations.add(station),{
            name: 'Stations Exception'
        })

        assert.equal(stations.size,1)
        assert.deepEqual(stations.stations,[station])
    })
    it("add two ok",()=>
    {
        const station1 = new Station(obj1)
        const station2 = new Station(obj2)
        const stations = new Stations()
        assert.doesNotThrow(()=>stations.add(station1))
        assert.equal(stations.size,1)
        assert.deepEqual(stations.stations,[station1])
        assert.doesNotThrow(()=>stations.add(station2))
        assert.equal(stations.size,2)
        assert.deepEqual(stations.stations,[station1,station2])
    })
    it("remove empty",()=>{
        const stations = new Stations()
        assert.throws(()=>stations.remove(0),{
            name: 'Stations Exception'
        })
    })
    it("remove unknow ",()=>{
        const stations = new Stations()
        const station1 = new Station(obj1)
        assert.doesNotThrow(()=>stations.add(station1))
        assert.throws(()=>stations.remove(0),{
            name: 'Stations Exception'
        })
        assert.equal(stations.size,1)
        assert.deepEqual(stations.stations,[station1])
    })
    it("remove bad type",()=>{
            const stations = new Stations()
        const station1 = new Station(obj1)
        assert.doesNotThrow(()=>stations.add(station1))
        assert.throws(()=>stations.remove({}),{
            name: 'Stations Exception'
        })
        assert.equal(stations.size,1)
        assert.deepEqual(stations.stations,[station1])
    })
    it("remove bad ok",()=>{
        const stations = new Stations()
        const station1 = new Station(obj1)
        assert.doesNotThrow(()=>stations.add(station1))
        assert.doesNotThrow(()=>stations.remove(station1.number),{
            name: 'Stations Exception'
        })
        assert.equal(stations.size,0)
        assert.deepEqual(stations.stations,[])
    })
    it("distance  self 1 ",()=>{
        const stations = new Stations()
        const station1 = new Station(obj1)
        stations.add(station1)
        assert.deepEqual(stations.sortByDistanceFrom(station1.position),[station1])
    })
    it("distance  self 2 ",()=>{
        const stations = new Stations()
        const station1 = new Station(obj1)
        const station2 = new Station(obj2)
        stations.add(station1)
        stations.add(station2)
        assert.deepEqual(stations.sortByDistanceFrom(station1.position),[station1,station2])
        assert.deepEqual(stations.sortByDistanceFrom(station2.position),[station2,station1])
    })
    it("distance 3 ",()=>{
        const stations = new Stations()
        const station1 = new Station(obj1)
        const station2 = new Station(obj2)
        const station3 = new Station(obj3)
        stations.add(station1)
        stations.add(station2)
        stations.add(station3)
        assert.deepEqual(stations.sortByDistanceFrom(station1.position),[station1,station3,station2])

    })
    it("distance bad type ",()=>{
        const stations = new Stations()
        const station1 = new Station(obj1)
        stations.add(station1)
        assert.throws(()=>stations.sortByDistanceFrom("jj"),{
            name: 'Stations Exception'
        })
    })
})
