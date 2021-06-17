package com.meli.desafio.repositories;

import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.dto.HouseDTO;

public interface ICalculateRepository {
    Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException;

    House getById(Integer id) throws HouseNotFoundException;

    District getDistrict(Integer districtId) throws DistrictNotFoundException;
}
