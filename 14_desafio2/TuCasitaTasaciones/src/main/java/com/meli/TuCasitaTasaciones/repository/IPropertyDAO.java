package com.meli.TuCasitaTasaciones.repository;

import com.meli.TuCasitaTasaciones.model.PropertyDTO;

import java.util.HashMap;
import java.util.Set;

public interface IPropertyDAO {
    PropertyDTO getPropertyById(int idProperty);
    Set<PropertyDTO> getPropertyList();
    HashMap<String, Double> getDistrictList();

    void addProperty(PropertyDTO propertyDTO);

}
