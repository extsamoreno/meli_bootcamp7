package com.meli.tucasitatasaciones.repository.property;

import com.meli.tucasitatasaciones.exception.PropertyNotFoundException;
import com.meli.tucasitatasaciones.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository  {
    private final List<Property> properties;

    public PropertyRepository() {
        this.properties = new ArrayList<>();
    }

    @Override
    public void saveProperty(Property property) {
        property.setId(this.properties.size() + 1);
        this.properties.add(property);
    }

    @Override
    public Property findPropertyById(Integer id) {
        return this.properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().orElseThrow(() -> new PropertyNotFoundException(id));
    }
}
