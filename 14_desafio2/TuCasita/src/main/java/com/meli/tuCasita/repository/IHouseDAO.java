package com.meli.tuCasita.repository;

import com.meli.tuCasita.exception.DistrictNotFoundException;
import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;

import java.util.Optional;

public interface IHouseDAO {
    boolean save(HouseDTO hus) throws HouseNotFoundException;
    HouseDTO findById(Long id) throws  HouseNotFoundException;
    HouseDTO findByDistrict(DistrictDTO districtDTO) throws DistrictNotFoundException;
}