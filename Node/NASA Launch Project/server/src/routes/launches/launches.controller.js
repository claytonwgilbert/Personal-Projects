const { getAllLaunches, addNewLaunch, abortLaunch, findLaunchById } = require('../../models/launches.model')

function httpGetAllLaunches(req, res){
    return res.status(200).json(getAllLaunches())
}

function httpAddNewLaunch(req, res){
    const launch = req.body

    if(!launch.mission || !launch.rocket || !launch.launchDate || !launch.target){
        return res.status(400).json({error: 'missing one more launch fields'})
    }

    //turning into string date object
    launch.launchDate = new Date( launch.launchDate )
    if(isNan(launch.launchDate)){
        return res.status(400).json({error: 'Invalid launch date'})
    }
    addNewLaunch(launch)
    return res.status(201).json(launch)
}

function httpAbortLaunch(req, res){
    const id = Number(req.params.id)
    if(findLaunchById(id)){
        const abortedLaunch = abortLaunch(id)
        return res.status(200).json(abortedLaunch)
    }
    return res.status(404).json({error: "launch not found"})
}

module.exports = {
    httpGetAllLaunches,
    httpAddNewLaunch,
    httpAbortLaunch,
}