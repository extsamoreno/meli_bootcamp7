package com.tucasita.tasaciones.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasita.tasaciones.exception.NeighborhoodNotFoundException;
import com.tucasita.tasaciones.model.Neighborhood;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Repository
public class NeighborhoodRepositoryImpl implements NeighborhoodRepository {

    private String SCOPE;
    private List<Neighborhood> neighborhoods;

    public NeighborhoodRepositoryImpl() throws IOException {
        Properties properties = new Properties();
        properties.load(new ClassPathResource("application.properties").getInputStream());
        this.SCOPE = properties.getProperty("api.scope");
        this.loadNeighborhoods();
    }

    @Override
    public Neighborhood getByName(String name) {
        return neighborhoods.stream().filter(n -> n.getName().equals(name)).findFirst().orElse(null);
    }

    private void loadNeighborhoods() throws IOException {
        File file = ResourceUtils.getFile(System.getProperty("user.dir") + "/src/" + SCOPE + "/resources/neighborhoods.json");
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Neighborhood>> typeRef = new TypeReference<>(){};
        this.neighborhoods = objectMapper.readValue(file, typeRef);
    }
}
