//setting up router for planets paths
const express = require('express')
//controller
const { httpGetAllPlanets, httpSavePlanet } = require('./planets.controller')
const planetsRouter = express.Router()

planetsRouter.get('/', httpGetAllPlanets)


module.exports = planetsRouter