import assert from "node:assert"
import { describe, it } from "node:test"
import Rabbit from "../src/Rabbit.mjs";
import Animal from "../src/Animal.mjs";


describe("UML",()=>{
    it("parent",()=>{
        assert(Rabbit.prototype instanceof Animal)
    })
describe("Usage",()=>{
    it("construct",()=>{
        const r = new Rabbit("Joe")
        assert.deepEqual(r.toString(),
            JSON.stringify({"name":"Joe","speed":0,"hidden":false}))
    })
    it("hidde",()=>{
        const r = new Rabbit("Joe")
        r.run(10)
        r.hide()
        assert.deepEqual(r.toString(),
            JSON.stringify({"name":"Joe","speed":0,"hidden":true}))
    })
    it("show",()=>{
        const r = new Rabbit("Joe")
        r.run(10)
        r.show()
        assert.deepEqual(r.toString(),
            JSON.stringify({"name":"Joe","speed":10,"hidden":false}))
    })
    it("show after hidden",()=>{
        const r = new Rabbit("Joe")
        r.run(10)
        r.hide()
        r.show()
        assert.deepEqual(r.toString(),
            JSON.stringify({"name":"Joe","speed":0,"hidden":false}))
    })
})


})
