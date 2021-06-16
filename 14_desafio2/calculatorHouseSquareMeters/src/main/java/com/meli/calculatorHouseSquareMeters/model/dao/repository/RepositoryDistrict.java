package com.meli.calculatorHouseSquareMeters.model.dao.repository;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;

public interface RepositoryDistrict {
    District getDistrictByName(String name);
    boolean putDistrict(District district);
}
