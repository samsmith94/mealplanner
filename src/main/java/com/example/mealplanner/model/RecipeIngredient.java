package com.example.mealplanner.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Data
//@Builder
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

    @ManyToOne
    @JoinColumn(name = "measurement_quantity_id")
    private MeasurementQuantity measurementQuantity;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    public RecipeIngredient(Recipe recipe, MeasurementUnit measurementUnit, MeasurementQuantity measurementQuantity, Ingredient ingredient) {
        this.recipe = recipe;
        this.measurementUnit = measurementUnit;
        this.measurementQuantity = measurementQuantity;
        this.ingredient = ingredient;
    }
}
