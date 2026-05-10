'use strict'
import { MongoClient } from 'mongodb'
import { MongoMemoryServer } from 'mongodb-memory-server';

//connexion

const mongod = await MongoMemoryServer.create();
const uri = mongod.getUri();
const client = new MongoClient(uri)

try {
    //acces à la BD maBD
    const maBD = client.db("maBD")
    //acces à la collection
    const maCollection= maBD.collection("maCollection")
    //Dans mongodb les schémas ne sont pas obligatoires, cet exemple
    //ne les utilsent pas

    //un document
    const monDocument = {
            title: "Record of a Shriveled Datum",
            content: "No bytes, no problem. Just insert a document, in MongoDB",
        }
    //insertion /!\ le parametre est modifie
    let result = await maCollection.insertOne(monDocument)
    console.log(`I-Un document inséré avec l' _id: ${result.insertedId}`)

    //lecture
    const requete = {title: "Record of a Shriveled Datum"};
    const options = {
         projection: {_id:0,  title: 1, content: 1 },
    };
    const data = await maCollection.findOne(requete, options);
    console.log('findOne : ',data);

    //update
    const updateDoc= {$set: {title: "Enregistrement d'une donnée ratatinée"}}
    result = await maCollection.updateOne(requete, updateDoc, options);
    console.log('update count:',result.modifiedCount)
    //findAll
    const curseur = maCollection.find({})

    // parcours
    for await (const undoc of curseur) {
        console.log(undoc);
    }
    //ou await curseur.toArray()

    //Suppression d'un document
    await maCollection.deleteOne({title: "Enregistrement d'une donnée ratatinée"});
    //suppression de tous les documents
    await maCollection.deleteMany({});
} finally {
        await client.close();
        await mongod.stop();

}




