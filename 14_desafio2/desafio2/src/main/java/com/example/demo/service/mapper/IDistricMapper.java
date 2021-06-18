package com.example.demo.service.mapper;

import com.example.demo.models.District;
import com.example.demo.service.dto.DistrictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IDistricMapper {
    @Mappings({
            @Mapping(target = "distric_name", source = "distric_name"),
            @Mapping(target = "distric_price", source = "distric_price")
    })
    District districtDTOToDistrict(DistrictDTO districtDTO);
    @Mappings({
            @Mapping(target = "distric_name", source = "distric_name"),
            @Mapping(target = "distric_price", source = "distric_price")
    })
    DistrictDTO districtToDistrictDTO(District district);
}
