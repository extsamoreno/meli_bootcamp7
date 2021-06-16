package com.example.ChallengeTwo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment {
    private String environmentName;
    private double environmentWidth, environmentLength;

    public double getTotalArea(){
        return environmentLength*environmentWidth;
    }
}
