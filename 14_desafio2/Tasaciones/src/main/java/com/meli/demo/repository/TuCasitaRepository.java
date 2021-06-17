package com.meli.demo.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.model.House;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class TuCasitaRepository implements ITuCasitaRepository{



    private Set<House> houses;
    HashMap<String, Double> neighborhoods = new HashMap<>();

    public TuCasitaRepository() {
        LoadHouses();
        neighborhoods.put("Paraiso", 2000.0);
        neighborhoods.put("Amsterdam", 4500.0);
        neighborhoods.put("Munich", 1900.0);
        neighborhoods.put("Madrid", 2340.0);
        neighborhoods.put("Funza", 1700.0);
        neighborhoods.put("Paraiso", 1908.0);
    }
    @Override
    public  HashMap<String, Double> viewNeighborhoods() {
       return neighborhoods;
    }


    private void LoadHouses() {
        Set<House> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/house.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<House>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
        this.houses = loadedData;
    }

    @Override
    public House getHouseByname(String name) throws HouseNotFoundException {
        return getHouseByName(name);
    }


    @Override
    public Boolean newCasita(House house) throws NeighborhoodNotFounException, HouseExistException, PriceIncorrectException {
        boolean create=false;
        if(!findHouseByName(house.getName())  & findNighborhoodByName(house.getNeighborhood().getName()) != null){
            if(findNighborhoodByName(house.getNeighborhood().getName()).equals(house.getNeighborhood().getPrice())){
                houses.add(house);
                saveData();
                create=true;
            }
            else{
                throw new PriceIncorrectException(house.getNeighborhood().getName(),house.getNeighborhood().getPrice());
            }
        }
        return create;
    }



    private boolean findHouseByName(String name ) throws HouseExistException {

        for (House cadena : houses) {
            if(cadena.getName().equals(name)){
                throw new HouseExistException(name);
            }
        }
        return false;
    }

    private House getHouseByName(String name ) throws HouseNotFoundException {

        boolean exist=false;

        for (House cadena : houses) {
            if(cadena.getName().equals(name)){
                exist=true;
                return cadena;
            }
        }
        if(!exist){
            throw new HouseNotFoundException(name);
        }
        return null;
    }

    private Double findNighborhoodByName(String name ) throws NeighborhoodNotFounException {
        if (neighborhoods.get(name) == null) {
            throw new NeighborhoodNotFounException(name);
        }
        return neighborhoods.get(name);
    }



    private void saveData() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/house.json");
            objectMapper.writeValue(file, this.houses);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
        LoadHouses();
    }

}
