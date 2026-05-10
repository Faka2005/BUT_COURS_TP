const socket = io();
const body = document.querySelector('body');

socket.on('hello_event', (mesg) => {
    body.innerHTML = mesg;
    socket.emit('ack_to_serve', "bien reçu : "+mesg);
});

socket.on('ack_from_serve', (mesg) => {
    body.innerHTML = mesg;
});