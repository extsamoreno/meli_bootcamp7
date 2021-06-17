package com.example.testing.repositories;

import com.example.testing.databse.DataBase;
import com.example.testing.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PropertiesRepository implements IPropertiesRepository{

    private ArrayList<Property> dataBaseProperties = DataBase.dataBaseProperties;

    @Override
    public Property getPropertyById(int id) {
        for (Property property: dataBaseProperties) {
            if(property.getId() == id){
                return property;
            }
        }
        return null;
    }

    @Override
    public void createProperty(Property p) {
        dataBaseProperties.add(p);
    }
}
