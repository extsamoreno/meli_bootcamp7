package com.bootcamp.desafio2.repository.district;

import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.model.District;

public interface IDistrictRepository {

    boolean existsDistrictInDB(String district_name) throws DistrictNotFoundException;
}
