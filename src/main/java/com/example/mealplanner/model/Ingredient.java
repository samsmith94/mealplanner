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

    @Column(name = "name")
    private String name;

    //name, category, carbohydrate, protein, fat, calories, gi
    //"Burgonya (főtt)", "Zöldségek", 18.2, 1.7, 0.1, 86, 58
    @Column()
    private String category;

    @Column()
    private Double carbohydrate;

    @Column()
    private Double protein;

    @Column()
    private Double fat;

    @Column()
    private Double calories;

    @Column(name = "GI")
    private Double gi;

    public Ingredient(String name, String category, double carbohydrate, double protein, double fat, double calories, double gi) {
        this.name = name;
        this.category = category;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.calories = calories;
        this.gi = gi;
    }
}
