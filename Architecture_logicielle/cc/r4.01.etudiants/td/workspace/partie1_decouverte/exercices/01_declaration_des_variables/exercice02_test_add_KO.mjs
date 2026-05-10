"use strict"
import response from "./exercice02.mjs"
import assert from "node:assert";
import {results} from "./exercice01.mjs";

const firstLevelAttributNames= [
    "last_update",
    "available_bike_stands",
    "number",
    "available_bikes",
    "name",
    "address",
    "rental_methods",
    "bike_stands",
    "position"]

const firstLevelAttributTypes=
    [
        "number",//last_update,
        "number",//available_bike_stands
        "number",//number,
        "number",//available_bikes
        "string",//name,
        "string",//address
        "object",// rental_methods
        "number",// bike_stands
        "object" //Position
]

//-------------
// ADD existing
//-------------
const p1 = { lon: -1.5575, lat: 47.19504 }
const d1 = Date.parse("2022-05-23T14:41:50+00:00")
const r1 = {
    last_update: d1,
    available_bike_stands: 0,
    number: 25,
    available_bikes: 0,
    name: "01011 - BORNE TEST NANTES 1",
    address: "Borne test 1",
    rental_methods: null,
    bike_stands: 0,
    position: p1
}
let responseClone = Object.assign({},response)
assert.throws(()=> response.add(r1), 'AssertionError')
assert.deepEqual(response,responseClone)

//-------------
// ADD Missing attribut
//-------------

let r2 = {}
firstLevelAttributNames.forEach((name)=> {
    r2 = Object.assign({},r1)
    r2.number=0
    delete r2.name
    assert.throws(()=> response.add(r2),'AssertionError')
    assert.deepEqual(response,responseClone)
})

r2 = Object.assign({},r1)
r2.number=0
delete r2.position.lat
assert.throws(()=> response.add(r2), 'AssertionError')
assert.deepEqual(response,responseClone)

r2 = Object.assign({},r1)
r2.number=0
delete r2.position.lon
assert.throws(()=> response.add(r2), 'AssertionError')
assert.deepEqual(response,responseClone)

//-------------
// ADD wrong type
//-------------

for (let i=0; i < firstLevelAttributNames.length;i++) {
    r2 = Object.assign({},r1)
    r2.number=0
    r2[firstLevelAttributNames[i]]=BigInt("0")
    assert.throws(()=> response.add(r2), 'AssertionError')
    assert.deepEqual(response,responseClone)
}//-------------


r2 = Object.assign({},r1)
r2.number=0
r2.position.lat = BigInt("0")
assert.throws(()=> response.add(r2), 'AssertionError')         // modification de l'objet précédent add()
assert.deepEqual(response,responseClone)


r2 = Object.assign({},r1)
r2.number=0
r2.position.lat = 0                                            // remise a 0 pour éviter que l'assert de la latitude se déclenche
r2.position.lon = BigInt("0")
assert.throws(()=> response.add(r2), 'AssertionError')         // modification de l'objet précédent add()
assert.deepEqual(response,responseClone)

console.log("OK")
