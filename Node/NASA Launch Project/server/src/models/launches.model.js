const launches = require('./launches.mongo')
const planets = require('./planets.mongo')
const axios = require('axios')

//const launches = new Map() <- in-memory

//let latestFlightNumber = 100 <- in-memory
const DEFAULT_LAUNCH_NUMBER = 100

//default launch for testing...
/* const launch = {
    flightNumber: 100, //flight_number from spacex api
    mission: "Kepler Exploration X", //name from spacex api
    rocket: "Rocket 44CG", //rocket.name from spacex api
    launchDate: new Date('September 19, 2028'), //date_local from spacex api
    target: 'Kepler-442 b', //not applicable
    customers: ['NASA', 'ZTM'], //payload.customers from spacex api
    upcoming: true, //upcoming from spacex api
    success: true, //success from spacex api
} */
//launches.set(launch.flightNumber, launch) <- in-memory
//saveLaunch(launch)

const SPACEX_API_URL = 'https://api.spacexdata.com/v4/launches/query'

async function loadLaunchesData(){
    const firstLaunch = await findLaunch({
        flightNumber: 1,
        rocket: 'Falcon 1',
        mission: 'FalconSat',  
    })
    if(firstLaunch){
        console.log('Launches already loaded...')
    }else{
        await populateLaunchesDatabase()
    }
}

async function populateLaunchesDatabase(){
    console.log('Downloading launch data...')
    const response = await axios.post(SPACEX_API_URL, {
        query: {},
        options: {
            pagination: false, //get all data at once
            //page: 1, <- Pagination
            //limit: 25, <- Pagination

            //populate allows the inclusion of data from other documents(tables) not included in original response
            //ex: rockets only included the rocket id in original response, so we wanted to expand that and get the rocket name instead
            populate: [
            {
                path: 'rocket',
                select: {
                    name: 1
                }
            },
            {
                path: 'payloads',
                select: {
                    'customers': 1
                }
            }
            ]
        }
    })
    const launchDocs = response.data.docs
    launchDocs.map((doc) => {
        const payloads = doc['payloads']
        const customersList = payloads.flatMap((payload) => {
            return payload['customers']
        })
        const launch = {
            flightNumber: doc['flight_number'], 
            mission: doc['name'], 
            rocket: doc['rocket']['name'], 
            launchDate: doc['date_local'], 
            customers: customersList, 
            upcoming: doc['upcoming'], 
            success: doc['success'], 
        }
        await saveLaunch(launch)
    })
}

async function getLatestLaunchFlightNumber(){
    const launch = await launches
                           .findOne()
                           .sort('-flightNumber')
    if(!launch){
        console.log('should appear')
        return DEFAULT_LAUNCH_NUMBER
    }
    return launch.flightNumber
}

async function findLaunch(filter){
    return await launches.findOne(filter)
}

async function findLaunchById(id){
    //return launches.has(id) <- in-mem
    return await launches.findOne({flightNumber: id})
}

async function getAllLaunches(skip, limit){
    //return Array.from(launches.values) <- in-mem
    return await launches.find({}, {'_id': 0, '__v': 0,})
    .sort({ flightNumber: 1 }) //-1 = descending
    .skip(skip)
    .limit(limit)
}

async function saveLaunch(launch){
    try {
        await launches.findOneAndUpdate({
            flightNumber: launch.flightNumber,
        }, launch, {
           upsert: true,
        })
    } catch (error) {
       console.error(error) 
    }
}

async function scheduleNewLaunch(launch){
    const planet = await planets.findOne({
        keplerName: launch.target,
    })
    if(!planet){
        throw new Error('No matching planets was found')
    }

    const newFlightNumber = await getLatestLaunchFlightNumber() + 1
    const newLaunch = Object.assign(launch, {
        customer: ['ZTM', 'NASA'],
        upcoming: true,
        success: true,
        flightNumber: newFlightNumber,
    })
    await saveLaunch(newLaunch)
}

//in-memory
/* function addNewLaunch(launch) {
    latestFlightNumber = latestFlightNumber + 1
    launches.set(latestFlightNumber, Object.assign(launch, {
        customer: ['ZTM', 'NASA'],
        flightNumber: latestFlightNumber,
        upcoming: true,
        success: true,
    })
    )
} */

async function abortLaunch(id){
    //find launch by id
    //modify launch and set upcoming and success to false
    //update database with new launch data

    //in-memory
    //const aborted = launches.get(id)
    //abortedLaunch.upcoming = false
    //abortedLaunch.success = false

    const abortedLaunch = await launches.updateOne({
        flightNumber: id,
    }, {
        upcoming: false,
        success: false,
    })
    return abortedLaunch.modifiedCount === 1
}

module.exports = {
    getAllLaunches,
    findLaunchById,
    abortLaunch,
    saveLaunch,
    scheduleNewLaunch,
    loadLaunchesData,
}