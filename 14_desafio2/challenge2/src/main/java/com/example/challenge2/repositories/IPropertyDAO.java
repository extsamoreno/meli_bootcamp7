package com.example.challenge2.repositories;

import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.models.Property;

public interface IPropertyDAO {
    PropertyDTO findByName(String propertyName);

    PropertyDTO save(PropertyDTO property);

    boolean delete(String propertyName);
}
