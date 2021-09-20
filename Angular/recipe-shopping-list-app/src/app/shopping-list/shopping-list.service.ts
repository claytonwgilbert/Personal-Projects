import { EventEmitter } from '@angular/core';
import { Subject } from 'rxjs';
import { Ingredient } from '../shared/ingredient.model';

export class ShoppingListService{
    ingredientsChanged = new Subject<Ingredient[]>();
    startedEditing = new Subject<number>();
    private ingredients: Ingredient[] = [
        new Ingredient("Apples", 10),
        new Ingredient("Bananas", 3)
      ];

      getIngredients(){
        return this.ingredients.slice();
      }

      getIngredient(index: number){
        return this.ingredients[index];
      }

      //Adds ingredient to array that is then referenced in shopping list component.ts file
      addIngredient(ingredient: Ingredient){
        this.ingredients.push(ingredient);
        this.ingredientsChanged.next(this.ingredients.slice());
      }

      //We use this method since the recipe service passes these ingredients as arguments to this method, before the shopping 
      //list service pushes the ingredients to the shopping list component
      addIngredientToShoppingList(ingredients: Ingredient[]){
        this.ingredients.push(...ingredients); //the three dots takes the individual elements from the array and adds them
        //to the existing array instead of trying to add an array to another array
        this.ingredientsChanged.next(this.ingredients.slice());
      }

      updateIngredient(index: number, newIng: Ingredient){
        this.ingredients[index] = newIng;
        this.ingredientsChanged.next(this.ingredients.slice());
      }

      deleteIngredient(index: number){
        this.ingredients.splice(index, 1);
        this.ingredientsChanged.next(this.ingredients.slice());
      }
}