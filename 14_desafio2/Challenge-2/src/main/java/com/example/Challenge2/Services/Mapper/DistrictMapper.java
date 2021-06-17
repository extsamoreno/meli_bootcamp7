package com.example.Challenge2.Services.Mapper;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Services.DTOs.DistrictDTO;

import java.util.ArrayList;
import java.util.List;

public class DistrictMapper {

    public static DistrictDTO toDTO(District district){
        return new DistrictDTO(district.getName(), district.getPricePerM2());
    }
    public static District toDistrict(DistrictDTO districtDTO){
        return new District(null,districtDTO.getName(), districtDTO.getPricePerM2());
    }

    public static List<DistrictDTO> toDTOs(List<District> districts){
        List<DistrictDTO> output = new ArrayList<>();
        for (int i = 0; i < districts.size(); i++) {
            output.add(DistrictMapper.toDTO(districts.get(i)));
        }
        return output;
    }
}
