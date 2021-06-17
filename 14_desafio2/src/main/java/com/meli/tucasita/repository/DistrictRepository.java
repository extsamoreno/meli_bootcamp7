package com.meli.tucasita.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tucasita.models.District;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Repository
@Data
public class DistrictRepository {

    public static Set<District> districts = new HashSet<>();

    public DistrictRepository() {
        loadData();
    }

    public District getDistrictByName(String name) {
        return districts.stream().filter(district -> name.equals(district.getName())).findAny().orElse(null);
    }

    public boolean districtNameNotExists(String name) {
        return districts.stream().noneMatch(district -> name.equals(district.getName()));
    }

    public void loadData() {

        Set<District> loadedDataFromJson = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:districts_database.json");
            loadedDataFromJson = objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        districts = loadedDataFromJson;
    }

    private void saveDataIntoJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:districts_database.json");
            objectMapper.writeValue(file, districts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }


}
