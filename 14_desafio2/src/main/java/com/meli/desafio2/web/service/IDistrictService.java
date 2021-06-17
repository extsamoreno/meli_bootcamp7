package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.DistrictDTO;
import com.meli.desafio2.web.exception.DistrictAlreadyExistException;

public interface IDistrictService {
    DistrictDTO getDistrictByName(String name);
    void save(DistrictDTO districtDTO) throws DistrictAlreadyExistException;
}
