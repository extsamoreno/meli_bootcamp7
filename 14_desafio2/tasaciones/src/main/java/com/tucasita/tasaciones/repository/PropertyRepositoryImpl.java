package com.tucasita.tasaciones.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasita.tasaciones.model.Property;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

    private List<Property> properties;
    private int currentId;

    @PostConstruct
    private void init() throws IOException {
        loadDatabase();
    }

    @Override
    public Property getPropertyById(int id) {
        Optional<Property> prop = this.properties.stream().filter(p -> p.getId() == id).findFirst();
        return prop.orElse(null);
    }

    @Override
    public void saveProperty(Property property) throws IOException {
       property.setId(++currentId);
       this.properties.add(property);
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.writeValue(ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/properties.json"), this.properties);
    }

    private void loadDatabase() throws IOException {
        File file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/main/resources/properties.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Property>> typeRef = new TypeReference<>() {};
        List<Property> properties = null;
        this.properties = objectMapper.readValue(file, typeRef);
        if (properties.size() > 0 ) {
            currentId = this.properties.stream().mapToInt(Property::getId).max().getAsInt();
        } else {
            currentId = 0;
        }
    }

}
