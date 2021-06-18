package com.tucasitatasaciones.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasitatasaciones.demo.dto.DistrictDTO;
import com.tucasitatasaciones.demo.models.District;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

@Repository
public class DistrictRepository implements IDistrictRepository{
    private String SCOPE;
    private ArrayList<District> districts;

    public DistrictRepository() {
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
    public District findDistrictById(int id) {
        loadData();
        District district = districts.stream()
                                .filter(d -> d.getId() == id)
                                .findFirst()
                                .orElse(null);
        return district;

    }

    private void loadData() {
        ArrayList<District> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/" + SCOPE +"/resources/districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<ArrayList<District>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        this.districts = loadedData;
    }
}
