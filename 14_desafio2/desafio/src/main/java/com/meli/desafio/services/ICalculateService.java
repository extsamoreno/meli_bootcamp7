package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.HouseDTO;

public interface ICalculateService {
    Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException;

    HouseDTO getHouseById(Integer id) throws HouseNotFoundException;
}
