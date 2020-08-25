package com.example.mealplanner;

import com.example.mealplanner.model.Ingredient;
import com.example.mealplanner.model.MeasurementUnit;
import com.example.mealplanner.model.Unit;
import com.example.mealplanner.repository.IngredientRepository;
import com.example.mealplanner.repository.MeasurementUnitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class MealplannerApplication {



	public static void main(String[] args) {
		SpringApplication.run(MealplannerApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "Hello";
	}

	/*
	@Bean
	public ApplicationRunner initializer(IngredientRepository repository) {
		return args -> repository.saveAll(Arrays.asList(

	}
	*/
	@Bean
	public CommandLineRunner loadData(IngredientRepository ingredientRepository, MeasurementUnitRepository measurementUnitRepository) {
		return (args) -> {
			ingredientRepository.save(new Ingredient("Burgonya (főtt)", "Zöldségek", 18.2, 1.7, 0.1, 86.0, 58.0));
			ingredientRepository.save(new Ingredient("Cukkini", "Zöldségek", 2.5, 1.2, 0.3, 17, 55));
			ingredientRepository.save(new Ingredient("Alma", "Gyümöcsök", 11.4, 0.3, 0.2, 52, 38));
			//name, category, carbohydrate, protein, fat, calories, gi

			/*
			measurementUnitRepository.save(new MeasurementUnit(Unit.G));
			measurementUnitRepository.save(new MeasurementUnit(Unit.DKG));
			measurementUnitRepository.save(new MeasurementUnit(Unit.KG));
			measurementUnitRepository.save(new MeasurementUnit(Unit.ML));
			measurementUnitRepository.save(new MeasurementUnit(Unit.CL));
			measurementUnitRepository.save(new MeasurementUnit(Unit.DL));
			measurementUnitRepository.save(new MeasurementUnit(Unit.LITER));
			measurementUnitRepository.save(new MeasurementUnit(Unit.TABLESPOON));
			measurementUnitRepository.save(new MeasurementUnit(Unit.COFFEESPOON));
			measurementUnitRepository.save(new MeasurementUnit(Unit.PICKLE));
			measurementUnitRepository.save(new MeasurementUnit(Unit.PINCH));
			*/
		};
	}
	
}
