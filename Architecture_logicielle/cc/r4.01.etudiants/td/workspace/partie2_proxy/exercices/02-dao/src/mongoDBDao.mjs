"use strict"


import Station from "../src/station.mjs";

const dao = (collection) => {
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
        return (await collection.deleteMany({})).deletedCount
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
