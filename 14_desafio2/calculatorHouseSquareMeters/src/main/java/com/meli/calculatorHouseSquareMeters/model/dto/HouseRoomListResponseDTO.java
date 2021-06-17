package com.meli.calculatorHouseSquareMeters.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseRoomListResponseDTO {
    private String houseName;
    private ArrayList<RoomResponseDTO> rooms;
}
