"use strict"
import express from 'express'
import http from 'http'
//recupération de l'url absolue du module
import path from 'path'
import {fileURLToPath} from 'url';

const __filename = fileURLToPath(import.meta.url); //chemin absolu vers le module
const __dirname = path.dirname(__filename);  //répertoire du module


const app = express()
    .use(express.static(path.join(__dirname, 'public')))
const server = http.createServer(app);
server.listen(3000, () => {
    console.log("server running on 3000");
})


import {Server} from "socket.io";

const io = new Server(server, {
    cors: {
        origin: 'http://localhost:3000',
        methods: ['GET', 'POST']
    }
})

let content = ""
//socket
io.on('connection', (socket) => {
    socket.emit('init-data', content);
    socket.on("on-editor-input", (data) => {
            console.log("on-editor-input" + data);
            content = data;
            socket.broadcast.emit('broadcast-data', data);
        }
    )
});

