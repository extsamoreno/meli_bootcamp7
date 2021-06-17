package com.meli.desafio2.mapper;

import com.meli.desafio2.dto.DistrictDTO;
import com.meli.desafio2.dto.DistrictInputDTO;

public class DistrictMapper {

    public static DistrictDTO InputDTOToDto(DistrictInputDTO district){
        return new DistrictDTO(-1,district.getDistrict_name(), district.getDistrict_price());
    }
}
