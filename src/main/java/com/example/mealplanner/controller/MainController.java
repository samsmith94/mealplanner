package com.example.mealplanner.controller;

import com.example.mealplanner.dto.AddIngredientToRecipeDTO;
import com.example.mealplanner.dto.RecipeDTO;
import com.example.mealplanner.model.*;
import com.example.mealplanner.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired MeasurementQuantityRepository measurementQuantityRepository;
    @Autowired MeasurementUnitRepository measurementUnitRepository;
    @Autowired RecipeRepository recipeRepository;
    @Autowired IngredientRepository ingredientRepository;
    @Autowired RecipeIngredientRepository recipeIngredientRepository;

    @PostMapping("/add-recipe")
    public String createRecipe(@RequestBody RecipeDTO recipeDTO) {

        // NEM KÉNE MINDENEKELŐTT ELLENŐRIZNI A POSTBAN KAOTT ÉRTÉKEKET??

        //ez gyakorlatilag a DTO to Entiy
        Recipe recipe = new Recipe(recipeDTO.getCategory(), recipeDTO.getCuisine(), recipeDTO.getCreatedBy(), recipeDTO.getInstructions());
        //lehet is menteni az adatbázisba
        recipeRepository.save(recipe);

        //összetevők kinyerése, itt igazából nem alakítunk entity-vé
        List<AddIngredientToRecipeDTO> ingredientsList = recipeDTO.getIngredients();

        for (AddIngredientToRecipeDTO ingredient : ingredientsList) {
            //3 lépés: összetevő id, mennyiség, mértékegység
            Ingredient ingredientById = ingredientRepository.getOne(ingredient.getIngredientId());

            //itt most kell a parseDouble, de mi lenne ha a ProbaIngredient-ben nem string lenne, hanem eleve double? post során jó lesz sztem úgy is
            MeasurementQuantity measurementQuantity = new MeasurementQuantity(Double.parseDouble(ingredient.getMeasurementQuantity()));
            this.measurementQuantityRepository.save(measurementQuantity);
            // itt figyelni kell hogy pontosan az legyen amit az adatbázis elfogad?? vagy elég lenne csak a mértékegység id-ej
            // vagy eleve át kéne alakítani egy kicsit ezt a részét a modelnek???
            MeasurementUnit measurementUnit = new MeasurementUnit(Unit.valueOf(ingredient.getMeasurementUnit()));
            this.measurementUnitRepository.save(measurementUnit);
            //aztán a negyedik lépés maga a join table:
            RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, measurementUnit, measurementQuantity, ingredientById);
            this.recipeIngredientRepository.save(recipeIngredient);
        }

        return "OK";
    }
}
