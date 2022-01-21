import {
  ADD_TO_CART,
  CLEAR_CART,
  COUNT_CART_TOTALS,
  REMOVE_CART_ITEM,
  TOGGLE_CART_ITEM_AMOUNT,
} from '../actions'

const cart_reducer = (state, action) => {
  
  if(action.type === ADD_TO_CART){
    //get data from context which came from add to cart component
    const { id, color, amount, product } = action.payload
    //see if product we want to add is in cart already
    const itemInCart = state.cart.find((item) => item.id === id + color)
    if(itemInCart){
      //if in cart...look through items in cart and find the one matching with id
      const tempCart = state.cart.map((cartItem) => {
        if(cartItem.id === id + color){
          //set new amount on item that matches
          let newQuantity = cartItem.amount + amount
          if(newQuantity > cartItem.max){
            newQuantity = cartItem.max
          }
          //return cart item with new values
          return {...cartItem, amount: newQuantity }
        }else{
          return cartItem
        }
      })
      //return new cart with updated item
      return {...state, cart: tempCart}
    }else{
      const newItem = {
        id: id + color, 
        name: product.name,
        color: color, 
        amount: amount,
        image: product.images[0].url,
        price: product.price,
        max: product.stock,
      }
      return {
        ...state,
        cart: [...state.cart, newItem],
      }
    }
  }

  if(action.type === CLEAR_CART){
    return {
      ...state,
      cart: [],
    }
  }

  if(action.type === REMOVE_CART_ITEM){
    const newCart = state.cart.filter((item) => item.id !== action.payload)
    return {
      ...state,
      cart: [
        newCart
      ],
    }
  }

  if(action.type === TOGGLE_CART_ITEM_AMOUNT){
    const {id, value} = action.payload
    const tempCart = state.cart.map((item) => {
      if(id === item.id){
        if(value === 'inc'){
          let newAmount = item.amount + 1
          if(newAmount > item.max){
            newAmount = item.max
          }
          return {...item, amount: newAmount}
        }
        if(value === 'dec'){
          let newAmount = item.amount - 1
          if(newAmount < 1){
            newAmount = 1
          }
          return {...item, amount: newAmount}
        }
      }else{
        return item
      }
    })
    return {...state, cart: tempCart}
  }

  if(action.type === COUNT_CART_TOTALS){
    const { total_items, total_amount } = state.cart.reduce((total, cartItem) => {
      const { amount, price } = cartItem
      total.total_items += amount
      total.total_amount += price * amount
      return total
    }, 
    {
      total_items: 0,
      total_amount: 0,
    })
    return {...state, total_amount, total_items}
  }
}

export default cart_reducer
