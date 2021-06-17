package com.desafiotesting.api.service.mapper;

import com.desafiotesting.api.dto.DistrictDTO;
import com.desafiotesting.api.model.District;
import org.springframework.stereotype.Component;

@Component
public class DistrictMapper {

    public District dtoToModel(DistrictDTO dto){
        District model = new District();
        model.setName(dto.getName());
        model.setPrice(dto.getPrice());
        return model;
    }
}
