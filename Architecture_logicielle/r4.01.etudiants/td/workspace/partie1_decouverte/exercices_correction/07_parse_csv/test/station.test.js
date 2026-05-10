import Station from '../src/station.mjs'
import assert from "node:assert"
import { describe, it } from "node:test"
import Position from "../src/position.mjs";

describe("station",()=> {
    let s1 = {}
    it("empty paramter",
        ()=>{
            assert.throws(()=>new Station(s1),{
                name: 'Station Exception'
            })
        })

    const base = {
        number: 0,
        name: "01011 - BORNE TEST NANTES 1",
        address: "Borne test 1",
        position: new Position(),
        bike_stands: 0,
        available_bike_stands: 0,
        available_bikes: 0,
        last_update: Date.parse("2022-05-23T14:41:50+00:00"),
        rental_methods: ""
    }
    let test = null
    it("missing attribut",
        ()=>{
            Object.keys(base).forEach((key)=>{
                test = Object.assign({},base)
                delete test[key]
                assert.throws(()=>new Station(test),{
                    name: 'Station Exception'
                })
            })
        })
    it("wrong type attribut",
        ()=>{
            Object.keys(base).forEach((key)=>{
                test = Object.assign({},base)
                test[key]=BigInt(0)
                assert.throws(()=>new Station(test),{
                    name: 'Station Exception'
                })
            })
        })
    it("wrong date",
        ()=>{
                test = Object.assign({},base)
                test.last_update=NaN
                assert.throws(()=>new Station(test),{
                    name: 'Station Exception'
                })
        })

    it("OK",
        ()=>{
            test = Object.assign({},base)
            assert.doesNotThrow(()=>new Station(test))
            assert.deepEqual(test,base)

        })


})
