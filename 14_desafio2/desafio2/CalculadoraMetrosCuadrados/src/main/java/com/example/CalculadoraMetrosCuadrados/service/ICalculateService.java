package com.example.CalculadoraMetrosCuadrados.service;

import com.example.CalculadoraMetrosCuadrados.dto.*;

public interface ICalculateService {

    HouseResponseTotalSquareFeetDTO calculateTotalSquareFeet(HouseDTO house);

    HouseResponseValueDTO calculatePrice(HouseDTO house);

    RoomDTO getBiggestRoom(HouseDTO house);

    HouseResponseSquareFeetPerRoomDTO calculateSquareFeetPerRoom(HouseDTO house);
}
