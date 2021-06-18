package com.example.demo.service.mapper;

import com.example.demo.models.District;
import com.example.demo.service.dto.DistrictDTO;

public class DistrictMapper implements IDistricMapper{
    @Override
    public District districtDTOToDistrict(DistrictDTO districtDTO) {
        District district = new District();
        district.setDistric_price(districtDTO.getDistric_price());
        district.setDistric_name(districtDTO.getDistric_name());
        return district;
    }

    @Override
    public DistrictDTO districtToDistrictDTO(District district) {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistric_name(district.getDistric_name());
        districtDTO.setDistric_price(district.getDistric_price());
        return districtDTO;
    }
}
