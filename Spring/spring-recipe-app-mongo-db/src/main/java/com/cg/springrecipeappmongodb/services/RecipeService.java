package com.cg.springrecipeappmongodb.services;


import com.cg.springrecipeappmongodb.commands.RecipeCommand;
import com.cg.springrecipeappmongodb.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String id);
}
