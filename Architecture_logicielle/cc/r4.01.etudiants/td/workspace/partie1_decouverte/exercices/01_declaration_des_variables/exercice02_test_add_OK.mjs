"use strict"
import response from "./exercice02.mjs"
import assert from "node:assert";



//-------------
// ADD OK
//-------------
const p1 = { lon: -1.5575, lat: 47.19504 }
const d1 = Date.parse("2022-05-23T14:41:50+00:00")
const r1 = {
    last_update: d1,
    available_bike_stands: 0,
    number: 0,
    available_bikes: 0,
    name: "01011 - BORNE TEST NANTES 1",
    address: "Borne test 1",
    rental_methods: null,
    bike_stands: 0,
    position: p1
}

let responseClone = Object.assign({},response)
assert.doesNotThrow(()=> response.add(r1), 'AssertionError')
assert.equal(response.total_count , responseClone.total_count+1)
responseClone.results.push(r1)
assert.deepEqual(response.results, responseClone.results)


