package com.meli.calculatorHouseSquareMeters.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseTotalQuantityResponseDTO {
    private String houseName;
    private double totalPrice;
    private double totalSquareMeters;
}
