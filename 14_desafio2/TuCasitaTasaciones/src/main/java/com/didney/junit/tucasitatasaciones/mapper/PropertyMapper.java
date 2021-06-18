package com.didney.junit.tucasitatasaciones.mapper;

import com.didney.junit.tucasitatasaciones.dto.PropertyDTO;
import com.didney.junit.tucasitatasaciones.model.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PropertyMapper {
    public Property propertyDTOToProperty(PropertyDTO propertyDTO) {
        EnvironmentMapper environmentMapper = new EnvironmentMapper();
        DistrictMapper districtMapper = new DistrictMapper();
        return new Property(0, propertyDTO.getPropName(), districtMapper.districtDTOToDistrict(propertyDTO.getDistrict()), environmentMapper.environmentDTOToListEnvironment(propertyDTO.getEnvironments()));
    }

    public PropertyDTO propertyToPropertyDTO(Property property) {
        EnvironmentMapper environmentMapper = new EnvironmentMapper();
        DistrictMapper districtMapper = new DistrictMapper();
        return new PropertyDTO(property.getPropName(), districtMapper.districtToDistrictDTO(property.getDistrict()), environmentMapper.environmentToListEnvironmentDTO(property.getEnvironments()));
    }


    public List<Property> propertyDTOToProperty(List<PropertyDTO> propertyDTOList) {
        List<Property> response = new ArrayList<>();
        for (PropertyDTO obj : propertyDTOList) {
            response.add(propertyDTOToProperty(obj));
        }
        return response;
    }

    public List<PropertyDTO> propertyToPropertyDTO(List<Property> properties) {
        List<PropertyDTO> response = new ArrayList<>();
        for (Property obj : properties) {
            response.add(propertyToPropertyDTO(obj));
        }
        return response;
    }
}
