"use strict"


import Station from "../src/station.mjs";
import mongoose from "mongoose";
const projection = { _id: 0, __v:0}

//Transforme un objet moogoose en Station
const adapter = (mongooseStation)=>{
    if (mongooseStation == null)
        return null
    mongooseStation = mongooseStation.toJSON()
    mongooseStation.last_update = mongooseStation.last_update.getTime()
    return new Station(mongooseStation)
}

const dao = (model) => {
    const current =
    {
    findAll: async () => {
        //TODO
    },
    findOne: async (id) => {
        //TODO
    },
    delete: async (id) => {
        //TODO
    },
    deleteAll: async () => {
        return (await model.deleteMany({})).deletedCount
    },
    add: async (obj) => {
        //TODO
    },
    update: async (id, obj) => {
        //TODO
    }
}
return current
}
export default dao;
