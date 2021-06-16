package com.example.ChallengeTwo.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseTotalValueDTO {
    private String houseName;
    private int cantEnvironments;
    private double totalArea;
    private double price;
}
