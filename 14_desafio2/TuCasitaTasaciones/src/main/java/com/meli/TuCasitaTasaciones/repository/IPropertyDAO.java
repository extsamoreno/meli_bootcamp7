package com.meli.TuCasitaTasaciones.repository;

import com.meli.TuCasitaTasaciones.model.District;
import com.meli.TuCasitaTasaciones.model.Property;

import java.util.Set;

public interface IPropertyDAO {
    Property getPropertyById(int idProperty);
    Set<Property> getPropertyList();
    Set<District> getDistrictList();

}
