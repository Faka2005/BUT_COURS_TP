    import assert from "node:assert"
import { describe, it } from "node:test"
import {XMLHttpRequest} from "xmlhttprequest"
import toilettesPMROuvertes from "../src/toilette.mjs";
const maPromesse = ()=>new Promise((resolve) => {
    const baseURL = 'https://data.nantesmetropole.fr/api/explore/v2.1/catalog/datasets/244400404_toilettes-publiques-nantes-metropole/'
    const url = baseURL+"records?where=etat%3D%27En%20service%27%20AND%20accessibilite_pmr%3D%27oui%27&limit=-1"
    const req = new XMLHttpRequest();

    function listener() {
        if (req.readyState == 4 && req.status == 200)
            resolve(JSON.parse(req.responseText).results.sort((e1,e2)=>e1.gid - e2.gid));
    }
    req.onreadystatechange=listener
    req.open("GET", url);
    req.send();
})

describe("toilette",()=>{
    it("ok",async ()=>{
        assert.deepEqual(await toilettesPMROuvertes(),await maPromesse())
    })
})
