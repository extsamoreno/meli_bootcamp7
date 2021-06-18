package com.didney.junit.tucasitatasaciones.mapper;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.model.District;
import org.springframework.stereotype.Component;

@Component
public class DistrictMapper {
    public District districtDTOToDistrict(DistrictDTO districtDTO) {
        return new District(0, districtDTO.getDistrictName(), districtDTO.getDistrictPrice());
    }

    public DistrictDTO districtToDistrictDTO(District district) {
        return new DistrictDTO(district.getDistrictName(), district.getDistrictPrice());
    }
}
