import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];

  //Subjects we listen to from other components(Cart component) that when data changes...
  //these subjects will send out that new data info to the components subscribed to them(listening)

  //Changing from subject to BehaviorSubject so that when our later components get initialized, 
  //like the checkout component, they will still be able to subscribe to the last bit of data that was sent out by the 
  //cart service where if this was subject only, that data would have been lost since the checkout component doesn't
  //get created until later in the application. 
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalQuantity: Subject<number> = new BehaviorSubject<number>(0);

  //storage: Storage = sessionStorage; //access to web browsers session storage
  storage: Storage = localStorage; //using local storage instead of session so the products stay in cart due to caching


  constructor() {
    let data = JSON.parse(this.storage.getItem('cartItems'));

    if(data != null){
      this.cartItems = data;
    
      this.computeCartTotals();
    }

   }

  addToCart(cartItem: CartItem){

    //Check if item being added is already in cart
    let alreadyInCartItem: boolean = false;
    let existingCartItem: CartItem = undefined;

    if(this.cartItems.length > 0){
      //Find the item in the cart using id
      existingCartItem = this.cartItems.find( currentCartItem => currentCartItem.id === cartItem.id );
      //Check if we found item
      alreadyInCartItem = (existingCartItem != null);
    }

    if(alreadyInCartItem){
      existingCartItem.quantity++;
    }else{
      this.cartItems.push(cartItem);
    }

    this.computeCartTotals();
  }

  computeCartTotals(){
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    //-- Loop through all items in cart to update totals for price and quantity
    for(let item of this.cartItems){
      totalPriceValue += item.quantity * item.unitPrice;
      totalQuantityValue += item.quantity;
    }

    //-- Publish new data...all subscribers will receive data
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    this.persistCartItems();

  }

  persistCartItems(){
    this.storage.setItem('cartItems', JSON.stringify(this.cartItems));
  }

  decrementQuantity(cartItem: CartItem) {
    cartItem.quantity--;

    if(cartItem.quantity === 0){
      this.remove(cartItem);
    }else{
      this.computeCartTotals();
    }
  }

  remove(cartItem: CartItem) {
    const itemIndex = this.cartItems.findIndex(item => item.id === cartItem.id);

    //Found index
    if(itemIndex > -1){
      this.cartItems.splice(itemIndex, 1);

      this.computeCartTotals();
    }
  }
}
