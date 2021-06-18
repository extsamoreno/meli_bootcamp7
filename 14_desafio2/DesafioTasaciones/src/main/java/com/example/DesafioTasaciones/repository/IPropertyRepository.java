package com.example.DesafioTasaciones.repository;

import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.Property;

import java.util.List;

public interface IPropertyRepository {
   District findDistrictByName(String name);
   void saveProperty(Property property);
   Property findPropertyById(Integer id);
   List<Property> getAllProperties();
}
