package com.TuCasitaTasacionesAPI.TuCasita.repositories;

import com.TuCasitaTasacionesAPI.TuCasita.models.Property;

public interface IPropertyRepository {
    int create(Property property);
    boolean delete(int id);
    Property getById(int id);
    boolean checkPropertyExists(Property prop);
}
