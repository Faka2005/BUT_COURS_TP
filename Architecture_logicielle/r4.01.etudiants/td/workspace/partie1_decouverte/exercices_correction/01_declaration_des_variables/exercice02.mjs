"use strict"

import {response} from "./exercice01.mjs";
import assert from "node:assert";

const firstLevelAttributNames= ["last_update",
    "available_bike_stands",
    "number",
    "available_bikes",
    "name",
    "address",
    "rental_methods",
    "bike_stands",
    "position"]
const firstLevelAttributTypes= ["number",
    "number",
    "number",
    "number",
    "string",
    "string",
    "object",
    "number",
    "object"]
/* version simple
response.add = function (result) {
        //Ne marche que si les attributs sont dans l'ordre
        assert.deepEqual(Object.keys(result),firstLevelAttributNames)
        for (let i=0; i < firstLevelAttributNames.length;i++) {
            assert.equal(typeof result[firstLevelAttributNames[i]], firstLevelAttributTypes[i])
        }
        assert.deepEqual(Object.keys(result.position),["lon","lat"])
        assert.equal(typeof result.position.lon,"number")
        assert.equal(typeof result.position.lat, "number")
        assert.equal(this.results.map((r)=>r.number).includes(result.number),false)
        this.results.push(result)
        this.total_count++
}
*/
/* version map */
response.add = function (result) {
    //verification des attributs et des types
    const mapExpected = new Map()
    firstLevelAttributNames.forEach((s, pos) => mapExpected.set(s, firstLevelAttributTypes[pos]))
    const mapResult = new Map()
    Object.keys(result).forEach(name => mapResult.set(name, typeof result[name]))
    assert.deepEqual(mapResult, mapResult)
    //cas de la position
    assert.deepEqual(Object.keys(result.position),["lon","lat"])
    assert.equal(typeof result.position.lon,"number")
    assert.equal(typeof result.position.lat, "number")

    //unicite de number
    assert(!this.results.map((r)=>r.number).includes(result.number))
    //insertion
    this.results.push(result)
    this.total_count++
}
    response.clear = function () {
    this.total_count=0
    this.results=[]
}
export default response




