package com.example.testingchallengev2.service;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.response.*;

public interface IHouseInfoService {
    DistrictListResponseDTO getDistrictListDTO();
    HouseListResponseDTO getHouseListDTO();

    TotalHouseAreaResponseDTO getTotalHouseAreaResponseDTO(String houseName) throws HouseNotFoundException;

    HouseValueResponseDTO getHouseValueResponseDTO(String houseName) throws HouseNotFoundException, DistrictNotFoundException;

    HouseBiggestRoomResponseDTO getHouseBiggestRoomResponseDTO(String houseName) throws HouseNotFoundException;

    RoomsSizeResponseDTO getRoomsSizeResponseDTO(String houseName) throws HouseNotFoundException;
}
