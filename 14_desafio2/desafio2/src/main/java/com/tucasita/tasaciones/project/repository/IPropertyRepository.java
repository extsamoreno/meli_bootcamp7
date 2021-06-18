package com.tucasita.tasaciones.project.repository;

import com.tucasita.tasaciones.project.exceptions.PropertyAlreadyExistsException;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.models.District;
import com.tucasita.tasaciones.project.models.Property;

public interface IPropertyRepository {
    Property findPropertyByName(String propertyName) throws PropertyNameNotFoundException;

    District findDistrictByName(String districtName) throws PropertyDistrictNameNotFoundException;

    void saveProperty(Property property) throws PropertyAlreadyExistsException, PropertyDistrictNameNotFoundException;
}
