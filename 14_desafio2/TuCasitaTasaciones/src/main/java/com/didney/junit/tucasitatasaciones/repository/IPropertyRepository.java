package com.didney.junit.tucasitatasaciones.repository;

import com.didney.junit.tucasitatasaciones.model.Property;

import java.util.List;

public interface IPropertyRepository {
    //Get all properties
    List<Property> getProperties ();
    //Get Property when id equals to id
    Property getPropertyById (int id);
    //Add new property to list
    Property addProperty(Property property);
}
