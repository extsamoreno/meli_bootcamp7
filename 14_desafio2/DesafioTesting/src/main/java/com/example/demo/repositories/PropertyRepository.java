package com.example.demo.repositories;

import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.Property;

public interface PropertyRepository {
    void loadData();
    Property addProperty(Property propertyRequestDTO);
    Property findPropertyById(int propId) throws PropertyDontFoundException;
}
