package meli.bootcamp.tucasita.service.mapper;

import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.service.dto.DistrictDTO;

public class DistrictDTOMapper {

    public static DistrictDTO toDTO(District district){
        return new DistrictDTO(district.getDistrict_name(), district.getDistrict_price());
    }

    public static District toDistrict(DistrictDTO districtDTO){
        return new District(districtDTO.getDistrict_name(),districtDTO.getDistrict_price());
    }
}
