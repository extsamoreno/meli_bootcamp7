package com.meli.tucasitatasaciones.repository.district;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.tucasitatasaciones.model.District;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepository implements IDistrictRepository {
    private final List<District> districts;

    public DistrictRepository() {
        this.districts = loadDatabase();
    }
    @Override
    public List<District> getAllDistricts() {
        return this.districts;
    }

    @Override
    public District findDistrictByName(String name) {
        District district = null;

        if(this.districts != null) {
            Optional<District> item = this.districts.stream().filter(distr -> distr.getName().equals(name)).findFirst();
            if(item.isPresent())
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
        TypeReference<List<District>> typeRef = new TypeReference<>() {};

        List<District> districts = null;

        try {
            districts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return districts;
    }
}
