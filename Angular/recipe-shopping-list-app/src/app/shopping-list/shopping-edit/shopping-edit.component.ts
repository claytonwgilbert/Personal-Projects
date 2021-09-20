import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Ingredient } from 'src/app/shared/ingredient.model';
import { ShoppingListService } from '../shopping-list.service';


@Component({
    selector: 'app-shopping-edit',
    templateUrl: './shopping-edit.component.html',
    styleUrls: ['./shopping-edit.component.css']
  })
export class ShoppingEditComponent implements OnInit, OnDestroy{
  @ViewChild('f') slForm: NgForm;
  subscription: Subscription;
  editMode = false;
  editedItemIndex: number;
  editedItem: Ingredient;

  constructor(private slService: ShoppingListService){}

  ngOnInit(){
    //Listen for when that startedEditing subscription uses that next function to pass that recipe id
    this.subscription = this.slService.startedEditing
                            .subscribe(
                              (index: number) => {
                                this.editedItemIndex = index;
                                this.editMode = true;
                                this.editedItem = this.slService.getIngredient(index);
                                this.slForm.setValue({
                                  name: this.editedItem.name,
                                  amount: this.editedItem.amount
                                })
                              }
                            );
  }

  //Here we get access to our angular form and pass values from that form to create the new recipe
  onSubmit(form: NgForm){
    //Get entire ingredient object from form in html page
    const value = form.value;
    //Create new ingredient object based off values from our value object
    const newIngredient = new Ingredient(value.name, value.amount);
    //Depending on edit mode, wither add or update ingredient
    if(this.editMode){
      this.slService.updateIngredient(this.editedItemIndex, newIngredient);
    }else{
      this.slService.addIngredient(newIngredient);
    }
    //After all said and done always set edit mode back to false
    this.editMode = false;
    //Reset form
    form.reset();
  }

  onClear(){
    this.slForm.reset();
    this.editMode = false;
  }

  onDelete(){
    this.slService.deleteIngredient(this.editedItemIndex);
    this.onClear();
  }

  //Memory leak cleanup
  ngOnDestroy(){
    this.subscription.unsubscribe;
  }
}