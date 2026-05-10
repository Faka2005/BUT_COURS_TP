"use strict"
import gourmandDAO from "../dao/gourmandDAO.mjs";

const gourmandController = {
    removeAll: async ()=> await gourmandDAO.removeAll(),
    findAll: async () => await gourmandDAO.findAll(),
    addOne : async (gourmand)=> await gourmandDAO.addOne(gourmand),
    findOne : async (nom) => await gourmandDAO.findOne(nom),
    removeOne: async (nom) => await gourmandDAO.removeOne(nom),
    achete: async (nom, gateau) => await gourmandDAO.achete(nom,gateau)
}
export default gourmandController
