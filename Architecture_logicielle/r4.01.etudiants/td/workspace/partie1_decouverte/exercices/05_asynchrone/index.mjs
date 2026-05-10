"use strict"
import fetch from 'node-fetch';
import {HttpsProxyAgent} from 'https-proxy-agent';


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
//TODO
