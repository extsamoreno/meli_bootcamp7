package com.example.demo.service.mapper;


import com.example.demo.models.House;
import com.example.demo.service.dto.HouseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IHouseMapper {
    @Mappings({
            @Mapping(target = "prop_name", source = "prop_name"),
            @Mapping(target = "distric_name", source = "distric_name"),
            @Mapping(target = "environmentArrayList", source = "environmentArrayList")
    })
    House houseDTOToHouse(HouseDTO houseDTO);
    @Mappings({
            @Mapping(target = "prop_name", source = "prop_name"),
            @Mapping(target = "distric_name", source = "distric_name"),
            @Mapping(target = "environmentArrayList", source = "environmentArrayList")
    })
    HouseDTO houseToHouseDTO(House house);
}
