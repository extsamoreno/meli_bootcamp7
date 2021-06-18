package com.didney.junit.tucasitatasaciones.mapper;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.model.District;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DistrictMapper {
    public District districtDTOToDistrict(DistrictDTO districtDTO) {
        return new District(0, districtDTO.getDistrictName(), districtDTO.getDistrictPrice());
    }

    public DistrictDTO districtToDistrictDTO(District district) {
        return new DistrictDTO(district.getDistrictName(), district.getDistrictPrice());
    }

    public List<DistrictDTO> listDistrictToDistrictDTO(List<District> districtList) {
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        for (District obj : districtList
        ) {
            districtDTOList.add(districtToDistrictDTO(obj));
        }
        return districtDTOList;
    }
}
