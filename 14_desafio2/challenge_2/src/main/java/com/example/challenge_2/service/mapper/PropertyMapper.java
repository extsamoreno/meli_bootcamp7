package com.example.challenge_2.service.mapper;

import com.example.challenge_2.models.Property;
import com.example.challenge_2.service.dto.PropertyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PropertyMapper {

    public static PropertyDTO toDTO(Property property) {
        return new ModelMapper().map(property, PropertyDTO.class);
    }

    public static Property toModel(PropertyDTO property) {
        return new ModelMapper().map(property, Property.class);
    }
}
