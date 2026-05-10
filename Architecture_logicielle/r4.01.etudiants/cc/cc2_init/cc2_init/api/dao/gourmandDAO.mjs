import {mongoose, Schema} from 'mongoose';
import Gourmand from "../model/GourmandModele.mjs";
import Gateau from "../model/GateauModele.mjs";

const schema = new mongoose.Schema({
    nom: {type: String, required:true},
    gateaux:
        [{
            gateau: {nom: String, calories: Schema.Types.Int32},
            nombre : Schema.Types.Int32
        }]
})

const MongoGourmand = new mongoose.model('gourmandCollection',schema)

const gourmandAdapter = (obj) => {
    if (obj != null) {
        //obj = obj.toJSON()
        const gourmand = new Gourmand(obj.nom)
        obj.gateaux.forEach(e => {
           while (e.nombre!=0) {
               gourmand.achete(new Gateau(e.gateau))
               e.nombre--
           }
        })
        return gourmand
    }
    return null
}
const projection = { _id: 0, __v:0}

const gourmandDAO = {
    removeAll : async ()=> await MongoGourmand.deleteMany({}),
    findAll: async ()=> {
        const data = await MongoGourmand.find({},projection)

        return data.map((obj)=> gourmandAdapter(obj))
    },
    addOne: async (gourmand)=> {

        if (! (gourmand instanceof Gourmand))
            return Promise.reject("gourmand n'est pas un gourmand")
        if (await gourmandDAO.findOne(gourmand.nom)!=null)
            return Promise.reject("Le gourmand existe déjà")
        try {
            await MongoGourmand.insertOne(gourmand.toJSON())
            return await gourmandDAO.findOne(gourmand.nom)
        } catch (e) {
            return Promise.reject("Gourmand non ajouté")
        }
    },
    findOne: async (nom) => {
        nom = nom.toUpperCase()
        let obj = await MongoGourmand.findOne({nom: nom},projection)
        return gourmandAdapter(obj)
    },
    removeOne: async (nom) => {
        nom = nom.toUpperCase()
        return await MongoGourmand.deleteOne({nom: nom})
    },
    //-----------------------------------------
    //TODO compléter achete
    //---------------------------------------------

    achete:async (nom, gateau) => {
        //TODO
    }


}
export default gourmandDAO
