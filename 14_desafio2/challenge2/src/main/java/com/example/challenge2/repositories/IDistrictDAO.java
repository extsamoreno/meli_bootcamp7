package com.example.challenge2.repositories;

import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;

public interface IDistrictDAO {

    District save(District district);
    District findByName(String districtName) throws DistrictNotFoundException;
    Boolean exist(String districtName);
}
