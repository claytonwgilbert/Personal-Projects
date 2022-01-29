const mongoose = require('mongoose')

const planetsSchema = new mongoose.Schema({
    keplerName: {
        type: String,
        required: true,
    }
})

//Connects planetsSchema with the "planets" collection that mongoose will create for us using the Planet definition defined here
module.exports = mongoose.model('Planet', planetsSchema)