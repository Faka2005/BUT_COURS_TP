"use strict"

document.addEventListener('DOMContentLoaded', async ()=> {
        const products = document.querySelector("#products")

        const res = await fetch('https://fakestoreapi.com/products')
        const data = await res.json()
        const urls = data.map(p => p.image)
        urls.forEach(url=>{
            const img = document.createElement('img')
            img.setAttribute('src', url)
            products.appendChild(img)
        })


})



