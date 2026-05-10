import express from 'express';

const app = express();

app.listen(3000, () =>
    console.log('Example app listening on port 3000!'),
);

app.get('/about', (req, res) => {
    console.log(req.url)
    console.log(req.params) //vide
    console.log(req.query)
    return res.send('About Page')
})
