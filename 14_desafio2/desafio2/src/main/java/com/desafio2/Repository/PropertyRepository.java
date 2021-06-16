package com.desafio2.Repository;

import com.desafio2.Exception.PropertyNotFoundException;
import com.desafio2.Model.Property;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
public class PropertyRepository implements IPropertyRepository{

    private String SCOPE;

    private Set<Property> properties;

    public PropertyRepository() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Property property) {
        this.delete(property.getProp_name());
        properties.add(property);
        this.saveData();
    }

    @Override
    public boolean delete(String name) {
        boolean ret = false;
        try {
            Property found = this.findByName(name);
            properties.remove(found);
            ret  = true;
            this.saveData();
        } catch (PropertyNotFoundException e) {}

        return ret;
    }

    @Override
    public boolean exists(Property property) {
        boolean ret = false;

        try {
            ret  = this.findByName(property.getProp_name()) != null;
        }
        catch (PropertyNotFoundException e) {}

        return ret;
    }

    @Override
    public Property findByName(String name) {
        loadData();
        return properties.stream()
                .filter(prop -> prop.getProp_name().equals(name))
                .findFirst()
                .orElseThrow(() -> new PropertyNotFoundException(name));
    }

    private void loadData() {
        Set<Property> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/properties.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<Property>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.properties = loadedData;
    }

    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            objectMapper.writeValue(file, this.properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
