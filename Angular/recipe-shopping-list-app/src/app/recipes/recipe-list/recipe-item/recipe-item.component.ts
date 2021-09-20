import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Recipe } from '../../recipe.model';

@Component({
    selector: 'app-recipe-item',
    templateUrl: './recipe-item.component.html',
    styleUrls: ['./recipe-item.component.css']
  })
export class RecipeItemComponent{
  //The @Input Recipe allows us to receive data passed in which we get from recipe-list component housing this component to 
  //display all the individual recipes.
  @Input() recipe: Recipe;
  @Input() index: number;

}