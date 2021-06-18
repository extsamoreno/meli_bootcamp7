package com.meli.tu_casita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tu_casita.model.RealState;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class RealStateRepositoryImpl implements IRealStateRepository {

    private List<RealState> realStates;
    private String path;
    private ObjectMapper objectMapper;

    public RealStateRepositoryImpl() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");
            this.path = "./src/" + scope + "/resources/realStates.json";
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RealStateRepositoryImpl(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");
            this.path = "./src/" + scope + "/resources/"+fileName+".json";
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(RealState realState) {
        realState.setId(realStates.size() + 1);
        realStates.add(realState);
        saveData();
    }

    @Override
    public boolean exists(RealState realState) {
        boolean result = false;
        if (realState.getName() != null) result = this.findByName(realState.getName()) != null;
        if (realState.getId() != null) result = this.findById(realState.getId()) != null;
        return result;
    }

    @Override
    public RealState findById(int id) {
        return realStates.stream().filter(realState -> realState.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public RealState findByName(String name) {
        loadData();
        return realStates.stream().filter(realState -> realState.getName().compareTo(name) == 0).findFirst().orElse(null);
    }

    @Override
    public List<RealState> getRealStateList() {
        return realStates;
    }

    private void loadData() {
        List<RealState> loadedData = new ArrayList<>();
        objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(path);
            TypeReference<List<RealState>> typeReference = new TypeReference<>() {
            };
            loadedData = objectMapper.readValue(file, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        this.realStates = loadedData;
    }

    private void saveData() {
        objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile(this.path);
            objectMapper.writeValue(file, this.realStates);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
