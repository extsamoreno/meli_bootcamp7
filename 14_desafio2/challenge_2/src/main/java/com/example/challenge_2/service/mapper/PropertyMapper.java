package com.example.challenge_2.service.mapper;

import com.example.challenge_2.models.Property;
import com.example.challenge_2.service.dto.PropertyDTO;
import org.springframework.stereotype.Service;

@Service
public class PropertyMapper extends Mapper{

    public PropertyDTO toDTO(Property property) {
        return this.getModelMapper().map(property, PropertyDTO.class);
    }

    public Property toModel(PropertyDTO property) {
        return this.getModelMapper().map(property, Property.class);
    }
}
