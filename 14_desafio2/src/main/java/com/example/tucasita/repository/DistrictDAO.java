package com.example.tucasita.repository;

import com.example.tucasita.model.DistrictDTO;

public interface DistrictDAO {
    void create(DistrictDTO district);
    DistrictDTO findByName(String districtName);
}
