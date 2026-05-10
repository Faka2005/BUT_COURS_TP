const socket = io();

socket.on('hello_event',
    (mesg) => document.querySelector('body').innerHTML = mesg);