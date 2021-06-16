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
        boolean deleted = this.deleteProperty(property.getId());

        if(!deleted)
            property.setId(this.properties.size() + 1);

        this.properties.add(property);

//        this.properties.stream().forEach(p -> System.out.println(p));
    }

    @Override
    public Property findPropertyById(Integer id) {
        return this.properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().orElseThrow(() -> new PropertyNotFoundException(id));
    }

    private boolean deleteProperty(Integer id) {
        boolean deleted = false;

        try {
            Property property = this.findPropertyById(id);

            this.properties.remove(property);
            deleted = true;
        } catch(PropertyNotFoundException ex) { }

        return deleted;
    }
}
