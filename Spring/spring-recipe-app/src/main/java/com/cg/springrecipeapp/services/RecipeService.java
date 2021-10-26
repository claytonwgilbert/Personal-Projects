package com.cg.springrecipeapp.services;

import com.cg.springrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
