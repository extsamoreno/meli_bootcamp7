package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.*;
import com.example.ChallengeTwo.mapper.MapperEnvironment;
import com.example.ChallengeTwo.mapper.MapperHouse;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;
import com.example.ChallengeTwo.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImple implements  IHouseService{
    @Autowired
    IHouseRepository iHouseRepository;

    public double calculateTotalArea(House house){
        double totalArea=0;
        for (Environment room: house.getListEnvironment()) {
            totalArea+=room.getTotalArea();
        }
        return totalArea;
    }

    public  double calculateTotalValue(House house){
        return calculateTotalArea(house)*house.getDistric().getDistricPrice();
    }

    public Environment getBiggerEnvironment(House house){
        Environment biggerEnvironment = null;
        double aux =0;
        for (Environment environment:house.getListEnvironment()) {
            if(environment.getTotalArea() > aux){
                aux= environment.getTotalArea();
                biggerEnvironment=environment;
            }
        }
        return biggerEnvironment;
    }
    public District getDistricByName(String districName){
        return iHouseRepository.getDistricByName(districName);
    }

    @Override
    public HouseTotalAreaDTO getTotalAreaHouse(String houseName) {
        House house = iHouseRepository.getHouseByName(houseName);
        return MapperHouse.toHouseTotalAreaDTO(house, calculateTotalArea(house));
    }

    @Override
    public HouseTotalValueDTO getTotalValueHouse(String houseName) {
        House house = iHouseRepository.getHouseByName(houseName);
        return  MapperHouse.toHouseTotalValueDTO(house,calculateTotalArea(house),calculateTotalValue(house));
    }

    @Override
    public BiggerEnvironmentDTO getBiggerEnviroment(String houseName) {
        House house = iHouseRepository.getHouseByName(houseName);
        return MapperEnvironment.toBiggerEnvironment(getBiggerEnvironment(house),houseName);
    }

    @Override
    public List<EnvironmentAreaDTO> getAllEnviromentsArea(String houseName) {
        House house = iHouseRepository.getHouseByName(houseName);
        List<EnvironmentAreaDTO> listResult = new ArrayList<>();
        for(Environment environment: house.getListEnvironment()){
            listResult.add(MapperEnvironment.toEnvironmentAreaDTO(environment));
        }
        return listResult;
    }
    @Override
    public String createNewHouse(HouseDTO house) {
        House houseAdd = MapperHouse.toHouse(house,getDistricByName(house.getDistricName()));
        return iHouseRepository.addNewHouse(houseAdd);
    }

    @Override
    public String createNewDistrict(DistrictDTO districtDTO) {
        District district = new District(districtDTO.getDistrictName(),districtDTO.getPrice());
        return iHouseRepository.addNewDistrict(district);
    }


}
