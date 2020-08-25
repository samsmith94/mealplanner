package com.example.mealplanner.repository;

import com.example.mealplanner.model.MeasurementQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementQuantityRepository extends JpaRepository<MeasurementQuantity, Long> {
}
