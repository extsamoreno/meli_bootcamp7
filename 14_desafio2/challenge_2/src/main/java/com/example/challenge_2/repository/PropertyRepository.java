package com.example.challenge_2.repository;

import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.District;
import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository {

    private HashMap<Integer, Property> propertys;

    public PropertyRepository() {
        this.propertys = new HashMap<>();


        List<Environment> environmentList = new ArrayList<>();

        environmentList.add(new Environment("Room", 10d, 3d));
        environmentList.add(new Environment("Kitchen", 20d, 3d));
        environmentList.add(new Environment("Living", 10d, 3d));
        environmentList.add(new Environment("Bathroom", 10d, 3d));

        this.propertys.put(1, new Property(1, "Genaro's House", new District("Centro", 10d), environmentList));

        environmentList = new ArrayList<>();

        environmentList.add(new Environment("Room", 10d, 3d));
        environmentList.add(new Environment("Kitchen", 20d, 3d));
        environmentList.add(new Environment("Living", 10d, 3d));
        environmentList.add(new Environment("Bathroom", 10d, 3d));
        environmentList.add(new Environment("Yard", 20d, 3d));

        this.propertys.put(2, new Property(2, "Ajani's House", new District("Pocitos", 20d), environmentList));


        environmentList = new ArrayList<>();

        environmentList.add(new Environment("Kitchen", 20d, 3d));
        environmentList.add(new Environment("Living", 10d, 3d));
        environmentList.add(new Environment("Bathroom", 10d, 3d));

        this.propertys.put(3, new Property(3, "Nissa's House", new District("Aguada", 15d), environmentList));

        environmentList = new ArrayList<>();

        environmentList.add(new Environment("Kitchen", 20d, 3d));
        environmentList.add(new Environment("Living", 10d, 3d));
        environmentList.add(new Environment("Bathroom", 10d, 3d));

        this.propertys.put(4, new Property(4, "Kevin's House", new District("Carrasco", 30d), environmentList));

    }

    @Override
    public boolean add(Property property) {
        int newId = this.propertys.size() + 1;
        property.setId(newId);
        propertys.put(newId, property);
        return true;
    }

    @Override
    public Property getById(int propertyId) throws PropertyNotFoundException {
        Property property = this.propertys.get(propertyId);

        if (property == null) {
            throw new PropertyNotFoundException(propertyId);
        }

        return property;
    }
}
