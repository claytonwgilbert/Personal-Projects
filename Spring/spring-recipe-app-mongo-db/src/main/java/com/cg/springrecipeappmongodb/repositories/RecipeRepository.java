package com.cg.springrecipeappmongodb.repositories;

import com.cg.springrecipeappmongodb.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
