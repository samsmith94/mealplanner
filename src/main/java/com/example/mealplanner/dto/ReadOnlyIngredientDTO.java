package com.example.mealplanner.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ReadOnlyIngredientDTO {

    private Long id;
    private String name;
    private Double calories;
    private Double protein;
    private Double fat;
    private Double carbohydrate;
    private Double gi;
    private String category;
    private String subcategory;

}
