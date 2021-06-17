package com.example.testingchallengev2.service;

import com.example.testingchallengev2.model.response.*;

public interface IHouseInfoService {
    DistrictListResponseDTO getDistrictListDTO();
    HouseListResponseDTO getHouseListDTO();

    TotalHouseAreaResponseDTO getTotalHouseAreaResponseDTO(String houseName);

    HouseValueResponseDTO getHouseValueResponseDTO(String houseName);

    HouseBiggestRoomResponseDTO getHouseBiggestRoomResponseDTO(String houseName);

    RoomsSizeResponseDTO getRoomsSizeResponseDTO(String houseName);
}
