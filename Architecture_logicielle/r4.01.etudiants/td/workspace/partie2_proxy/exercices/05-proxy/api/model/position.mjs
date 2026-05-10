"use strict"

class PositionException extends Error {
    constructor(message) {
        super(message);
        this.name = "Position Exception"
    }
}

const getDistanceBetweenPointsInMeter=(latitude1, longitude1, latitude2, longitude2)=> {
    let theta = longitude1 - longitude2;
    let distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
        Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) +
        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
    );
     return Math.round(distance * 1609.344, 2);

}

class Position {
    lat
    lon
    constructor(obj={lat:0, lon:0}) {
        if (obj.lat == undefined || obj.lon == undefined)
            throw new PositionException("invalid type")
        const lat = obj.lat
        const lon = obj.lon

        if (typeof lat != "number" || typeof lon !="number")
            throw new PositionException("invalid type")
        if (lat > 180 || lat < -180 || lon < -90 || lon >90)
            throw new PositionException("invalid value")
        this.lat = lat, this.lon = lon
    }

    toString(){
        return JSON.stringify({lat: this.lat, lon: this.lon})
    }
    get latitude () {
        return this.lat
    }
    get longitude () {
        return this.lon
    }
    distance(p){
        if (!p instanceof Position)
            throw new PositionException("must be a position")
        return  getDistanceBetweenPointsInMeter(this.lat, this.lon, p.lat, p.lon)
    }
}

export default Position
