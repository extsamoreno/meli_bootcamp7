package com.meli.tucasitatasaciones.repository.district;

import com.meli.tucasitatasaciones.model.District;

import java.util.List;

public interface IDistrictRepository {
    District findDistrictByName(String name);
}
