package com.example.challenge2.repository;

import com.example.challenge2.models.District;

import java.util.Map;

public interface IDistrictRepository {

    Map<String, District> getDistricts();
    void setDistricts(Map<String, District> districts);
}