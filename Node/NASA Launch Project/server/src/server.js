const http = require('http')
//importing express logic we have separated from our server logic
const app = require('./app')
//importing so we can load data on startup
const { loadPlanetsData } = require('./models/planets.model')
//customizing port number used for server
const PORT = process.env.PORT || 8000
//creating server
const server = http.createServer(app)

//load data on startup
async function startServer(){
    //await makes sure we get the data before we start the server...we had to create a promise in the loadPlanetsData() 
    //in order to use the await keyword...also you have to wrap it in a function that has the async keyword
    await loadPlanetsData()

    server.listen(PORT, () => {
        console.log(`Server is listening on port ${PORT}...`)
    })
}
//starting the server to begin listening for requests
startServer()



