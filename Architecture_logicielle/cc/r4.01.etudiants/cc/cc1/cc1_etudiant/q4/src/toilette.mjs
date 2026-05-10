

const toilettesPMROuvertes = async () => {
    const base="https://data.nantesmetropole.fr/explore/dataset/244400404_toilettes-publiques-nantes-metropole/information/"
    const api="/api/explore/v2.1/catalog/datasets/244400404_toilettes-publiques-nantes-metropole/records?where=accessibilite_pmr%3D%22oui%22%20%AND%20etat%3D%22En%20service%22&order_by"
    const reponse=await fetch(base+api)
    return data
}

export default toilettesPMROuvertes
