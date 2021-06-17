package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.DistrictDTO;
import com.meli.desafio2.web.model.District;

public class DistrictMapper {
    public static DistrictDTO toDTO(District district){
        return new DistrictDTO(district.getDistrict_name(), district.getDistrict_price());
    }
    public static District toModel(DistrictDTO districtDTO){
        return new District(districtDTO.getDistrict_name(), districtDTO.getDistrict_price());
    }
}
