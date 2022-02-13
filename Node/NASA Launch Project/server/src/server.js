const http = require('http')
const mongoose = require('mongoose')
//importing express logic we have separated from our server logic
const app = require('./app')
//importing so we can load data on startup
const { loadPlanetsData, savePlanet } = require('./models/planets.model')
const { loadLaunchesData } = require('./models/launches.model')
//populates our process.env variable with the data found in our .env file
require('dotenv').config()
//customizing port number used for server
const PORT = process.env.PORT || 8000
//creating server
const server = http.createServer(app)

const MONGO_URL = process.env.MONGO_URL

//load data on startup
async function startServer(){
    //can be used to see if mongoose connects successfully or not to db
    mongoose.connection.once('open', () => {
        console.log('mongoDB ready...connection established')
    })
    mongoose.connection.on('error', (err) => {
        console.error(err)
    })
    //connect to db before starting server so data is for sure available for application
    await mongoose.connect(MONGO_URL)
    //await makes sure we get the data before we start the server...we had to create a promise in the loadPlanetsData() 
    //in order to use the await keyword...also you have to wrap it in a function that has the async keyword
    await loadPlanetsData()
    await loadLaunchesData()

    server.listen(PORT, () => {
        console.log(`Server is listening on port ${PORT}...`)
    })
}
//starting the server to begin listening for requests
startServer()



