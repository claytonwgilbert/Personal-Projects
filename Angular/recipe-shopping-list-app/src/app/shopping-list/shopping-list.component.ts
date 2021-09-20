import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from './shopping-list.service';


@Component({
    selector: 'app-shopping-list',
    templateUrl: './shopping-list.component.html',
    styleUrls: ['./shopping-list.component.css']
  })
export class ShoppingListComponent implements OnInit, OnDestroy{
  ingredients: Ingredient[];
  private ingChangeSub: Subscription;

  constructor(private slService: ShoppingListService){}

  ngOnInit(){
    this.ingredients = this.slService.getIngredients();
    //Listen for when ingredients array changes...
    this.ingChangeSub = this.slService.ingredientsChanged.subscribe(
      (ingredients : Ingredient[]) => {
        //When change detected, update array with new ingredient changes
        this.ingredients = ingredients;
      }
    )
  }

  ngOnDestroy(){
    this.ingChangeSub.unsubscribe();
  }

  onEditItem(index: number){
    //This .next pushes this recipe id when edit button is clicked and that id variable is then assigned to a variable 
    //already created in our service.
    this.slService.startedEditing.next(index);
  }

}