"use strict"

import User from '../api/model/userModel.mjs'
import { describe, it} from "node:test"
import assert from "node:assert";

describe("Test du model User", function () {
    it("create", async ()=> {
        const user = new User({login: "JoJo", password: "1234"})
        assert.equal(user.login, 'JoJo')

        assert.equal(user.password,'1234')
        assert.deepEqual(Object.keys(user).sort(), ['login','password'])
    })
});
