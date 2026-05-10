
import assert from "node:assert"
import { describe, it } from "node:test"
import parser from "../src/parser.mjs";
import fs from 'node:fs/promises';
import stations from "../src/stations.mjs";

describe("parser",()=> {
    it("import", async () => {
        const res = await  parser.import(
            './data/244400404_disponibilite-temps-reel-velos-libre-service-naolib-nantes-metropole.csv')
        let data1 =res.stations
        let data2 = JSON.parse(await fs.readFile(
            "./data/244400404_disponibilite-temps-reel-velos-libre-service-naolib-nantes-metropole.json", { encoding: 'utf8' }))
        //transformation des date String en timeStamp, transformation null de rental methode en "", ..;
        data2 = data2.map(data => {
            data.last_update = Date.parse(data.last_update)
            data.available_bikes = parseInt(data.available_bikes)
            data.available_bike_stands = parseInt(data.available_bike_stands)
            data.number = parseInt(data.number)
            data.available_bikes = parseInt(data.available_bikes)
            data.rental_methods= data.rental_methods==null?"":data.rental_methods
            data.bike_stands = parseInt(data.bike_stands)
            return data
        })

        data1.sort((s1,s2)=>s1.number-s2.number);
        data2.sort((s1,s2)=>s1.number-s2.number);


        assert.deepEqual(data1.sort((s1,s2)=>s1.number-s2.number),data2.sort((s1,s2)=>s1.number-s2.number) )
    })

    it("export",async ()=>{
        const stations1 = await  parser.import(
            './data/244400404_disponibilite-temps-reel-velos-libre-service-naolib-nantes-metropole.csv')

        await parser.export("./data/export.csv",stations1.stations)
        const stations2 = await  parser.import(
            './data/244400404_disponibilite-temps-reel-velos-libre-service-naolib-nantes-metropole.csv')
        assert.equal(stations1.size, stations2.size)
        assert.deepEqual(stations1.stations.sort((s1,s2)=>s1.number-s2.number),stations2.stations.sort((s1,s2)=>s1.number-s2.number) )

    })
})

