package com.spring2.ejercicios.casa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private TotalAreaDTO totalArea;
    private PriceDTO price;
    private BiggerRoomDTO biggerRoom;
    private RoomsDTO rooms;
}
