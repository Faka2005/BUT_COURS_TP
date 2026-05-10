'use strict'
import mongoose from 'mongoose';
import { MongoMemoryServer } from 'mongodb-memory-server';

//connexion

const mongod = await MongoMemoryServer.create();
const uri = mongod.getUri();
//connexion sur mabd
await mongoose.connect(mongod.getUri(),{dbName: "maBD"})
//Dans mmongoose les schema sont obligatoires

try {
    const monSchema = new mongoose.Schema({
        title: String,
        content: String
    });

    const monModel = mongoose.model('document', monSchema);
    const document = new monModel(
        {title: "Record of a Shriveled Datum",
        content: "No bytes, no problem. Just insert a document, in MongoDB"});
    //insertion /!\ le document est modifié
    await document.save()
    console.log("insertion",document) //l'objet a été modifié
    const requete = {title: "Record of a Shriveled Datum"};
    //lecture
    const projection = { _id: 0, __v:0 }
    console.log("findOne",await monModel.findOne(requete,projection))

    //update
    //save repose sur les midleware et la validation
    //updateMany Non
    document.title="Enregistrement d'une donnée ratatinée"
    await document.save();

    //findAll
    console.log(await monModel.find({},projection))

    //Suppression d'un document
    await monModel.deleteOne({title: "Enregistrement d'une donnée ratatinée"});
    //suppression de tous les documents
    await monModel.deleteMany({});
    console.log(await monModel.find({},projection))
}finally {

   await mongoose.disconnect();
   await mongod.stop();
}
