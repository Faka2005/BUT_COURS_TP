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

response.clear = function () {
    //TODO
}


export default response




