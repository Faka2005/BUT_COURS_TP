window.addEventListener("load",()=>{
    const socket = io();

    const messages = document.querySelector('#messages');
    const form = document.querySelector('#form');
    const input = document.querySelector('#input');

    form.addEventListener('submit', (e)=> {
        console.log("here")
        e.preventDefault();
        if (input.value) {
            socket.emit('chat message', input.value);
            input.value = '';
        }
    });

    socket.on('chat message', function(msg) {
        const item = document.createElement('li');
        item.textContent = msg;
        messages.appendChild(item);
        window.scrollTo(0, document.body.scrollHeight);
    });
})