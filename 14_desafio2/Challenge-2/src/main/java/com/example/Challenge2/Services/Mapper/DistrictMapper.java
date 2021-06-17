package com.example.Challenge2.Services.Mapper;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Services.DTOs.DistrictDTO;


public class DistrictMapper {

    public static DistrictDTO toDTO(District district){
        return new DistrictDTO(district.getName(), district.getPricePerM2());
    }

    public static District toDistrict(DistrictDTO district){
        return new District(null,district.getName(), district.getPricePerM2());
    }
}
