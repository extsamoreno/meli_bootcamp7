package com.example.ChallengeTwo.mapper;

import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;
import com.example.ChallengeTwo.dto.HouseTotalValueDTO;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.House;

public class MapperHouse {
    public static HouseTotalAreaDTO toHouseTotalAreaDTO(House house, double totalArea){
        return new HouseTotalAreaDTO(house.getHouseName(),totalArea);
    }
    public static HouseTotalValueDTO toHouseTotalValueDTO (House house, double totalArea, double price){
        return new HouseTotalValueDTO(house.getHouseName(),house.getListEnvironment().size(),totalArea, price);
    }
    public static House toHouse(HouseDTO houseDTO, District distric){
        return new House(houseDTO.getHouseName(), distric, houseDTO.getListEnvironment());
    }
    public static HouseDTO toHouseDTO(House house){
        return new HouseDTO(house.getHouseName(),house.getDistric().getDistricName(),house.getListEnvironment());
    }

}
