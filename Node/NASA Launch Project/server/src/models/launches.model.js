const launches = require('./launches.mongo')
const planets = require('./planets.mongo')

//const launches = new Map() <- in-memory

//let latestFlightNumber = 100 <- in-memory
const DEFAULT_LAUNCH_NUMBER = 100

//default launch for testing...
const launch = {
    flightNumber: 100,
    mission: "Kepler Exploration X",
    rocket: "Piss Rocket 44CG",
    launchDate: new Date('September 19, 2028'),
    target: 'Kepler-442 b',
    customer: ['NASA', 'ZTM'],
    upcoming: true,
    success: true,
}

//launches.set(launch.flightNumber, launch) <- in-memory
saveLaunch(launch)

async function getLatestLaunchFlightNumber(){
    const launch = launches
                           .findOne()
                           .sort('-flightNumber')
    if(!launch){
        return DEFAULT_LAUNCH_NUMBER
    }
    return launch.flightNumber
}

async function findLaunchById(id){
    //return launches.has(id)
    return await launches.findOne({flightNumber: id})
}

async function getAllLaunches(){
    //return Array.from(launches.values)
    return await launches.find({}, {
        '_id': 0, '__v': 0,
    })
}

async function saveLaunch(launch){
    const planet = await planets.findOne({
        keplerName: launch.target,
    })
    if(!planet){
        throw new Error('No matching planets was found')
    }
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
}