import express from 'express';

const app = express();

app.listen(3000, () =>
    console.log('Example app listening on port 3000!'),
);

const logger  = (req, res, next) => {
    console.log(req.url)
    console.log(req.params)
    console.log(req.query)
    next()
}
app.use(logger)

app.get('/about', (req, res) => {
    return res.send('About Page')
})
