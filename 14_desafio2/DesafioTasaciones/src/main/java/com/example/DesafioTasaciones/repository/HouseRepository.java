package com.example.DesafioTasaciones.repository;

import com.example.DesafioTasaciones.exceptions.DistrictNotFound;
import com.example.DesafioTasaciones.exceptions.HouseNotFoundException;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.House;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HouseRepository implements IHouseRepository {
    private final List<District> districts;
    private final List<House> properties;

    public HouseRepository() {
        this.districts = loadDatabase();
        this.properties = new ArrayList<>();
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


    @Override
    public void saveProperty(House house) {
        house.setId(this.properties.size() + 1);
        this.properties.add(house);
    }

    @Override
    public House findPropertyById(Integer id) {
        return this.properties.stream().filter(prop -> prop.getId().equals(id)).findFirst().orElseThrow(() -> new HouseNotFoundException(id));
    }

    @Override
    public List<House> getAllProperties() {
        return this.properties;
    }

}
