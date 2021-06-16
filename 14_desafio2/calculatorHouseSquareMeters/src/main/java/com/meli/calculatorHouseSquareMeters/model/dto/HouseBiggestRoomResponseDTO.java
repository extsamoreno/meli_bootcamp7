package com.meli.calculatorHouseSquareMeters.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseBiggestRoomResponseDTO {
    private String nameHouse;
    private String nameRoom;
    private double totalSquareMeters;
}
