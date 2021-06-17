package com.example.desafio2.project.services.mapper;

import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.services.Dto.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class mapper {

    public static PropertyDto propertyToDto (Property property){
        return new PropertyDto(property.getProp_name(), property.getProp_district_name(), property.getProp_environment());
    }

    public static Property propertyDtoToProperty(PropertyDto propertyDto){
        return new Property(propertyDto.getProp_name(),propertyDto.getProp_district_name(),propertyDto.getProp_environment());
    }

}
