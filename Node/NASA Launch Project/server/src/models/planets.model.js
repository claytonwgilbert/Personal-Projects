const { parse } = require('csv-parse');
const fs = require('fs');
const path = require('path')
const planets = require('./planets.mongo')

//const habitablePlanets = []; in-memory

function isHabitablePlanet(planet) {
  return planet['koi_disposition'] === 'CONFIRMED'
    && planet['koi_insol'] > 0.36 && planet['koi_insol'] < 1.11
    && planet['koi_prad'] < 1.6;
}

function loadPlanetsData(){
    return new Promise(( resolve, reject ) => {
        fs.createReadStream(path.join(__dirname, '..', '..', 'data', 'kepler_data.csv'))
        .pipe(parse({
            comment: '#',
            columns: true,
        }))
        .on('data', async (data) => {
          if (isHabitablePlanet(data)) {
            //habitablePlanets.push(data) <-- in-memory
            savePlanet(data) //mongoose
          }
        })
        .on('error', (err) => {
          console.log(err)
          reject(err)
        })
        .on('end', async () => {
          console.log(`${(await getAllPlanets()).length} habitable planets found!`)
          resolve()
        })
    })
}

  async function getAllPlanets(){
    //return habitablePlanets - in-memory

    /* example of more in depth find operation
    planets.find({
      keplerName: 'Kepler-32b' <--specifying exact planet looking for
    }, 'keplerName anotherField') <--specifying what fields we want returned 
    */
    return await planets.find({}, {
      '_id': 0, '__v': 0,
    })
  }

  async function savePlanet(planet){
    try {
      //insert + update = updateOne(upsert) or findOneAndUpdate <--if property already exists in db and if it doesn't it will add, if it does exist, it will update
      await planets.findOneAndUpdate({
        keplerName: planet.kepler_name, //what we are searching by to find the object we want to update
      }, {
        keplerName: planet.kepler_name, //this is the data that will update already in db property if upsert = true or create new
      }, {
        upsert: true,
      })
    } catch (error) {
      console.error(error)
    }
  }

  module.exports = {
      loadPlanetsData,
      getAllPlanets,
      savePlanet,
  }