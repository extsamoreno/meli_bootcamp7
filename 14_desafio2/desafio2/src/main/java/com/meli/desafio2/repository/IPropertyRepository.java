package com.meli.desafio2.repository;

import com.meli.desafio2.dto.DistrictDTO;
import com.meli.desafio2.dto.PropertyDTO;
import com.meli.desafio2.dto.PropertyFullDTO;
import com.meli.desafio2.exception.PropertyNotFoundException;

public interface IPropertyRepository {

    PropertyDTO getById(int id) throws PropertyNotFoundException;

    PropertyFullDTO getFullById(int id) throws PropertyNotFoundException;

    DistrictDTO getDistrictByName(String district_name);

    int newDistrict(DistrictDTO district);

    int newProperty(PropertyDTO property);
}
