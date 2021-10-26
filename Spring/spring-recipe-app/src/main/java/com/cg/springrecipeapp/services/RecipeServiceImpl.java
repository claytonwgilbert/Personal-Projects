package com.cg.springrecipeapp.services;

import com.cg.springrecipeapp.domain.Recipe;
import com.cg.springrecipeapp.repositories.RecipeRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return  recipeSet;
    }
}
