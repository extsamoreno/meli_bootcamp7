package com.tuCasita.tuCasita.repository;

import com.tuCasita.tuCasita.models.District;

import java.util.HashMap;
import java.util.List;

public interface iDistrictRepository {

    List<District> loadDataBase();
    HashMap<String, Double> loadDistricts();
    HashMap<String, Double> getDistricts();
}
