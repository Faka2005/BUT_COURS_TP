"use strict"
import stationFetchDAO from "../dao/stationFetchDAO.mjs";
import stationDAO from "../dao/stationDAO.mjs";
let lastUpdate = null;

const stationController = {
    //met à jour si besoin la BD
    updateBD: async () =>{
        //TODO
    },
    findAll: async () => {
        await stationController.updateBD()
        return await stationDAO.findAll()
    },
    findAllAvailable: async ()=> {
        await stationController.updateBD()
        return await stationDAO.findAllAvailable()
    },
    findAllNear : async (p) => {
        await stationController.updateBD()
        return await stationDAO.findAllNear(p)
    },
    findAllAvailableNear: async (p)=> {
        await stationController.updateBD()
        return await stationDAO.findAllAvailableNear(p)
    },
}
export default stationController
