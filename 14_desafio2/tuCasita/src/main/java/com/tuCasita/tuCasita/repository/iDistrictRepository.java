package com.tuCasita.tuCasita.repository;

import com.tuCasita.tuCasita.models.District;

import java.util.HashMap;
import java.util.List;

public interface iDistrictRepository {

    List<District> loadDataBase();
    void loadDistricts();
    HashMap<String, Double> getDistricts();
}
