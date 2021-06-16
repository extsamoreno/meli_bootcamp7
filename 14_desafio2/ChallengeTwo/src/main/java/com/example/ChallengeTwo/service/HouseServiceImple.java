package com.example.ChallengeTwo.service;

import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;
import com.example.ChallengeTwo.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImple implements  IHouseService{
    @Autowired
    IHouseRepository iHouseRepository;

    public double totalArea(House house){
        double totalArea=0;
        for (Environment room: house.getListEnvironment()) {
            totalArea+=room.getTotalArea();
        }
        return totalArea;
    }

    @Override
    public HouseTotalAreaDTO getTotalAreaHouse(String houseName) {
        House house = iHouseRepository.getHouseByName(houseName);
        return new HouseTotalAreaDTO(house.getHouseName(), totalArea(house));
    }
}
