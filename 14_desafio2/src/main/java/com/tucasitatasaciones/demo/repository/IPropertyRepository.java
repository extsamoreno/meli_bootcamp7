package com.tucasitatasaciones.demo.repository;

import com.tucasitatasaciones.demo.exception.ResponseException;
import com.tucasitatasaciones.demo.models.Property;

public interface IPropertyRepository {
    Property addProperty(Property property);
}
