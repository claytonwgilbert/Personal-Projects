import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';

import { Recipe } from '../recipe.model';
import { RecipeService } from '../recipe.service';


@Component({
    selector: 'app-recipe-list',
    templateUrl: './recipe-list.component.html',
    styleUrls: ['./recipe-list.component.css']
  })
export class RecipeListComponent implements OnInit{
  recipes: Recipe[];
  subscription: Subscription;

  constructor(private recipeService: RecipeService,
              private router: Router,
              private route: ActivatedRoute){}

  ngOnInit(){
    //Here we listen for when a recipe is altered in another component and when so, update the recipes in this list being 
    //displayed automatically
    this.subscription = this.recipeService.recipesChanged.subscribe(
      (recipes : Recipe[]) => {
        this.recipes = recipes;
      }
    )

    //Displays all recipes when page is loaded using service
    this.recipes = this.recipeService.getRecipes();
  }

  //Navigate to new recipe creation component via url
  onNewRecipe(){
    this.router.navigate(['new'], {relativeTo: this.route});
  }

  //Prevent memory leaks
  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}