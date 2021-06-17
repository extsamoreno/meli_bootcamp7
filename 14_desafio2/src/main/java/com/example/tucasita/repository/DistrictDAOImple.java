package com.example.tucasita.repository;

import com.example.tucasita.exception.DistrictNotFoundException;
import com.example.tucasita.exception.ExistentDistrictException;
import com.example.tucasita.model.DistrictDTO;
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
public class DistrictDAOImple implements DistrictDAO{

    private Set<DistrictDTO> districts;
    private String SCOPE;

    public DistrictDAOImple() {
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
    public void create(DistrictDTO district) {
        try {
            if (this.findByName(district.getDistrictName()) != null) {
                throw new ExistentDistrictException(district.getDistrictName());
            }
        } catch (DistrictNotFoundException e) {
            districts.add(district);

            this.saveData();
        }
    }

    @Override
    public DistrictDTO findByName(String districtName) {
        loadData();
        return districts.stream()
                .filter(district -> district.getDistrictName().equals(districtName))
                .findFirst().orElseThrow(() -> new DistrictNotFoundException(districtName));
    }

    private void loadData() {
        Set<DistrictDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<DistrictDTO>>(){});
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
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/districts.json");
            objectMapper.writeValue(file, this.districts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
