import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
  styleUrls: ['./recipe-edit.component.css']
})
export class RecipeEditComponent implements OnInit {
  id: number;
  editMode = false;
  recipeForm: FormGroup //This is the link we use to pass data to our form in our html via the initForm method below

  constructor(private route: ActivatedRoute, 
              private recipeService: RecipeService,
              private router: Router) { }
  
  //Here we are getting the id of the recipe from the url as a paramater and assigning the current recipe id to our local 
  //id variable. We also set the editMode to see if we are editing an existing recipe or creating a new one since both
  //actions use the same component. We use this editMode variable to check in the actual component what state we are
  //currently in.
  ngOnInit(): void {
    this.route.params
              .subscribe(
                (params: Params)=> {
                  this.id = +params['id']
                  this.editMode = params['id'] != null;
                  this.initForm(); //Calling initForm here because this means url paramaters changed thus meaning a new recipe was clicked on
                }
              )
  }

  get controls() { // getter for the ingredient controls we access in our html
    return (<FormArray>this.recipeForm.get('ingredients')).controls;
  }

  //Depending on edit mode, we either update a recipe or add new recipe
  onSubmit(){
    if(this.editMode){
      this.recipeService.updateRecipe(this.id, this.recipeForm.value);
    }else{
      this.recipeService.addRecipe(this.recipeForm.value);
    }
    this.onCancel(); //After we add or update, navigate away from form
  }

  //Move up a level in the url...previous page
  onCancel(){
    this.router.navigate(['../'], {relativeTo: this.route})
  }

  //Push into the recipeform array a new form group with two form controls for both name and amount, both null because they are new forms for user
  //to input the new ingredient data. Also add validators to ensure correct data is inputted
  onAddIngredient(){
    (<FormArray>this.recipeForm.get('ingredients')).push(
      new FormGroup({
        'name': new FormControl(null, Validators.required),
        'amount': new FormControl(null, [
          Validators.required,
          Validators.pattern(/^[1-9]+[0-9]*$/)
        ])
      })
    )
  }

  //Remove ingredient from recipeForm array using index passed in html
  onDeleteIngredient(index: number){
    (<FormArray>this.recipeForm.get('ingredients')).removeAt(index);
  }

  //Initializing the form when component is loaded
  private initForm(){
    //Create new variables
    let recipeName = '';
    let recipeImagePath = '';
    let recipeDescription = '';
    let recipeIngredients = new FormArray([]);

    //If in edit mode...
    if(this.editMode){
      //Find recipe using id
      const recipe = this.recipeService.getRecipe(this.id);
      //initialize variables created above with recipe data
      recipeName = recipe.name;
      recipeImagePath = recipe.imagePath;
      recipeDescription = recipe.description;
      //If recipe has ingredients...
      if(recipe['ingredients']){
        for(let ingredient of recipe.ingredients){
          //Loop through ingredients and add each ingredient to new form array by creating a new form group containing the
          //ingredient data such as name and amount as form controls
            recipeIngredients.push(
              new FormGroup({
                'name': new FormControl(ingredient.name, Validators.required),
                'amount': new FormControl(ingredient.amount, [
                  Validators.required,
                  Validators.pattern(/^[1-9]+[0-9]*$/)
                ]), 
              })
            );
        }
      }
    }

    //Pass the data we pulled from the recipe to the recipe form in the html page
    this.recipeForm = new FormGroup({
      'name': new FormControl(recipeName, Validators.required),
      'imagePath': new FormControl(recipeImagePath, Validators.required),
      'description': new FormControl(recipeDescription, Validators.required),
      'ingredients': recipeIngredients
    })
  }

}
