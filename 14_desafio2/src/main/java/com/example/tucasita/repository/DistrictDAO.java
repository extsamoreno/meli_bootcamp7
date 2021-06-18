package com.example.tucasita.repository;

import com.example.tucasita.model.District;

public interface DistrictDAO {
    void create(District district);
    District findByName(String districtName);
}
