"use strict"
import fetch from 'node-fetch';
import HttpsProxyAgent from 'https-proxy-agent';


const proxy = process.env.https_proxy

let agent = null
if (proxy != undefined) {
    console.log(`Le proxy est ${proxy}`)
    agent =  new HttpsProxyAgent(proxy);
}
else {
    //pour pouvoir consulter un site avec un certificat invalide
    process.env.NODE_TLS_REJECT_UNAUTHORIZED = "0";
    console.log("Pas de proxy trouvé")
}

const urlBase = 'https://data.nantesmetropole.fr/api/explore/v2.1/catalog/datasets/244400404_disponibilite-temps-reel-velos-libre-service-naolib-nantes-metropole/'
const url = urlBase+"records?where=rental_methods%3D\"creditcard\"%20%20and%20available_bikes!%3D\"0\"&limit=-1"

console.log("urlBase:", urlBase)
let response = agent!=null ? await fetch(url, {agent: agent}):await fetch(url)
let json = await response.json()

const nbPage = (json.total_count/100)
const data = json.results
for(let page=1; page < nbPage;page++){
    console.log(page)
    response = agent!=null ? await fetch(url, {agent: agent}):await fetch(url+"&offset="+page*100)
    json = await response.json()
    data.push(...json.results)
}


const getDistanceBetweenPoints=(latitude1, longitude1, latitude2, longitude2, unit = 'miles')=> {
    let theta = longitude1 - longitude2;
    let distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
        Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) +
        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
    );
    if (unit == 'miles') {
        return Math.round(distance, 2);
    } else if (unit == 'kilometers') {
        return Math.round(distance * 1.609344, 2);
    }
}
const X = 47.216671
const Y = -1.55
console.log(data.length)
console.log(data)
console.log(data.sort((c1,c2)=>
    getDistanceBetweenPoints(c1.position.lat,c1.position.lon,X,Y,'kilometers')
    -
    getDistanceBetweenPoints(c2.position.lat,c2.position.lon,X,Y,'kilometers')
))
