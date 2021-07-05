package com.example.demo.services.mappers;

import com.example.demo.model.District;
import com.example.demo.dtos.DistrictDTO;
import com.example.demo.dtos.DistrictRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperDistrict {

    public static District toDistrict(DistrictDTO districtDTO){
            District district = new District();

            district.setDistrict_id(districtDTO.getDistrict_id());
            district.setDistrict_name(districtDTO.getDistrict_name());
            district.setDistrict_price(districtDTO.getDistrict_price());

            return district;
    }

    public static District toDistrict(DistrictRequestDTO districtRequestDTO){
        District district = new District();

        district.setDistrict_name(districtRequestDTO.getDistrict_name());
        district.setDistrict_price(districtRequestDTO.getDistrict_price());

        return district;
    }

    public static DistrictDTO toDistrictDTO(District district){
        DistrictDTO districtDTO = new DistrictDTO();

        districtDTO.setDistrict_id(district.getDistrict_id());
        districtDTO.setDistrict_name(district.getDistrict_name());
        districtDTO.setDistrict_price(district.getDistrict_price());

        return districtDTO;
    }
}
