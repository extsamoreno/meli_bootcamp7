package com.meli.tu_casita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tu_casita.model.Environment;
import com.meli.tu_casita.model.dto.EnvironmentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Repository
public class EnvironmentDAOImpl implements IEnvironmentDAO {

    @Autowired
    ModelMapper modelMapper;

    private List<Environment> environments;
    private String path;
    private ObjectMapper objectMapper;

    public EnvironmentDAOImpl() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");
            this.path = "./src/" + scope + "/resources/environments.json";
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Environment environment) {
        environment.setId(this.environments.size() + 1);
        environments.add(environment);
        this.saveData();
    }

    @Override
    public boolean exists(int id) {
        return this.findById(id) != null;
    }

    @Override
    public Environment findById(int id) {
        loadData();
        return environments.stream().filter(environment -> environment.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Environment> getEnvironmentsListByRealStateId(int realStateId) {
        return environments.stream().filter(environment -> environment.getRealStateId().equals(realStateId)).collect(Collectors.toList());
    }

    private void loadData() {
        List<Environment> loadedData = new ArrayList<>();
        objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(path);
            TypeReference<List<Environment>> typeReference = new TypeReference<>() {
            };
            loadedData = objectMapper.readValue(file, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        this.environments = loadedData;
    }

    private void saveData() {
        objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(this.path);
            objectMapper.writeValue(file, this.environments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
