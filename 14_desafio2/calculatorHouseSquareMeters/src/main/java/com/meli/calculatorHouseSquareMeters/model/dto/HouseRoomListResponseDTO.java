package com.meli.calculatorHouseSquareMeters.model.dto;

import com.meli.calculatorHouseSquareMeters.model.dao.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseRoomListResponseDTO {
    private String houseName;
    private ArrayList<Room> rooms;
}
