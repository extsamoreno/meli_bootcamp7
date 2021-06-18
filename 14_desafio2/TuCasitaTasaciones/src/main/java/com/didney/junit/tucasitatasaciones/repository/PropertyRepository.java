package com.didney.junit.tucasitatasaciones.repository;

import com.didney.junit.tucasitatasaciones.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository {
    List<Property> properties = new ArrayList<>();
    int cont = 0;

    @Override
    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public Property getPropertyById(int id) {
        return properties.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    @Override
    public Property addProperty(Property property) {
        property.setId(cont++);
        properties.add(property);
        return property;
    }
}
