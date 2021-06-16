package com.example.challenge_2.repository;

import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PropertyRepository implements IPropertyRepository {

    private HashMap<Integer, Property> property;

    @Autowired
    private IDistrictRepository neighborhoodRepository;

    public PropertyRepository() {
        this.property = new HashMap<>();

        try {

            List<Environment> environmentList = new ArrayList<>();

            environmentList.add(new Environment("Room", 10d, 3d));
            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));

            this.property.put(1, new Property(1,"Genaro's House", this.neighborhoodRepository.getByName("Centro"), environmentList));

            environmentList = new ArrayList<>();

            environmentList.add(new Environment("Room", 10d, 3d));
            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));
            environmentList.add(new Environment("Yard", 20d, 3d));

            this.property.put(2, new Property(2, "Ajani's House", this.neighborhoodRepository.getByName("Pocitos"), environmentList));


            environmentList = new ArrayList<>();

            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));

            this.property.put(3, new Property(3, "Nissa's House", this.neighborhoodRepository.getByName("Aguada"), environmentList));

            environmentList = new ArrayList<>();

            environmentList.add(new Environment("Kitchen", 20d, 3d));
            environmentList.add(new Environment("Living", 10d, 3d));
            environmentList.add(new Environment("Bathroom", 10d, 3d));

            this.property.put(4, new Property(4, "Kevin's House", this.neighborhoodRepository.getByName("Carrasco"), environmentList));

        } catch (Exception e) { //weird
            e.printStackTrace();
        }

    }
}
