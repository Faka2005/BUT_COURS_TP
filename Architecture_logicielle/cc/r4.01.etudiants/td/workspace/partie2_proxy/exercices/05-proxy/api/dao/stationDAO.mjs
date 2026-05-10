import {mongoose} from 'mongoose';
import Station from "../model/station.mjs";
import {Int32} from "mongodb";


const monSchema = new mongoose.Schema({
    number: Int32,
    name: String,
    address: String,
    //position: positionSchema,
    position: {lat: Number,lon: Number},
    rental_methods: String,
    bike_stands: Int32,
    available_bike_stands: Int32,
    available_bikes: Int32,
    last_update: Date
});

const projection = { _id: 0, __v:0}

//Transforme un objet moogoose en Station
const adapter = (mongooseStation)=>{
    if (mongooseStation == null)
        return null
    mongooseStation = mongooseStation.toJSON()
    mongooseStation.last_update = mongooseStation.last_update.getTime()
    return new Station(mongooseStation)
}

const model = mongoose.model('Station', monSchema);

const last_update = null
const stationDAO = {
    findAll: async () => {
        return (await model.find({}, projection)).map(obj => adapter(obj))
    },
    findAllNear: async (p)=> {
        const data = await stationDAO.findAll()
        return data.sort((s1,s2)=>s1.position.distance(p) - s2.position.distance(p))
    },
    findAllAvailable: async () => {
        return (await model.find({available_bikes : {$gt: 0}}, projection)).map(obj => adapter(obj))
    },
    findAllAvailableNear: async (p) => {
        const data = await stationDAO.findAllAvailable()
        return data.sort((s1,s2)=>s1.position.distance(p) - s2.position.distance(p))
    },
    findOne: async (id) => {
        let res = await model.findOne({number: id}, projection)
        return adapter(res)
    },
    delete: async (id) => {
        return (await model.deleteOne({number: id})).deletedCount
    },
    deleteAll: async () => {
        return (await model.deleteMany({})).deletedCount
    },
    add: async (obj) => {
       const res = await stationDAO.findOne(obj.number)
        if (res != null)
            return null
        await model.insertOne(obj)
        return  stationDAO.findOne(obj.number)
    },
    addMany : async (objs)  => {
      return await model.insertMany(objs)
    },
    update: async (id, obj) => {
        const station = await stationDAO.findOne(id)
        if (station == null)
            return null
        return ((await model.updateOne({number: id}, {$set: obj})).modifiedCount)
    }
}
export default stationDAO
