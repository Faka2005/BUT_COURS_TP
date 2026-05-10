"use strict"
import express from 'express'
import stationController from "../controller/stationController.mjs";


const router = express.Router()
const latRegexpr = new RegExp('-?([0-8]?[0-9]|90)(\.[0-9]{1,10})')
const longRegexpr = new RegExp('-?([0-9]{1,2}|1[0-7][0-9]|180)(\.[0-9]{1,10})')

//l'ensemble des stations
router
    .route('/station')
        .get(async (req, res) =>{
            const data = await stationController.findAll()
            res.status(200).send(data)
           })
//Les stations les plus proches de lat-lon
router
    .route('/station/near/:lat/:lon')
    .get(async (req, res) =>{
        const lat = parseFloat(req.params.lat).toFixed(10)
        const lon = parseFloat(req.params.lon).toFixed(10)

        if (!latRegexpr.test(lat) || !longRegexpr.test(lon))
            return res.status(400).send({message : "invalid parameter"})
        res.status(200).send(await stationController.findAllNear({lat:lat, lon:lon}))
    })
//les stations avec des vélos libres
//TODO
//les stations avec de vélos libres proches de lat-lon
//TODO
export default router

