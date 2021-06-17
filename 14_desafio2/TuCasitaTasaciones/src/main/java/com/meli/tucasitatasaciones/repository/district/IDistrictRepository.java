package com.meli.tucasitatasaciones.repository.district;

import com.meli.tucasitatasaciones.model.District;

public interface IDistrictRepository {
    District findDistrictByName(String name);
}
