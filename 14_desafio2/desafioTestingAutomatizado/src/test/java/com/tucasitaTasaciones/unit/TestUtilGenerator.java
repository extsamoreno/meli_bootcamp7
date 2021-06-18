package com.tucasitaTasaciones.unit;

import com.tucasitaTasaciones.dto.EnvironmentDTO;
import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.model.District;
import com.tucasitaTasaciones.model.Environment;
import com.tucasitaTasaciones.model.Property;

import java.util.ArrayList;
import java.util.List;

public class TestUtilGenerator {


    public static PropertyDTO getPropertyDTO(String districtName) {
        EnvironmentDTO e1 = new EnvironmentDTO("Living", 2, 3);
        EnvironmentDTO e2 = new EnvironmentDTO("Kitchen", 1, 2);

        List<EnvironmentDTO> environments = new ArrayList<>();
        environments.add(e1);
        environments.add(e2);

        PropertyDTO property = new PropertyDTO();
        property.setProp_name("MyHome");
        property.setDistrict_name(districtName);
        property.setEnvironmentList(environments);
        return property;
    }

    public static Property getProperty() {
        Environment e1 = new Environment("Living", 2, 3);
        Environment e2 = new Environment("Kitchen", 1, 2);

        List<Environment> environments = new ArrayList<>();
        environments.add(e1);
        environments.add(e2);

        Property property = new Property();
        property.setProp_name("MyHome");
        property.setDistrict(new District("Snohomish", 2300.0));
        property.setEnvironmentList(environments);
        return property;
    }

    public static List<Property> getProperties() {
        Property p1 = getProperty();
        Property p2 = getProperty();

        List<Property> properties = new ArrayList<>();
        properties.add(p1);
        properties.add(p2);

        return properties;
    }


}
