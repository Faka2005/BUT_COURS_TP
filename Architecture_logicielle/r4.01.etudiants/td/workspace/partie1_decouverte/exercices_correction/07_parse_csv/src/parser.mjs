import csv from 'csv-parser'
import fs from "node:fs"
import { writeFile } from 'node:fs/promises';
import Position from "./position.mjs";
import Stations from "./stations.mjs";
import Station from "./station.mjs";
import { Parser } from '@json2csv/plainjs';

const headerMap = new Map([
    ["Dernière mise à jour","last_update"],
    ["Nombre de places disponibles","available_bike_stands"],
    ["Identifiant de la station","number"],
    ["Nombre de vélos disponibles", "available_bikes"],
    ["Nom de la station","name"],
    ["Adresse","address"],
    ["Moyen de paiement","rental_methods"],
    ["Capacité","bike_stands"],
    ["Géolocalisation","position"]
])

const valuesMap = new Map([
    ["last_update",(it)=>Date.parse(it)],
    ["available_bike_stands",  (it)=>parseInt(it)],
    ["number",(it)=>parseInt(it)],
    ["available_bikes", (it)=>parseInt(it)],
    ["rental_methods",  (it)=> it=="null"? "":it],
    ["bike_stands",(it)=>parseInt(it)],
    ["position",(it)=>{
        const tab = it.split(',')
        return new Position({lat: parseFloat(tab[0]), lon: parseFloat(tab[1])})
    }],
])

const parser = {
    import : (file) => new Promise((resolve,reject) => {
        const stationsCopie = new Stations()
        fs.createReadStream(file)
            .pipe(csv({
                separator: ";",
                mapHeaders:({ header, index }) => {
                    return headerMap.get(header.trim()) == undefined ? header.trim() : headerMap.get(header.trim())
                },
                mapValues: ({ header, index, value }) =>
                    valuesMap.get(header) == undefined ? value : valuesMap.get(header)(value)
            }))
            .on('data', (data) => {
                    stationsCopie.add(new Station(data))
                }
            )
            .on('end', () => {
                resolve(stationsCopie)
            });

    }),
    //stations est un tableau de stations
    export : async (file, stations) =>{
        try {
            //suppression du typage
            stations = JSON.parse(JSON.stringify(stations))
            //transformation des types
            stations = stations.map((s)=>{
                s.position = s.position.lat+","+s.position.lon
                s.last_update = new Date(s.last_update)
                return s
            })

            const opts = {
                delimiter: ';',
                fields: Array.from(headerMap).map((s) => {return {label: s[0], value: s[1]}}),
            }
            const parser = new Parser(opts);
            const csv = parser.parse(stations);
            await writeFile(file, csv);

        } catch (err) {
            console.error(err);
        }
    }
}
export default parser
