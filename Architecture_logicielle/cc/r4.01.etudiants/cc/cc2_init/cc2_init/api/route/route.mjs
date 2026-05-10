"use strict"
import express from 'express'
import gourmandController from "../controller/gourmandController.mjs";
import Gateau from "../model/GateauModele.mjs";
import Gourmand from "../model/GourmandModele.mjs";

const router = express.Router()

router
    .route('/gourmand')
    .get(async (req, res) => {
        // #swagger.summary = 'L ensemble des gourmands'
        // #swagger.description = 'Renvoie l ensemble des gourmands'
        res.status(200).send(await gourmandController.findAll())
    })
    .post(async (req, res) => {
        /*
        #swagger.summary = 'Ajoute un gourmand'
        #swagger.parameters['body'] = {
        in: 'body',
        description: 'Permet l ajout d un gourmand',
        schema: {
            $name: 'JoJo',
            }
        } */
        try {
            const gourmand = await gourmandController.addOne(new Gourmand(req.body.name))
            return res.status(201).send(gourmand)
        } catch (e) {
            return res.status(400).send({message: 'not added'})
        }
    })
    .delete(async (req, res) => {
        try {
            /*
            #swagger.summary = 'Supprime tous les gourmands'
            #swagger.parameters['body'] = {
            in: 'body',
            description: 'Permet de supprimer tous les gourmands',
            }
            */
            const gourmand =await gourmandController.removeAll()
            return res.status(200).send(gourmand)
        } catch (error) {
            return res.status(400).send({message:'not deleted'})
        }
    })
    //---------------------------------------------
    // Ajouter une route ici
    //---------------------------------------------


router
    .route('/gourmand/:name')
    .get(async (req, res) => {
// #swagger.summary = 'Permet d obtenir un gourmand'
// #swagger.description = 'Le gourmand obtenu pas son nom'
        const name = decodeURIComponent(req.params.name)
        const gourmand = await gourmandController.findOne(name)
        if (gourmand == null)
            return res.status(404).send({message: "greedy not found"})
        else
            return res.status(200).send(gourmand)
    })
    .delete(async (req, res) => {
        const name = decodeURIComponent(req.params.name)
        const gourmand=await gourmandController.removeOne(name)
        if (gourmand == null)
            return res.status(404).send({message: "greedy not found"})
        else
            return res.status(200).send(gourmand)
    })

    //---------------------------------------------
    // Ajouter une route ici
    //---------------------------------------------



router
    .route('/gourmand/achete/:name')
    .put(async (req, res) => {
            /*
                    #swagger.summary = 'Achete un chocolat'
                    #swagger.parameters['body'] = {
                    in: 'body',
                    description: 'Permet l achat d un chocolat',
                    schema: {
                        $nom: 'Cookie',
                        $calories: 100,
                        }
                    } */
            try {
                const name = decodeURIComponent(req.params.name)
                const cake = new Gateau(req.body)
                console.log(name, JSON.stringify(cake))
                await gourmandController.achete(name, cake)
                return res.status(200).send(await gourmandController.findOne(name))
            } catch (e) {
                return res.status(400).send({message: 'not bought'})
            }
        }
    )

export default router

