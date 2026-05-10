window.addEventListener("load", function(){
    let select;
    let ul;

    let data = ["velo","moto"];

    const drawUl = function(){
        ul.innerHTML='';
        data.forEach(item => {
            const li = document.createElement('li');
            li.innerHTML = item;
            ul.appendChild(li);
        });
    }

    const init = function(){
       const body = document.querySelector("body");
       const form = document.createElement("form");
       form.setAttribute("action","#");
       select = document.createElement("select");
       for(let i=0; i < 10; i++){
           const option = document.createElement("option");
           const text = document.createTextNode(i);
           option.appendChild(text);
           select.appendChild(option);
       }
       form.appendChild(select);
       const inputText = document.createElement("input");
       inputText.setAttribute("type","text");
        form.appendChild(inputText);
       let inputSubmit = document.createElement("input");
       inputSubmit.setAttribute("type","submit");
       form.appendChild(inputSubmit);
       body.appendChild(form);
       ul = document.createElement("ul");
       body.appendChild(ul);

        form.addEventListener("submit", event => {
            //event.preventDefault();
            data.splice(select.value, 0, inputText.value);
            drawUl();
        })

   }

   init();
    drawUl();

});


