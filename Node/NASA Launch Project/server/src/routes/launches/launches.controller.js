const { getAllLaunches, saveLaunch, abortLaunch, findLaunchById, scheduleNewLaunch } = require('../../models/launches.model')
const { getPagination } = require('../../services/query')

async function httpGetAllLaunches(req, res){
    const { skip, limit } = getPagination(req.body)
    const launches = await getAllLaunches(skip, limit)
    return res.status(200).json(launches)
}

async function httpAddNewLaunch(req, res){
    const launch = req.body

    if(!launch.mission || !launch.rocket || !launch.launchDate || !launch.target){
        return res.status(400).json({error: 'missing one more launch fields'})
    }

    //turning into string date object
    launch.launchDate = new Date( launch.launchDate )
    if(isNaN(launch.launchDate)){
        return res.status(400).json({error: 'Invalid launch date'})
    }
    //addNewLaunch(launch)
    await scheduleNewLaunch(launch)
    return res.status(201).json(launch)
}

async function httpAbortLaunch(req, res){
    const id = Number(req.params.id)
    const launchToAbort = await findLaunchById(id)
    if(!launchToAbort){
       return res.status(404).json('Launch not found')      
    }
    const abortedLaunch = await abortLaunch(id)
    if(!abortedLaunch){
        return res.status(404).json('Unable to abort launch')
    }
    return res.status(200).json({ok: true})
}

module.exports = {
    httpGetAllLaunches,
    httpAddNewLaunch,
    httpAbortLaunch,
}