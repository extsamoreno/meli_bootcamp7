package com.didney.junit.tucasitatasaciones.repository;

import com.didney.junit.tucasitatasaciones.model.District;

import java.util.List;

public interface IDistrictRepository {
    District addDistrict(District district);

    List<District> getDistricts();
}
