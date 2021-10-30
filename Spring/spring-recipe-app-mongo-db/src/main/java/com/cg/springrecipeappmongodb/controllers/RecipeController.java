package com.cg.springrecipeappmongodb.controllers;

import com.cg.springrecipeappmongodb.commands.RecipeCommand;
import com.cg.springrecipeappmongodb.exceptions.NotFoundException;
import com.cg.springrecipeappmongodb.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showRecipeById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(id));

        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdateRecipe(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult result){

        if(result.hasErrors()){
            result.getAllErrors().forEach(error -> {
                log.debug(error.toString());
            });

            return "recipe/recipeform";
        }

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show" + savedCommand.getId();
    }

    @GetMapping("/recipe/{id}/update")
    public String showUpdateRecipeForm(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(id));

        return "recipe/recipeform";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        recipeService.deleteById(id);

        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){

        log.error("Handling not found exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}
