package com.meli.desafio2.Repository;

import com.meli.desafio2.DTOS.DistrictDTO;
import com.meli.desafio2.Exception.DistrictNotFoundException;

import java.util.List;

public interface IDistrictRepository {
    DistrictDTO getDistrictByNameAndPrice(String nameDistrict, Double priceDistrict) throws DistrictNotFoundException;
}
