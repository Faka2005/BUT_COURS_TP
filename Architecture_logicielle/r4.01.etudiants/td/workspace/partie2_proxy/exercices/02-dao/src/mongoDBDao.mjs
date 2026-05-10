"use strict"


import Station from "../src/station.mjs";

const dao = (collection) => {
    const current =
    {
    findAll: async () => {
        
        const data =await collection.findAll()
        return data
    },
    findOne: async (id) => {
        const data =await collection.findOne(id)
        return data
    },
    delete: async (id) => {
        
    },
    deleteAll: async () => {
        return (await collection.deleteMany({}))
    },
    add: async (obj) => {
        //TODO
    },
    update: async (id, obj) => {
        const user =await collection.findOne(id).deleteOne
        if(!user)return null
        
        
    }
}
return current
}
export default dao;
