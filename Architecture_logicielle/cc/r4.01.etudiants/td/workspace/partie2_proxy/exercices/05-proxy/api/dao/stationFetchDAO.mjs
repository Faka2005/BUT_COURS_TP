import fetch from 'node-fetch';
import HttpsProxyAgent from 'https-proxy-agent';
import Station from "../model/station.mjs";
import Position from "../model/position.mjs";

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
const url = urlBase+"records?order_by=number&limit=-1"



const stationFetchDAO = {
    findAll : async ()=> {
        let response = agent!=null ? await fetch(url, {agent: agent}):await fetch(url)
        let json = await response.json()

        const nbPage = (json.total_count/100)
        const data = json.results
        for(let page=1; page < nbPage;page++){
            response = agent!=null ? await fetch(url, {agent: agent}):await fetch(url+"&offset="+page*100)
            json = await response.json()
            data.push(...json.results)
        }

        return (data.map(s=> {
            s.position = new Position(s.position)
            s.last_update = Date.parse(s.last_update)
            s.available_bike_stands = parseInt(s.available_bike_stands)
            s.number = parseInt(s.number)
            s.available_bikes = parseInt(s.available_bikes)
            s.rental_methods = s.rental_methods==null ? "" : s.rental_methods
            return new Station(s)
        }))
    }
}

export default stationFetchDAO
