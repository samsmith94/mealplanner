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
@JsonIgnoreProperties(value = { "id" })
public class IngredientBaseDTO {

    // GET ESETÉN MINDENT LEKÉRÜNK, DE SET ESETÉN CSAK az ID-t!!!!

    //DE HOVA CSAPJUK HOZZÁ A mennyiség + mértékegységet???
    //leszármazás, cagy külön DTO????

    //RW
    private Long id;
    //ÖSSZES TÖBBI CSAK READ
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String name;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String category;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double carbohydrate;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double protein;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double fat;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double calories;
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double gi;
}

//a IngredientDTO legyen abstract, hogy magában azt ne lehesen használni? muszály legyen örökölni???
/*
class postIngredientDTO extends IngredientBaseDTO {

    private Double measurementQuantity;
    private Unit measurementUnit;

    // + ugye az örökölt ID

}
 */