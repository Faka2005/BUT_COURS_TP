const toilettesPMROuvertes = async () => {

    const url = "https://data.nantesmetropole.fr/api/explore/v2.1/catalog/datasets/244400404_toilettes-publiques-nantes-metropole/records?where=etat%3D%27En%20service%27%20AND%20accessibilite_pmr%3D%27oui%27&limit=-1"

    const response = await fetch(url)
    const data = await response.json()

    return data.results.sort((e1, e2) => e1.gid - e2.gid)
}

export default toilettesPMROuvertes