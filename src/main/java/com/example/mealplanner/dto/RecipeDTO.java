package com.example.mealplanner.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
//@JsonIgnoreProperties(value = { "id" })
public class RecipeDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String category;
    private String cuisine;
    private String createdBy;
    private String instructions;

    //private List<IngredientDTO> ingredients = new ArrayList<>();

}


//legfaszább ötlet: nem is recipe + ingredientet kell posztolni, hanem a RecipeIngredientet!!!! arra kéne DTO