//importing express
const express = require('express')
//importing router for planets
const planetsRouter = require('./routes/planets/planets.router')
//importing router for launches
const launchesRouter = require('./routes/launches/launches.router')
//importing cors for cross origin request access
const cors = require('cors')
//importing path for absolute path directory searching
const path = require('path')
//initializing express
const app = express()
//logger
const morgan = require('morgan')

//MIDDLEWARE
//parse incoming json
app.use(express.json())
//setting our public folder for all our assets
app.use(express.static(path.join(__dirname, '..', 'public')))
//telling express where our routers are for requests
app.use('/planets', planetsRouter)
app.use('/launches', launchesRouter)
//setting cors to allow which client we are allowing to access our server
app.use(cors({
    origin: 'http://localhost:3000',
}))
//setting up our logger
app.use(morgan('combined'))



//since we combined our frontend with our backend, we need to tell express on startup where to go
//IMPORTANT: /* tells express that if it runs into a route that doesn't exist here on the server like /history, as we 
//have not handled that endpoint yet and the only file in the public folder is the entire front end in a index.html compiled file
//then it will tell react to handle that endpoint through its routing it has on the front end
app.get('/*', (req, res) => {
    res.sendFile(path.join(__dirname, '..', 'public', 'index.html'))
})



module.exports = app