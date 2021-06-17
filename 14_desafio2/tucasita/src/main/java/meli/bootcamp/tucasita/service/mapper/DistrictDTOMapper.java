package meli.bootcamp.tucasita.service.mapper;

import meli.bootcamp.tucasita.model.Distric;
import meli.bootcamp.tucasita.service.dto.DistrictDTO;

public class DistrictDTOMapper {

    public static DistrictDTO toDTO(Distric distric){
        return new DistrictDTO(distric.getDistrict_name(),distric.getDistrict_price());
    }

    public static Distric toDistrict(DistrictDTO districtDTO){
        return new Distric(districtDTO.getDistrict_name(),districtDTO.getDistrict_price());
    }
}
