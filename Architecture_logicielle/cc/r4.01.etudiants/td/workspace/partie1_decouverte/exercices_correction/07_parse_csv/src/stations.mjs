"use strict"

import Station from "./station.mjs";
import Position from "./position.mjs";

class StationsException extends Error {
    constructor(message) {
        super(message);
        this.name = "Stations Exception"
    }
}

class Stations {
    #total_count
    #results
    constructor() {
        this.#total_count =0
        this.#results= new Array()
    }
    add(station) {
        if (! station instanceof Station)
            throw new StationsException("Not a Station")
        if (this.#results.map(station => station.number).includes(station.number))
            throw new StationsException("Already exists")
        this.#results.push(new Station(station))
        this.#total_count++
    }
    remove(number) {
        const index = this.#results.map(station => station.number)
            .indexOf(number)
        if ( index == -1)
            throw new StationsException("Not exists")
        this.#results.splice(index,1)

        this.#total_count--
    }
    get stations () {
        return this.#results
    }
    get size(){
        return this.#total_count
    }
    sortByDistanceFrom(position){
        if (! (position instanceof Position))
            throw new StationsException("Not a Position")
        const res = this.#results.sort(
            (result1,result2) =>
                result1.position.distance(position)
                -
                result2.position.distance(position)
        )
        return res
    }
}


export default Stations
