package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.DistrictDTO;
import com.meli.desafio2.web.model.District;

public class DistrictMapper {
    public static DistrictDTO toDTO(District district){
        return new DistrictDTO(district.getDistrict_name(), district.getDistrict_price());
    }
}
