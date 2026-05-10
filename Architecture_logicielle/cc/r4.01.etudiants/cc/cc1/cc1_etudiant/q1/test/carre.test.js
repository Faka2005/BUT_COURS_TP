import assert from "node:assert"
import { describe, it } from "node:test"
import carre from "../src/carre.mjs";

const carreAMoi=(n)=>n==0?'\n':('*'.repeat(n)+'\n').repeat(n)

describe("Test carre",()=>{
    it("n<0",()=>{
        assert.throws(()=> carre(-1))
    })
    it("n=0",()=>{
        assert.equal(carre(0),'\n')
        assert.equal(carreAMoi(0),'\n')
    })
    it("n=1",()=>{
        assert.equal(carre(1),'*\n')
        assert.equal(carreAMoi(1),'*\n')
    })
    it("n=2",()=>{
        assert.equal(carre(2),'**\n**\n')
        assert.equal(carreAMoi(2),'**\n**\n')
    })
    it("n=2",()=>{
        assert.equal(carre(3),'***\n***\n***\n')
        assert.equal(carreAMoi(3),'***\n***\n***\n')
    })
    it("n=1000",()=>{
        assert.equal(carre(1000),carreAMoi(1000))
    })
})
