package com.example.CalculadoraMetrosCuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HouseResponseSquareFeetPerRoomDTO {
  private List<RoomSquareFeetDTO> roomsSquareFeet;

}
