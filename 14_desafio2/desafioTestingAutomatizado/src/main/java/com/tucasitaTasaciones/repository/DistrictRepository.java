package com.tucasitaTasaciones.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tucasitaTasaciones.model.District;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository
public class DistrictRepository implements IDistrictRepository {

    private List<District> districtsList;

    public DistrictRepository() {
        districtsList = loadDatabase();
    }

    @Override
    public District findDistrictByName(String name) {
        District district = null;

        if (districtsList != null) {
            Optional<District> item = districtsList.stream()
                    .filter(d -> d.getDistrict_name().toLowerCase().contains(name.toLowerCase()))
                    .findFirst();
            if (item.isPresent())
                district = item.get();
        }
        return district;
    }

    private List<District> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {
        };

        List<District> districts = null;
        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return districts;
    }
}
