"use strict"
import {position1, position2, result1,result2,results,response} from './exercice01.mjs'
import assert from "node:assert";

const p1 = { lon: -1.558921, lat: 47.219854 }
const p2 = { lon: -1.530096, lat: 47.223919}
const d1 = Date.parse("2026-01-20T23:04:41+00:00")
const d2 = Date.parse("2026-01-20T23:04:41+00:00")
const r1 = {
    last_update:  d1,
    available_bike_stands: 13,
    number: 19,
    available_bikes: 2,
    name: "SAINT SIMILIEN",
    address: "1, place Saint Similien",
    rental_methods: null,
    bike_stands: 15,
    position: p1
}

const r2 = {
    last_update:  d2,
    available_bike_stands: 8,
    number: 25,
    available_bikes: 10,
    name: "DALBY",
    address: "61, boulevard Ernest Dalby",
    rental_methods: "creditcard",
    bike_stands: 18,
    position: p2
}
const rs = [r1,r2]
const resp = {
    total_count: 2,
    results: rs
}
assert.deepEqual(position1, p1)
assert.deepEqual(position2, p2)
assert.deepEqual(result1, r1)
assert.deepEqual(result2, r2)
assert.deepEqual(results, rs)
assert.deepEqual(response, resp)

console.log("OK")
