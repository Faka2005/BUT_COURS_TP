"use strict"
import response from "./exercice02.mjs"
import assert from "node:assert";

assert.doesNotThrow(() => response.clear())
assert.equal(response.total_count,0)
assert.deepEqual(response.results, [])

console.log("OK")


