package com.tucasitaTasaciones.repository;

import com.tucasitaTasaciones.exceptions.PropertyNotFoundException;
import com.tucasitaTasaciones.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PropertyRepository implements IPropertyRepository {

    private List<Property> properties;

    public PropertyRepository() {
        this.properties = new ArrayList<>();
    }

    @Override
    public void addNewProperty(Property property) {
        property.setPropId(properties.size() + 1);
        properties.add(property);
    }

    @Override
    public Property findProperty(Integer id) {

        Property property = properties.stream()
                .filter(prop -> prop.getPropId().equals(id))
                .findFirst().orElse(null);

        return property;
    }

    @Override
    public List<Property> getProperties() {
        return properties;
    }
}
