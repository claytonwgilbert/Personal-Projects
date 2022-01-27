const launches = new Map()

let latestFlightNumber = 100

//default launch for testing...
const launch = {
    flightNumber: 100,
    mission: "Kepler Exploration X",
    rocket: "Explorer EX 4-B",
    launchDate: new Date('September 19, 2028'),
    target: 'Kepler 42-a Lupus' ,
    customer: ['NASA', 'ZTM'],
    upcoming: true,
    success: true,
}

launches.set(launch.flightNumber, launch)

function findLaunchById(id){
    return launches.has(id)
}

function getAllLaunches(){
    return Array.from(launches.values)
}

function addNewLaunch(launch){
    latestFlightNumber++
    launches.set(latestFlightNumber, Object.assign(launch {
        customer: ['ZTM', 'NASA'],
        flightNumber: latestFlightNumber,
        upcoming: true,
        success: true,
    })
}

function abortLaunch(id){
    const aborted = launches.get(id)
    abortedLaunch.upcoming = false
    abortedLaunch.success = false

    return aborted
}

module.exports = {
    getAllLaunches,
    addNewLaunch,
    findLaunchById,
    abortLaunch,
}