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
@Table(name = "measurement_units")
public class MeasurementUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "measurement_unit_id")
    private Long id;

    @Column()
    @Enumerated(EnumType.STRING)
    private Unit unit;

    public MeasurementUnit(Unit unit) {
        this.unit = unit;
    }
}
