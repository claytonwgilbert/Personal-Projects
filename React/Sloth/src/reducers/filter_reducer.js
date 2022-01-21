import {
  LOAD_PRODUCTS,
  SET_LISTVIEW,
  SET_GRIDVIEW,
  UPDATE_SORT,
  SORT_PRODUCTS,
  UPDATE_FILTERS,
  FILTER_PRODUCTS,
  CLEAR_FILTERS,
} from '../actions'

const filter_reducer = (state, action) => {
  //copying products from products context to place in this filter context
  if(action.type === LOAD_PRODUCTS){
    let maxPrice = action.payload.map((product) => product.price)
    maxPrice = Math.max(...maxPrice)
    return {
      ...state,
      all_products: [...action.payload], //using ...operator because we only want to copy values from products context, not reference same memory location as we don't want what we do on one page to affect the same data being used differently in other different pages
      filtered_products: [...action.payload],
      filters:{...state.filters, max_price: maxPrice, price: maxPrice},
    }
  }

  if(action.type === SET_GRIDVIEW){
    return {
      ...state,
      grid_view: true,
    }
  }

  if(action.type === SET_LISTVIEW){
    return {
      ...state,
      grid_view: false,
    }
  }

  if(action.type === UPDATE_SORT){
    return {
      ...state,
      sort: action.payload,
    }
  }

  if(action.type === SORT_PRODUCTS){
    const { sort, filtered_products } = state
    let tempProducts = [...filtered_products]

    if(sort === 'price-lowest'){
      tempProducts = tempProducts.sort((a, b) => a.price - b.price)
    }
    if(sort === 'price-highest'){
      tempProducts = tempProducts.sort((a, b) => b.price - a.price)
    }
    if(sort === 'name-a'){
      tempProducts = tempProducts.sort((a, b) => {
        return a.name.localeCompare(b.name)
      })
    }
    if(sort === 'name-z'){
      tempProducts = tempProducts.sort((a, b) => {
        return b.name.localeCompare(a.name)
      })
    }
    return {
      ...state,
      filtered_products: tempProducts,
    }
  }

  if(action.type === UPDATE_FILTERS){
    const { name, value } = action.payload
    return {
      ...state,
      filters:{ ...state.filters, [name]: value }
    }
  }

  if(action.type === FILTER_PRODUCTS){
    const { all_products } = state
    const { text, company, category, color, price, shipping } = state.filters
    
    let tempProducts = [...all_products]
    
    if(text !== ''){
      tempProducts = tempProducts.filter((product) => product.name.toLowerCase().startsWith(text))
    }
    if(category !== 'all'){
      tempProducts = tempProducts.filter((product) => product.category === category)
      console.log(tempProducts)
    }
    if(company !== 'all'){
      tempProducts = tempProducts.filter((product) => product.company === company)
    }
    if(color !== 'all'){
      tempProducts = tempProducts.filter((product) => {
        return product.colors.find((c) => c === color)
      })
    }
    if(price !== 0){
      tempProducts = tempProducts.filter((product) => product.price <= price)
    }

    if(shipping !== false){
      tempProducts = tempProducts.filter((product) => product.shipping === true )
    }

    return {
      ...state,
      filtered_products: tempProducts
      }
  }

  if(action.type === CLEAR_FILTERS){
    return {
      ...state,
      filters: {
        ...state.filters,
        text: '',
        company: 'all',
        category: 'all',
        color: 'all',
        price: state.filters.max_price,
        shipping: false,
      },
    }
  }


}

export default filter_reducer
