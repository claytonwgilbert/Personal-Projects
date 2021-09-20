import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AuthComponent } from "./auth/auth.component";
import { AuthGuard } from "./auth/auth.guard";
import { RecipeDetailComponent } from "./recipes/recipe-detail/recipe-detail.component";
import { RecipeEditComponent } from "./recipes/recipe-edit/recipe-edit.component";
import { RecipeStartComponent } from "./recipes/recipe-start/recipe-start.component";
import { RecipesResolverService } from "./recipes/recipes-resolver-service";
import { RecipesComponent } from "./recipes/recipes.component";
import { ShoppingListComponent } from "./shopping-list/shopping-list.component";

//Routes for our application, these are like urls that when visited, tells us which component to display
const appRoutes: Routes = [
    {path: '', redirectTo: '/recipes', pathMatch: 'full'}, //pathMatch is to allow use of empty string and redirectTo
    {
    path: 'recipes', 
    canActivate: [AuthGuard], //AuthGuard, created in auth folder prevents users from directly typing into url the recipes url without first being authenticated.
    component: RecipesComponent, 
    children: [
        {path: '', component: RecipeStartComponent},
        {path: 'new', component: RecipeEditComponent, resolve: [RecipesResolverService]},
        {path: ':id', component: RecipeDetailComponent, resolve: [RecipesResolverService]}, //Wanna make sure id related paths are at the end of the list
        {path: ':id/edit', component: RecipeEditComponent}
    ]},
    {path: 'shopping-list', component: ShoppingListComponent},
    {path: 'auth', component: AuthComponent}
];

//NgModule imports configures our routes and exports allows us to import this module in our main app.module.ts to be used 
//throughout our application
@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
    exports: [RouterModule]
})
export class AppRoutingModule{

}