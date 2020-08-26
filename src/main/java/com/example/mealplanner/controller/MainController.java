package com.example.mealplanner.controller;

import com.example.mealplanner.model.*;
import com.example.mealplanner.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
class ProbaRecipe {
    private Long id;
    private String category;
    private String cuisine;
    private String createdBy;
    private String instructions;

    private List<ProbaIngredient> ingredients = new ArrayList<>();
}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
class ProbaIngredient {
    private Long ingredientId;
    private String measurementQuantity;
    private String measurementUnit;
}

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


    @PostMapping("/add-recipe")
    public String createRecipe(@RequestBody ProbaRecipe probaRecipe) {

        // NEM KÉNE MINDENEKELŐTT ELLENŐRIZNI A POSTBAN KAOTT ÉRTÉKEKET??

        //ez gyakorlatilag a DTO to Entiy
        Recipe recipe = new Recipe(probaRecipe.getCategory(), probaRecipe.getCuisine(), probaRecipe.getCreatedBy(), probaRecipe.getInstructions());
        //lehet is menteni az adatbázisba
        recipeRepository.save(recipe);

        //összetevők kinyerése, itt igazából nem alakítunk entity-vé
        List<ProbaIngredient> ingredientsList = probaRecipe.getIngredients();

        for (ProbaIngredient probaIngredient : ingredientsList) {
            //3 lépés: összetevő id, mennyiség, mértékegység
            Ingredient ingredient = ingredientRepository.getOne(probaIngredient.getIngredientId());

            //itt most kell a parseDouble, de mi lenne ha a ProbaIngredient-ben nem string lenne, hanem eleve double? post során jó lesz sztem úgy is
            MeasurementQuantity measurementQuantity = new MeasurementQuantity(Double.parseDouble(probaIngredient.getMeasurementQuantity()));
            this.measurementQuantityRepository.save(measurementQuantity);
            // itt figyelni kell hogy pontosan az legyen amit az adatbázis elfogad?? vagy elég lenne csak a mértékegység id-ej
            // vagy eleve át kéne alakítani egy kicsit ezt a részét a modelnek???
            MeasurementUnit measurementUnit = new MeasurementUnit(Unit.valueOf(probaIngredient.getMeasurementUnit()));
            this.measurementUnitRepository.save(measurementUnit);
            //aztán a negyedik lépés maga a join table:
            RecipeIngredient recipeIngredient = new RecipeIngredient(recipe, measurementUnit, measurementQuantity, ingredient);
            this.recipeIngredientRepository.save(recipeIngredient);
        }

        return "add-recipe";
    }
}
