package com.example.ChallengeTwo.mapper;

import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalValueDTO;
import com.example.ChallengeTwo.model.House;

public class MapperHouse {
    public static HouseTotalAreaDTO toHouseTotalAreaDTO(House house, double totalArea){
        return new HouseTotalAreaDTO(house.getHouseName(),totalArea);
    }
    public static HouseTotalValueDTO toHouseTotalValueDTO (House house, double totalArea, double price){
        return new HouseTotalValueDTO(house.getHouseName(),house.getListEnvironment().size(),totalArea, price);
    }
}
