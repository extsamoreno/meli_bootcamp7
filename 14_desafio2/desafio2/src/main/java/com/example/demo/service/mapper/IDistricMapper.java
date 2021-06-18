package com.example.demo.service.mapper;

import com.example.demo.models.District;
import com.example.demo.service.dto.DistrictDTO;

public interface IDistricMapper {
    District districtDTOToDistrict(DistrictDTO districtDTO);
    DistrictDTO districtToDistrictDTO(District district);
}
