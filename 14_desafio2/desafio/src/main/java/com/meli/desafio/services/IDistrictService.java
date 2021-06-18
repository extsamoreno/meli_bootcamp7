package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.DistrictAlreadyExists;
import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.DistrictRequestDTO;

public interface IDistrictService {
    Integer saveDistrict(DistrictRequestDTO district) throws DistrictAlreadyExists;

    DistrictDTO getById(Integer id) throws DistrictNotFoundException;
}
