package com.TuCasitaTasacionesAPI.TuCasita.repositories;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.PropertyDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.property.PropertyNotFoundException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.models.Environment;
import com.TuCasitaTasacionesAPI.TuCasita.models.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PropertyRepository implements IPropertyRepository{

    private Map<Integer, Property> houses;

    public PropertyRepository(){
        houses = new HashMap<>();
        this.loadData();
    }

    @Override
    public int create(Property property) throws PropertyAlreadyExistsException {
        int id;

        if(checkDistrictExists(property))
            throw new PropertyAlreadyExistsException(property.getProp_name(), property.getDistrict_id());
        else {
            id = houses.size() + 1;
            property.setDistrict_id(id);
            houses.put(id, property);
        }

        return id;
    }

    @Override
    public Property getById(int id) throws PropertyNotFoundException {
        Property property = houses.get(id);

        if(property != null)
            return property;
        else
            throw new PropertyNotFoundException(id);
    }

    private boolean checkDistrictExists(Property prop){
        return houses.values().stream()
                .anyMatch(x -> x.getProp_name().equals(prop.getProp_name()) &&
                               x.getDistrict_id().equals(prop.getDistrict_id()));
    }

    //=============================

    private void loadData() {
        Property prop1 = new Property(1, "Av. Marquez 123", 1, new ArrayList<>());
        Environment e1_prop1 = new Environment("Cocina", 3.0, 4.0);
        Environment e2_prop1 = new Environment("Living", 4.0, 4.0);
        Environment e3_prop1 = new Environment("Comedor", 5.0, 4.0);
        prop1.getEnvironments().add(e1_prop1);
        prop1.getEnvironments().add(e2_prop1);
        prop1.getEnvironments().add(e3_prop1);

        Property prop2 = new Property(2, "Av. Maipu 456", 2, new ArrayList<>());
        Environment e1_prop2 = new Environment("Cocina", 5.0, 5.0);
        Environment e2_prop2 = new Environment("Baño", 3.0, 2.0);
        Environment e3_prop2 = new Environment("Jardin", 7.0, 6.0);
        prop2.getEnvironments().add(e1_prop2);
        prop2.getEnvironments().add(e2_prop2);
        prop2.getEnvironments().add(e3_prop2);

        houses.put(1, prop1);
        houses.put(2, prop2);
    }
}
