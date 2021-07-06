package com.meli.desafio2.repositories;

import com.meli.desafio2.dtos.DistrictDTO;

public interface IDistrictRepository {
    DistrictDTO getDistrictByNameAndPrice(String nameDistrict, Double priceDistrict) throws NoSuchFieldException;
}
