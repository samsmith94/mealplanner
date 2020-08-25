/*
package com.example.mealplanner.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasalMetabolicRateCalculatorService {

    //TODO: metric vs imperial és hozzá átváltás a calculate metódusba!
    private Gender gender;
    private double height;
    private double weight;
    private int age;
    private Activity dailyActivity;

    double calculateBMR() {
        double BMR = 0.0;

        if (gender == Gender.MALE) {
            BMR = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        } else if(gender == Gender.FEMALE) {
            BMR = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        }

        switch (dailyActivity) {
            case SEDENTARY:
                BMR *= 1.2;
                break;
            case LIGHTLY_ACTIVE:
                BMR *= 1.375;
                break;
            case MODERATELY_ACTIVE:
                BMR *= 1.55;
                break;
            case VERY_ACTIVE:
                BMR *= 1.725;
                break;
            case EXTRA_ACTIVE:
                BMR *= 1.9;
                break;
            default:
                BMR *= 1.55;
                break;
        }
        return BMR;
    }

}
*/