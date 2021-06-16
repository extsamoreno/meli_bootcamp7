package com.meli.tucasitatasaciones.repository.district;

import com.meli.tucasitatasaciones.model.District;

import java.util.List;

public interface IDistrictRepository {
    List<District> getAllDistricts();
    District findDistrictByName(String name);
}
