package com.example.CalculadoraMetrosCuadrados.repository;


import com.example.CalculadoraMetrosCuadrados.dto.District;
import com.example.CalculadoraMetrosCuadrados.exceptions.DistrictNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class DistrictRepository implements IDistrictRepository {

    List<District> districts;
    private final String FILE_NAME;

    public DistrictRepository() {
        this.FILE_NAME = "m2PorBarrio.json";
        this.districts = loadFromDB();
    }

    private List<District> loadFromDB() {
        List<District> ret = null;

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:" + FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        var objectMapper = new ObjectMapper();

        try {
            ret = objectMapper.readValue(file, new TypeReference<List<District>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public District getDistrictByNameAndPrice(String districtName, Double districtPrice) throws DistrictNotFoundException{
        return this.districts.stream()
                .filter(district -> district.getDistrictName().equals(districtName) && district.getDistrictPrice().equals(districtPrice))
                .findFirst().orElseThrow(() -> new DistrictNotFoundException("The district with name: " + districtName + " and price: " + districtPrice + " doesn't belong to the database."));
    }
}
