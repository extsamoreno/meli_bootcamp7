package com.meli.tucasita.repository;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.model.District;

public interface IDistrictRepository {
    public District getDistrictByName(String name) throws DistrictNotFoundException;
}
