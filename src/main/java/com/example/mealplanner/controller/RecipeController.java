package com.example.mealplanner.controller;

import com.example.mealplanner.dto.RecipeDTO;
import com.example.mealplanner.model.Recipe;
import com.example.mealplanner.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @PostMapping("/add")
    RecipeDTO addNewRecipe(@RequestBody RecipeDTO recipeDTO) {
        return this.recipeService.addNewRecipe(recipeDTO);
    }

}
