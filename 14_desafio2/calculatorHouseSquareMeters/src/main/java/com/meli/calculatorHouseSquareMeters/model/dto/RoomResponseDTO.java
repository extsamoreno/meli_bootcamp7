package com.meli.calculatorHouseSquareMeters.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDTO {
    private String name;
    private double totalSquareMeters;
}
