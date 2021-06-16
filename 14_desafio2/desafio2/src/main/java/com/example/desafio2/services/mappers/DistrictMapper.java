package com.example.desafio2.services.mappers;

import com.example.desafio2.dtos.DistrictDTO;
import com.example.desafio2.models.District;

public class DistrictMapper {
    public static District toModel(DistrictDTO distDTO){
        District dist = new District();

        dist.setName(distDTO.getName());
        dist.setPrice(distDTO.getPrice());

        return dist;
    }
}
