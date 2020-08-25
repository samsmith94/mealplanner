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
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private Long id;

    @Column()
    private String category;

    @Column()
    private String cuisine;

    @Column(name = "created_by")
    private String createdBy;

    @Column()
    private String instructions;

    public Recipe(String category, String cuisine, String createdBy, String instructions) {
        this.category = category;
        this.cuisine = cuisine;
        this.createdBy = createdBy;
        this.instructions = instructions;
    }
}
