package com.example.demo.repositories;

import com.example.demo.exceptions.PropertyDontFoundException;
import com.example.demo.model.District;
import com.example.demo.model.Environment;
import com.example.demo.model.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PropertyRepositoryImple implements PropertyRepository {

    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Environment> environments = new ArrayList<>();
    private int id=1;
    Environment env1 = new Environment("Enviroment1",5d,10d);
    Environment env2 = new Environment("Enviroment2",6d,7d);
    Environment env3 = new Environment("Enviroment3",7d,8d);
    District district = new District(1,"District1",500d);
    Property prop1 = new Property(1,"Prop1",district,null);

    @Override
    public void loadData(){
        environments.add(env1);
        environments.add(env2);
        environments.add(env3);
        prop1.setEnvironments(environments);
        properties.add(prop1);

    }

    @Override
    public Property addProperty(Property property) {

        property.setProp_id(++id);

        properties.add(property);

        return property;
    }

    @Override
    public Property findPropertyById(int propId) throws PropertyDontFoundException {
        Property property = null;

        for(Property prop:properties){
            if( prop.getProp_id() == propId){
                property = prop;
            }
        }

        if(property == null){
            throw new PropertyDontFoundException(propId);
        }
        return property;
    }

}
