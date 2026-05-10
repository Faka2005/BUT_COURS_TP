class Liste {
    items
    constructor() {
        this.items = []
    }
    add(position, element) {
        const tr = this.items.slice(0,position)
        const tl = this.items.slice(position, this.items.length)
        this.items = tr.concat(element,tl)
    }

    render() {
        const ul =document.createElement("ul")
        this.items.forEach(item => {
            const li = document.createElement('li')
            li.innerText = item
            ul.appendChild(li)
        })
        return ul
    }
}

const liste = new Liste()
liste.add(0,"Hello1")
liste.add(1,"Hello2")
liste.add(0,"Hello3")

console.log(liste)

window.addEventListener("DOMContentLoaded",() => {
    const body = document.querySelector("body")
    const form = document.createElement("form")
    form.setAttribute("action","#")
    const submit = document.createElement("input")
    submit.setAttribute("type","submit")
    const input = document.createElement("input")
    const select = document.createElement("select")
    const option = document.createElement("option")
    option.innerText="0"
    select.appendChild(option)
    form.appendChild(select)
    form.appendChild(input)
    form.appendChild(submit)

    let ul = document.createElement("ul")
    body.appendChild(form)
    body.appendChild(ul)

    form.addEventListener("submit", (e)=>{
        e.preventDefault()
        const val = input.value
        liste.add(0, val)
        ul.innerHTML=''
        ul = document.cloneNode(liste.render())
    })
})
