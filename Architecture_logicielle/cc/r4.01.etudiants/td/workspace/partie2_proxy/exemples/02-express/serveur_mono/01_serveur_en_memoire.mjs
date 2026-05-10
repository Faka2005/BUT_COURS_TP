'use strict';

import express from 'express';

//notre modèle un Utiilisateur et l'ensemble des utilisateurs
//les utilisateurs sont identifiés par leur login
class User {
    login
    password
    constructor(obj) {
        Object.assign(this,obj)
    }
}
class Users {
    users = []
}

//pas de bd uniquement en mémoire
const model = new Users()

//notre DAO
const userDao = {
    //tous les utilisteurs
    findAll : () => model.users,

    //ajout un utilisateur
    //renvoie l'utilisateur ajouté ou null sinon
    findByLogin : (login) => {
        const users = model.users.filter((user)=>user.login==login)
        return users.length!=0 ? users[0]:null
    },
    //supprime un utilisateur
    //renvoie l'utilisateur supprimé ou null sinon
    deleteByLogin: (login) => {
        const user = userDao.findByLogin(login)
        if (user==null)
            return null
        model.users = model.users.filter((user)=>user.login != user.login)
        return user
    },
    //ajout un utilisateur
    //renvoie l'utilisateur ajouté ou null si il était déjà présent
    add: (user) => {
        const userByLogin = userDao.findByLogin(user.login)
        if (userByLogin != null)
            return null
        model.users.push(user)
        return user
    },

    //Modifie un utilisateur
    //premd en paramètre le login du user à modifier et la modification
    //renvoie le user modifier ou null
    update: (login, user) => {
        const userByLogin = userDao.findByLogin(login)
        if (user==null)
            return null
        userDao.deleteByLogin(login)
        userDao.deleteByLogin(user.login)
        userDao.add(user)
        return user
    }

}
//la methode qui permettra de lancer le serveur
const init = async () => {
    //Un serveur qui écoute sur le port 3000
    const app = express();
    app.listen(3000, () =>
        console.log('Example app listening on port 3000!'),
    );
    app.use(express.json()) // parse json body content

    const router = express.Router()

    //une route est définie par
    //son verbre
    //son path

    app.get('/user',(req, res)=>res.status(200).send(userDao.findAll()))
    app.post('/user',(req,res) => {
            console.log(req.body)
            const userToAdd = req.body
            const user = userDao.add(userToAdd)
            if (user != null)
                res.status(201).send(user)
            else
                res.status(400).send({message: 'already exist'})
        })

    app.get('/user/:login', (req,res)=>{
        console.log(req.params)
        const user = userDao.findByLogin(req.params.login)
        if (user!=null)
            return res.status(200).send(user)
        else
            return res.status(404).send({message: 'not found'})
    })
    app.delete('/user/:login',(req,res)=>{
        const user = userDao.deleteByLogin(req.params.login)
        if (user!=null)
            res.status(200).send(user)
        else
            res.status(404).send({message: 'not found'})
    })
    app.put('/user/:login',(req,res)=>{
        const user = userDao.update(req.params.login,req.body)
        if (user!=null)
            res.status(200).send(user)
        else
            res.status(404).send({message: 'not found'})
    })

};

//evenement capturé en cas d'erreur
process.on('unhandledRejection', (err) => {

    console.log('err',err);
    process.exit(1);
});
init();
