package com.example.mealplanner.dto;

import com.example.mealplanner.model.Unit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
//@JsonIgnoreProperties(value = { "id" })
public class AddIngredientToRecipeDTO {

    private Long ingredientId;
    private String measurementQuantity;
    private String measurementUnit;
}
