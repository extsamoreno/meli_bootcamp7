package com.example.testingchallengev2.repository.house;

import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.House;
import com.example.testingchallengev2.model.request.HouseDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

@Repository
public class HouseRepository implements IHouseRepository {

    @Autowired
    ModelMapper modelMapper;

    private HashMap<String, House> houses = findAllHouse();

    public HashMap<String, House> findAllHouse() {
        HashMap<String, House> loadedData = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:houses.json");
            loadedData = objectMapper.readValue(file, new TypeReference<HashMap<String, House>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }


    @Override
    public House getHouseByName(String houseName) throws HouseNotFoundException {
        if(findHouseByName(houseName))
        {
            return houses.get(houseName);
        }
        else
        {
            throw new HouseNotFoundException();
        }
    }

    @Override
    public boolean findHouseByName(String houseName) {
        return houses.containsKey(houseName);
    }

    @Override
    public HashMap<String, House> getHouses() {
        return houses;
    }

    @Override
    public boolean createHouse(HouseDTO houseDTO) {
        boolean creationResult = false;
        House newHouse = modelMapper.map(houseDTO, House.class);
        if(!findHouseByName(newHouse.getName()))
        {
            houses.put(newHouse.getName(), newHouse);
            creationResult = true;
        }
        return creationResult;
    }
}
