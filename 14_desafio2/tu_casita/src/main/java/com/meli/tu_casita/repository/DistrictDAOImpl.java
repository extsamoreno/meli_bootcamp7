package com.meli.tu_casita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tu_casita.model.District;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Repository
public class DistrictDAOImpl implements IDistrictDAO {

    private String path;

    private List<District> districts;

    private final ObjectMapper objectMapper;

    public DistrictDAOImpl() {
        Properties properties = new Properties();
        objectMapper = new ObjectMapper();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");
            this.path = "./src/" + scope + "/resources/suburbs.json";
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(District district) {
        district.setId(this.districts.size() + 1);
        districts.add(district);
        this.saveData();
    }

    @Override
    public Optional<District> findById(int id) {
        loadData();
        return districts.stream().filter(district -> district.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<District> findByName(String name) {
        loadData();
        return districts.stream().filter(district -> district.getName().compareTo(name) == 0).findFirst();
    }

    @Override
    public List<District> getDistrictList() {
        loadData();
        return districts;
    }

    private void loadData() {
        List<District> loadedData = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile(path);
            TypeReference<List<District>> typeReference = new TypeReference<>() {
            };
            loadedData = objectMapper.readValue(file, typeReference);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        this.districts = loadedData;
    }

    private void saveData() {
        try {
            File file = ResourceUtils.getFile(this.path);
            this.objectMapper.writeValue(file, this.districts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
