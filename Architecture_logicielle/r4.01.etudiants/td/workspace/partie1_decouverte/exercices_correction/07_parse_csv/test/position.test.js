import Position from '../src/position.mjs'
import assert from "node:assert"
import { describe, it } from "node:test"

describe("position",()=> {
    it("paramters must have lat and lon ", () => {
        assert.throws(() => new Position({lat:10}),
            {
                name: 'Position Exception'
            })
        assert.throws(() => new Position({lon:10}),
            {
                name: 'Position Exception',
            })
        assert.throws(() => new Position({}),
            {
                name: 'Position Exception',
            })
    })
    it("paramters must be number", () => {
        assert.throws(() => new Position({lat:10, lon: "Hello"}),
            {
                name: 'Position Exception'
            })
        assert.throws(() => new Position({lat:"Hello", lon:10}),
            {
                name: 'Position Exception',
            })
    })
    it ("longitude in [-90,90]", ()=>{
        assert.throws(() => new Position({lat:10, lon:-90.1}),
            {
                name: 'Position Exception',
            })
        assert.throws(() => new Position({lat:10, lon:90.1}),
            {
                name: 'Position Exception',
            })
    })
    it ("latitude in [-180,180]", ()=>{
        assert.throws(() => new Position({lat:-180.1, lon:10}),
            {
                name: 'Position Exception',
            })
        assert.throws(() => new Position({lat:180.1, lon:10}),
            {
                name: 'Position Exception',
            })
    })

    it ("correct parameter",()=>{
        assert.doesNotThrow(()=> new Position())
        assert.doesNotThrow(()=> new Position({lat:10,lon:11}))
    })

    it("toString()",()=>{
        assert.equal(new Position().toString(),'{"lat":0,"lon":0}')
        assert.equal(new Position({lat:10,lon:11}).toString(),'{"lat":10,"lon":11}')
    })

    it("getters",()=>{
        let p1 = new Position()
        assert.equal(p1.latitude,0)
        assert.equal(p1.longitude,0)
        p1 = new Position({lat:10,lon:11})
        assert.equal(p1.latitude,10)
        assert.equal(p1.longitude,11)
    })
    it("distance",()=>{
        assert.equal(new Position().distance(new Position()),0)
        assert.equal(new Position({lat:47.19717795172789,lon:-1.5441557290105266})
            .distance(new Position({lat:48.84302835299519,lon:2.354480034006315})),342802)
    })
})

