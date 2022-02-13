const DEFAULT_PAGE_LIMIT = 0 //In mongo, if 0 is passed in for limit property then all data will be returned
const DEFAULT_PAGE_NUMBER = 1

function getPagination(query){
    const page = Math.abs(query.page) || DEFAULT_PAGE_NUMBER //setting default value
    const limit = Math.abs(query.limit) || DEFAULT_PAGE_LIMIT //setting default value
    const skip = (page - 1) * limit //logic for determining how many elements to skip when on a certain page

    return {
        skip,
        limit
    }
}

module.exports = {
    getPagination,
}