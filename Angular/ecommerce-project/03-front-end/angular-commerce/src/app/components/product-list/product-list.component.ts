import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Product } from 'src/app/common/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;
  searchMode: boolean = false;

  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElements: number = 0;

  previousKeyword: string = null;

  constructor(private productService: ProductService, 
              private route: ActivatedRoute, 
              private cartService: CartService) { }

  ngOnInit(): void {
    //Anytime url changes rereun list products method for new changes
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  handleListProducts(){
    //Check if id param is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if(hasCategoryId){
      this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
    }
    else{
      this.currentCategoryId = 1;
    }

    //Check if category id has changed
    //If changed, reset page count to 1 as we on another category page
    if(this.currentCategoryId != this.previousCategoryId){
      this.thePageNumber = 1;
    }
    this.previousCategoryId = this.currentCategoryId;


    //-1 because paginate is 0 index based on rest side
    this.productService.getProductListPaginate(this.thePageNumber - 1, 
                                               this.thePageSize, 
                                               this.currentCategoryId)
                                               .subscribe(this.processResult());

    }

  listProducts(){
    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if(this.searchMode){
      this.handleSearchProducts();
    }else{
      this.handleListProducts();
    }
  }

  handleSearchProducts(){
    const theKeyword: string = this.route.snapshot.paramMap.get('keyword');

    //--check to make sure keyword hasn't changed, if so, change page number back to beginning.
    if(this.previousKeyword != theKeyword){
      this.thePageNumber = 1;
    }
    this.previousKeyword = theKeyword;

    this.productService.searchProductsPaginate(this.thePageNumber - 1, 
                                               this.thePageSize, 
                                               theKeyword).subscribe(this.processResult());
  }

  updatePageSize(pageSize: number){
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listProducts();
  }

  //Map JSON from Spring backend to our variables here in component - can see how to map by looking at rest call in browser to see how Spring is sending back the data
  processResult(){
    return data => {
      this.products = data._embedded.products;
      this.thePageNumber = data.page.number + 1; //Adding 1 because we got 0 index based results back from Spring and now need to add one for Anular which is 1 based.
      this.thePageSize = data.page.size;
      this.theTotalElements = data.page.totalElements;
    }
  }

  addToCart(product: Product){
    const cartItem = new CartItem(product);
    this.cartService.addToCart(cartItem);
  }

}
