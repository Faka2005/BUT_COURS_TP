import express from 'express';

const app = express()

app.listen(3000, () =>
    console.log('Example app listening on port 3000!'),
)

app.get('/about', (req, res) => {
    console.log('url',req.url)
    console.log('params',req.params)
    console.log('query',req.query)
    return res.send(`/about Page : url: 
        ${req.url} params ${JSON.stringify(req.params)} query ${JSON.stringify(req.query)}`)
})

app.get('/about/:user', (req, res) => {
    console.log('url',req.url)
    console.log('params',req.params)
    console.log('query',req.query)
    return res.send(`/about/:user Page : url: 
        ${req.url} params ${JSON.stringify(req.params)} query ${JSON.stringify(req.query)}`)
})
