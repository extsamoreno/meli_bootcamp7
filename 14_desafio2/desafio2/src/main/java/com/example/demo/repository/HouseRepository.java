package com.example.demo.repository;

import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.House;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class HouseRepository implements IHouseRepository {
    @Override
    public void addHouse(House house) {
        List<House> houseList = this.loadDatabase();
        houseList.add(house);
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/house.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file,houseList);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public House findHouseByName(String name) throws HouseNotFoundException {
        List<House> houseList = null;
        houseList = loadDatabase();
        House result = null;
        if (houseList!=null){
            Optional<House> item = houseList.stream().filter(house -> house.getProp_name().equals(name)).findFirst();
            if (item.isPresent()){
                result = item.get();
            }
            else
                throw new HouseNotFoundException(name);
        }
        return result;
    }

    @Override
    public List<House> getAllHouses() {
        return this.loadDatabase();
    }

    private List<House> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("src/main/resources/static/house.json");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<House>> typeReference = new TypeReference<>() {};
        List<House> houseList = null;
        try {
            houseList =  objectMapper.readValue(file,typeReference);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }
}
