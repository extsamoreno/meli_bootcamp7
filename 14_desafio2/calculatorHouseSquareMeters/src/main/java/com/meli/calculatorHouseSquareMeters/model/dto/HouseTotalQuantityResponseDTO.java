package com.meli.calculatorHouseSquareMeters.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseTotalQuantityResponseDTO {
    private String houseName;
    private double totalPrice;
    private double totalSquareMeters;
}
