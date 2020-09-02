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
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private Long id;

    @Column()
    private String name;

    @Column()
    private Double calories;

    @Column()
    private Double protein;

    @Column()
    private Double fat;

    @Column()
    private Double carbohydrate;

    @Column()
    private String gi;

    @Column()
    private String category;

    @Column()
    private String subcategory;

    public Ingredient(String name, double calories, double protein, double fat, double carbohydrate, String gi, String category, String subcategory) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.gi = gi;
        this.category = category;
        this.subcategory = subcategory;
    }
}
