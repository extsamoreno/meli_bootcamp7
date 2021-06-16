package com.meli.desafio2.mappers;

import com.meli.desafio2.dto.PropertyDTO;
import com.meli.desafio2.model.Property;
import org.modelmapper.ModelMapper;

public class PropertyMapper {

    private ModelMapper mapper;

    public PropertyMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    // PropertyDTO to Property
    private Property propToDTO(PropertyDTO propDTO){
        return mapper.map(propDTO, Property.class);
    }

    // Property to PropertyDTO
    private PropertyDTO propToDTO(Property prop){
        return mapper.map(prop, PropertyDTO.class);
    }

}
