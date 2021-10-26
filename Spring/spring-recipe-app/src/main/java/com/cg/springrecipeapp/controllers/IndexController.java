package com.cg.springrecipeapp.controllers;

import com.cg.springrecipeapp.services.RecipeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@NoArgsConstructor
public class IndexController {

    private RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
