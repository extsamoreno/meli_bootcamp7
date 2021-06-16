package com.example.desafio2.services;


import com.example.desafio2.dtos.HouseDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.models.Room;

import java.util.List;

public interface IHouseService {
    void add(HouseDTO house);
    double getTotalSquareMeters(int houseId);
    RoomDTO getBiggestRoom(int houseId);
    List<RoomAreaDTO> getRoomsAreas(int houseId);
    double getPrice (int houseId);
}
