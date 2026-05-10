"use strict"
import fetch from 'node-fetch';
import {HttpsProxyAgent} from 'https-proxy-agent';
const proxy = process.env.https_proxy
let agent = null
if (proxy != undefined) {
console.log(`Le proxy est ${proxy}`)
agent = new HttpsProxyAgent(proxy);
}
else {
//pour pouvoir consulter un site avec un certificat invalide
process.env.NODE_TLS_REJECT_UNAUTHORIZED = "0";
console.log("Pas de proxy trouvé")
}
const urlBase = 'https://jsonplaceholder.typicode.com/'
const url = urlBase+"posts"
let response = agent!=null ? await fetch(url, {agent: agent}):await fetch(url)
let json = await response.json()

console.log(json)