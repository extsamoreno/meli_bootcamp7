package com.example.demo.Utils;

import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.DTO.ResponsePriceDTO;
import com.example.demo.Mapper;
import com.example.demo.entities.District;
import com.example.demo.entities.Environment;
import com.example.demo.entities.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.IDistrictRepository;
import com.example.demo.repositories.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {


    public static PropertyDTO getPropertyDTOWithEnvironments() {

        EnvironmentDTO room1 = new EnvironmentDTO("Bathroom", 3.0, 3.0, 9);
        EnvironmentDTO room2 = new EnvironmentDTO("Room", 4.0, 4.0, 16);

        List<EnvironmentDTO> environmentDTOS = new ArrayList<>();
        environmentDTOS.add(room1);
        environmentDTOS.add(room2);

        PropertyDTO property = new PropertyDTO(1, "home", "Barrio 1", environmentDTOS);
        return property;
    }

    public static ResponsePriceDTO getResponsePriceDTO(int id) {
        ResponsePriceDTO property = new ResponsePriceDTO();
        property.setPropertyId(id);
        property.setPropertyName("The big place");
        property.setPrice(40.0);

        return property;
    }

    public static Property getPropertyWithEnvironments() {

        Environment room1 = new Environment("Bathroom", 3.0, 3.0);
        Environment room2 = new Environment("Room", 4.0, 4.0);

        List<Environment> environments = new ArrayList<>();
        environments.add(room1);
        environments.add(room2);

        District district = new District("Barrio 1", 7.0);
        Property property = new Property(1, "home", district, environments);
        return property;
    }

    public static List<EnvironmentDTO> toEnvironmentsDTO(List<Environment> list) {

        List<EnvironmentDTO> result = new ArrayList<>();
        for (Environment environment : list) {
            EnvironmentDTO environmentDTO = new EnvironmentDTO();
            environmentDTO.setName(environment.getName());
            environmentDTO.setLength(environment.getLength());
            environmentDTO.setWidth(environment.getWidth());
            environmentDTO.setTotalMeters(environment.getLength() * environment.getWidth());

            result.add(environmentDTO);
        }
        return result;
    }

    public static Property toProperty(PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setId(propertyDTO.getId());
        property.setName(propertyDTO.getName());
        property.setDistrict(new District("Barrio 1", 7.));
        property.setEnvironments(Mapper.toEnvironment(propertyDTO.getEnvironments()));

        return property;
    }

}
