package com.example.mealplanner.controller;

import com.example.mealplanner.model.*;
import com.example.mealplanner.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    MeasurementQuantityRepository measurementQuantityRepository;

    @Autowired
    MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;



    @GetMapping("try-db")
    public String tryDb() {
        // 100 g cukkini
        MeasurementQuantity _100 = new MeasurementQuantity(100);
        this.measurementQuantityRepository.save(_100);

        //hol kéne az átváltásokat csinálni? g, dkg, kanál
        MeasurementUnit _g = new MeasurementUnit(Unit.G);
        this.measurementUnitRepository.save(_g);

        // 2 kanál alma
        MeasurementQuantity _2 = new MeasurementQuantity(2);
        this.measurementQuantityRepository.save(_2);

        //hol kéne az átváltásokat csinálni? g, dkg, kanál
        MeasurementUnit kanal = new MeasurementUnit(Unit.TEASPOON);
        this.measurementUnitRepository.save(kanal);

        Recipe cukkinisalma = new Recipe("Ebéd", "Magyaros", "Zoli", "Főzd meg!");
        this.recipeRepository.save(cukkinisalma);

        //lekérdezés
        Ingredient cukkini = this.ingredientRepository.findByName("Cukkini");
        Ingredient alma = this.ingredientRepository.findByName("Alma");

        RecipeIngredient recipeIngredient1 = new RecipeIngredient(cukkinisalma, _g, _100, cukkini);
        this.recipeIngredientRepository.save(recipeIngredient1);
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(cukkinisalma, kanal, _2, alma);
        this.recipeIngredientRepository.save(recipeIngredient2);

        /**********************************************************************/
        return "TRY DB SUCCESS";
    }
}
