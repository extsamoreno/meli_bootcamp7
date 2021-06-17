package meli.bootcamp.tucasita.service.mapper;

import meli.bootcamp.tucasita.model.Property;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;

public class PropertyDTOMapper {

    public static PropertyDTO toDTO(Property property){
        return new PropertyDTO(property.getProp_name(), DistrictDTOMapper.toDTO(property.getDistrict()), property.getEnvironments());
    }

    public static Property toProperty(PropertyDTO propertyDTO){
        return new Property(propertyDTO.getProp_name(),DistrictDTOMapper.toDistrict(propertyDTO.getDistrict()),propertyDTO.getEnvironments());
    }
}
