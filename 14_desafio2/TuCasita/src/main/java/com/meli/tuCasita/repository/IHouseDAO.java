package com.meli.tuCasita.repository;

import com.meli.tuCasita.exception.DistrictNotFoundException;
import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.District;
import com.meli.tuCasita.model.House;

public interface IHouseDAO {
    boolean save(House hus) throws HouseNotFoundException;
    House findById(Long id) throws  HouseNotFoundException;
    House findByDistrict(District district) throws DistrictNotFoundException;
}