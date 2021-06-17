package com.bootcamp.tucasitatasaciones.repository;

import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Property;

public interface IDatatRepository {

    District findDistrictById(Long id);

    District findDistrictByName(String name);

    Property findPropertyById(Long id);
}
