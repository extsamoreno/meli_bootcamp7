package com.example.demo.Utils;

import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.DTO.ResponsePriceDTO;
import com.example.demo.entities.District;
import com.example.demo.entities.Environment;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static PropertyDTO getPropertyDTOWithEnvironments() {

        EnvironmentDTO room1 = new EnvironmentDTO("Bathroom", 3.0,3.0, 9);
        EnvironmentDTO room2 = new EnvironmentDTO("Room", 4.0,4.0, 16);

        List<EnvironmentDTO> environmentDTOS = new ArrayList<>();
        environmentDTOS.add(room1);
        environmentDTOS.add(room2);

        PropertyDTO property = new PropertyDTO(1,"home", "Manhatta", environmentDTOS);
        return property;
    }

    public static ResponsePriceDTO getResponsePriceDTO(int id) {
        ResponsePriceDTO property = new ResponsePriceDTO();
        property.setPropertyId(id);
        property.setPropertyName("The big place");
        property.setPrice(40.0);

        return property;
    }
}
