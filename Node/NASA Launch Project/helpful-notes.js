/*
    1 AUTOMATE BUILD PROCESS
    use react-scripts to centralize your npm install and build logic for all project folders instead of having to go to
    each project folder which contains their own package.json file and run npm install and start...specifically look at the
    deploy command which starts up both the client and server at the same time --prefix is used to specify which folder we want to be
    in before we execute our command

    2 COMBINING CLIENT/SERVER
    we can combine our client side with our server side by making sure we create a production build of our client project using the
    react-scripts-build command...set BUILD_PATH=../server/public can be used to after the production build folder is created...it will
    automatically be copied over to the public folder within the server directory...this can be automated within the root package.json
    file using scripts like mentioned in 1. Now we can just run the server and see have both our server and client run together on the
    same port, which we have set to 8000 in this project. Without this step we would have to start up the client on one port and the
    server on a separate port. ALSO: since we combined, we need to tell express where to go on homepage or / url. We point it to the new
    index.html page created from our production build now located in the server public folder
    ------------------------------------
    server/app.js

    app.get('/', (req, res) => {
        res.sendFile(path.join(__dirname, '..', 'public', 'index.html'))
    })
    -------------------------------------

    3 DATA LOAD ON STARTUP
    it is common to load data before startup of the server, example for this project
    -------------------------------------
    /server.js
    async function startServer(){
        await loadPlanetsData()

        server.listen(PORT, () => {
            console.log(`Server is listening on port ${PORT}...`)
        })
    }
    startServer()
    ---------------------------------------
    4 PROMISES ASYNC AWAIT
    if you need to be sure you have your data loaded before continuing execution of your program like the data loading on server startup
    above in 3...using promises combined with the async await keyword guarantees you have your data when you need it
    
    5 COMBINED CLIENT SERVER ROUTING PROBLEM
    server/app.js
    //IMPORTANT: /* tells express that if it runs into a route that doesn't exist here on the server like /history, as we 
    //have not handled that endpoint yet and the only file in the public folder is the entire front-end in a index.html compiled file
    //then it will tell react to handle that endpoint through its routing it has on the front end, so express will just send the index.html
    ---------------------------------------------------------------------
    app.get('/*', (req, res) => {
        res.sendFile(path.join(__dirname, '..', 'public', 'index.html'))
    })
    ---------------------------------------------------------------------


*/