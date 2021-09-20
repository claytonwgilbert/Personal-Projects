import { Component, Input } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Recipe } from '../recipe.model';
import { RecipeService } from '../recipe.service';


@Component({
    selector: 'app-recipe-detail',
    templateUrl: './recipe-detail.component.html',
    styleUrls: ['./recipe-detail.component.css']
  })
export class RecipeDetailComponent{
  recipe: Recipe;
  id: number;

  constructor(private recipeService: RecipeService, 
              private route: ActivatedRoute,
              private router: Router){}

  //Here we are getting the id of the recipe from the url as a paramater and assigning the current recipe id to our local 
  //id variable. before finally using our service to go fetch our specific recipe object and populating our local recipe
  //we do that so that we can fulfill the addToShoppingList functionality below...
  ngOnInit(){
    this.route.params
            .subscribe(
              (params: Params) => {
                this.id = +params['id'];
                this.recipe = this.recipeService.getRecipe(this.id);
              }
            );
  }

  addToShoppingList(){
    this.recipeService.addIngredientToShoppingList(this.recipe.ingredients);
  }

  //When edit choice is selected from dropdown this click listener navigates to edit component
  //relativeTo is so we don't have to explicitly state the url and we can just use edit since we are
  //already have recipes/ in the url and just adding edit gets us to our full url of recipes/edit
  onEditRecipe(){ 
    this.router.navigate(['edit'], {relativeTo: this.route});
  }

  onDeleteRecipe(){
    this.recipeService.deleteRecipe(this.id);
    this.router.navigate(['/recipes']);
  }
}