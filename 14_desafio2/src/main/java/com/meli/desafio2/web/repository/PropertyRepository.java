package com.meli.desafio2.web.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import lombok.Data;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Data
public class PropertyRepository implements IPropertyRepository {

    private List<Property> properties = loadDataProperty();

    private List<Property> loadDataProperty() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:property.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Property>> typeRef = new TypeReference<>() {};
        List<Property> properties = null;

        try {
            properties = objectMapper.readValue(file,typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return properties;

    }

    @Override
    public Property getPropertyByName(String name) {
        for(Property property:properties){
            if(property.getProp_name().equals(name)){
                return property;
            }
        }
        return null;
    }

    @Override
    public void saveProperty(Property property) {
        properties.add(property);
        System.out.println(properties);
    }
}
