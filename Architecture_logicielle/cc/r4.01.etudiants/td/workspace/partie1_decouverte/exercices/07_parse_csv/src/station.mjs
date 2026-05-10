import Position from "./position.mjs";
"use strict"

class StationException extends Error {
    constructor(message) {
        super(message);
        this.name = "Station Exception"
    }
}
//Type et noms des attributs attendus
const attributsNamesAndTypes =new Map([
    ["last_update","number"],
    ["available_bike_stands","number"],
    ["number","number"],
    ["available_bikes","number"],
    ["name","string"],
    ["address","string"],
    ["rental_methods","string"],//null => ""
    ["bike_stands","number"],
    ["position","object"],
])

class Station  {
    last_update
    available_bike_stands
    number
    available_bikes
    name
    address
    rental_methods
    bike_stands
    position

    constructor(obj) {

        //Verification des attributs
        const objNamesAndTypes =new Map(Object.entries(obj).map(([key,value])=>
            [key, typeof value]
        ))
        if (!(attributsNamesAndTypes.size === objNamesAndTypes.size &&
            Array.from(attributsNamesAndTypes.keys())
                .every((key) => attributsNamesAndTypes.get(key) === objNamesAndTypes.get(key))
        )) {
            throw new StationException("Invalid attribut or type")
        }
        //la date est-elle valide ?
        if ((! obj.last_update instanceof Date) ||
            isNaN(obj.last_update))
            throw new StationException("Invalid date")
        const position= new Position(obj.position)
        obj.position = position
        Object.assign(this,obj)
    }

}

export default Station
