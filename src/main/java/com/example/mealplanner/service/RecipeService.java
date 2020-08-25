package com.example.mealplanner.service;

import com.example.mealplanner.MealplannerApplication;
import com.example.mealplanner.dto.RecipeDTO;
import com.example.mealplanner.model.Recipe;
import com.example.mealplanner.repository.RecipeRepository;
//import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RecipeService {

    private static final Logger LOGGER= LoggerFactory.getLogger(RecipeService.class);

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    private ModelMapper modelMapper;

    private RecipeDTO convertToRecipeToDTO(Recipe recipe) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        RecipeDTO recipeDTO = modelMapper.map(recipe, RecipeDTO.class);
        return recipeDTO;
    }

    private Recipe convertToRecipe(RecipeDTO recipeDTO) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        return recipe;
    }

    public RecipeDTO addNewRecipe(RecipeDTO recipeDTO) {
        return this.convertToRecipeToDTO(recipeRepository.save(this.convertToRecipe(recipeDTO)));
    }

}
