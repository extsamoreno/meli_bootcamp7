package com.meli.desafio.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.desafio.models.District;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.House;
import com.meli.desafio.models.dto.HouseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class DataBase {
    public static HashMap<Integer, House> listHouses = new HashMap<>();
    public static HashMap<Integer, District> listDistricts = new HashMap<>();

    public void loadDistricts() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:districts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<District>> typeRef = new TypeReference<>() {};
        List<District> listDistrictsJSON = null;

        try{
            listDistrictsJSON = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(District d: listDistrictsJSON){
            this.listDistricts.put(d.getId(), d);
        }
    }

    public void loadHouses() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:houses.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<House>> typeRef = new TypeReference<>() {};
        List<House> listHouseJSON = null;

        try{
            listHouseJSON = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        for(House h: listHouseJSON){
            this.listHouses.put(h.getId(), h);
        }
    }
}