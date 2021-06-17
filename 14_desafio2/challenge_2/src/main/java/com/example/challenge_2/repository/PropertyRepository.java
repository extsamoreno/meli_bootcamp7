package com.example.challenge_2.repository;

import com.example.challenge_2.exception.PropertyNotFoundException;
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

        try {

            IDistrictRepository districtRepository = new DistrictRepository();

            List<Environment> environmentList = new ArrayList<>();

            environmentList.add(new Environment("Room", 10d, 3d));
            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));

            this.propertys.put(1, new Property(1, "Genaro's House", districtRepository.getByName("Centro"), environmentList));

            environmentList = new ArrayList<>();

            environmentList.add(new Environment("Room", 10d, 3d));
            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));
            environmentList.add(new Environment("Yard", 20d, 3d));

            this.propertys.put(2, new Property(2, "Ajani's House", districtRepository.getByName("Pocitos"), environmentList));


            environmentList = new ArrayList<>();

            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));

            this.propertys.put(3, new Property(3, "Nissa's House", districtRepository.getByName("Aguada"), environmentList));

            environmentList = new ArrayList<>();

            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));

            this.propertys.put(4, new Property(4, "Kevin's House", districtRepository.getByName("Carrasco"), environmentList));

        } catch (Exception e) { //weird
            e.printStackTrace();
        }

    }

    @Override
    public boolean add(Property property) {
        int newId = getNextAvailableId(this.propertys.size());
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

    //Get the next available integer
    private int getNextAvailableId(int size) {
        int newId = size + 1;
        if (propertys.get(newId) != null) {
            return getNextAvailableId(size + 1);
        }
        return newId;
    }
}
