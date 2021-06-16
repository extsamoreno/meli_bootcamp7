package com.example.desafio2.repositories;

import com.example.desafio2.models.Property;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PropertyRepository implements IPropertyRepository {
    HashMap<Integer, Property> propertyHm = new HashMap<>();

    @Override
    public void add(Property property) {
        try{
            propertyHm.put(propertyHm.size()+1, property);
            listProperties();
        }catch (Exception e){
            //TODO: handle exception
        }
    }

    @Override
    public Property getPropertyById(int propertyId) {
        return propertyHm.get(propertyId);
    }

    private void listProperties(){
        propertyHm.forEach((a,b) -> {
            System.out.println(b.toString());
        });
    }
}
