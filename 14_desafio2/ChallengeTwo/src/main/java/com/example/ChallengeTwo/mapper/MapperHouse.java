package com.example.ChallengeTwo.mapper;

import com.example.ChallengeTwo.dto.HouseTotalAreaDTO;

public class MapperHouse {
    public static HouseTotalAreaDTO toHouseTotalAreaDTO(HouseTotalAreaDTO house, double totalArea){
        return new HouseTotalAreaDTO(house.getName(),totalArea);
    }
}
