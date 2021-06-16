package com.meli.desafio.repositories;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.dto.HouseDTO;

public interface ICalculateRepository {
    Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException;

    HouseDTO getById(Integer id) throws HouseNotFoundException;
}
