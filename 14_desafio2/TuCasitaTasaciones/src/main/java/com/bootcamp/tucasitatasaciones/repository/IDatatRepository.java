package com.bootcamp.tucasitatasaciones.repository;

import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Property;

public interface IDatatRepository {

    District findDistrictById(Long id);

    Property findPropertyById(Long id);
}
