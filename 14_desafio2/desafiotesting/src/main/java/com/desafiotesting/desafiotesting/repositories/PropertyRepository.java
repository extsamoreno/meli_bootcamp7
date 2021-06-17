package com.desafiotesting.desafiotesting.repositories;
import com.desafiotesting.desafiotesting.models.Property;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository{

    private List<Property> properties;

    public PropertyRepository() {
        this.properties = new ArrayList<>();
    }

    @Override
    public void save(Property property){
        property.setId((this.properties.size() + 1));
        properties.add(property);
    }

    @Override
    public Property findById(int id) {
        return properties.stream()
                .filter(property -> property.getId() == id)
                .findFirst().orElse(null);
    }

}
