package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalValueDTO;
import com.example.ChallengeTwo.mapper.MapperHouse;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;
import com.example.ChallengeTwo.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
