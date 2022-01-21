export const formatPrice = (price) => {
    return new Intl.NumberFormat('en-US', {
        style:'currency', 
        currency: 'USD'
    }).format(price / 100)
}

export const getUniqueValues = ( data, type ) => {
    let unique = data.map((item) => item[type])
    if(type === 'colors'){
        unique = unique.flat() //flattening because colors is an array itself, so to avoid having an array within an array we flatten it so that its only the values within the array
    }
    return ['all', ...new Set(unique)] //creating new set array, also only grabs unique values, no duplicates, also adding all as the first element
}
