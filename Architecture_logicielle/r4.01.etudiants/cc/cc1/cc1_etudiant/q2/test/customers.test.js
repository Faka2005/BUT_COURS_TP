import assert from "node:assert"
import { describe,it } from "node:test"
import customers from "../data/customers.mjs";

import customersUtils from "../src/customersUtils.mjs";

const sortById = (customers) =>
    customers.sort((c1,c2)=>c1.id - c2.id)
const utils = customersUtils(customers)

describe("Student Customers",()=>{
    it("number",()=>{
        assert.equal(utils.number(),5)
    })
    it("older age",() => {
        assert.equal(utils.olderAge(),82)
    })
    it("oldests ustomers",() => {
        assert.deepEqual(
            sortById(utils.oldestCustomers()), [
                { id: 4, f_name: 'Dev', l_name: 'Currian', gender: 'M', married: true, age: 82, expense: 90, purchased: ['Book'] } ]
        )
    })
    describe("customers who have purchased",()=>{
        it("never",()=>{
            assert.deepEqual(utils.customersWhoPurchased(""),[])
        })
        it("Bag",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Bag")),
                [ customers[2]])
        })
        it("Book",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Book")),[customers[0],customers[2],customers[3]])
        })
        it("Lipstik",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Bag")),[customers[2]])
        })
        it("Nail Polish",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Nail Polish")),[customers[2]])
        })
        it("Shampoo",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Shampoo")),[customers[0]])
        })
        it("Stick",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Stick")),[customers[1]])
        })
        it("Toys",()=>{
            assert.deepEqual(sortById(utils.customersWhoPurchased("Toys")),[customers[0],customers[4]])
        })

    })

})

