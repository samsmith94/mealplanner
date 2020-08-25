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
@Table(name = "measurement_quantities")
public class MeasurementQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "measurement_quantity_id")
    private Long id;

    @Column()
    private Double amount;

    public MeasurementQuantity(double amount) {
        this.amount = amount;
    }
}
