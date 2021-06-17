package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.dto.RoomResponseDTO;

import java.util.List;

public interface ICalculateService {
    Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException;

    HouseDTO getHouseById(Integer id) throws HouseNotFoundException, DistrictNotFoundException;

    Double getTotalMeters(Integer id) throws HouseNotFoundException, DistrictNotFoundException;

    Double getTotalPrice(Integer id) throws HouseNotFoundException, DistrictNotFoundException;

    Room getBiggerRoom(Integer id) throws HouseNotFoundException;

    List<RoomResponseDTO> getmetterByRoom(Integer id) throws HouseNotFoundException;
}
