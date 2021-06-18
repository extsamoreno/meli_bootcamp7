package com.meli.desafio2.unit;

import com.meli.desafio2.web.dto.request.DistrictDTO;
import com.meli.desafio2.web.dto.request.EnvironmentDTO;
import com.meli.desafio2.web.dto.request.PropertyDTO;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.response.BiggestEnvironmentResponse;
import com.meli.desafio2.web.response.PropertyValueResponse;
import com.meli.desafio2.web.response.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.response.SquareMetersResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static Property initValidProperty(){
        String prop_name = "Propiedad";
        String dist_name = "Distrito";
        String env_name = "Ambiente";
        String env_name2 = "Ambiente2";
        double env1_width = 2;
        double env1_length = 3;
        double env2_width = 3;
        double env2_length =4;
        List<Environment> environments = new ArrayList<>();
        environments.add(new Environment(env_name,env1_width,env1_length));
        environments.add(new Environment(env_name2,env2_width,env2_length));
        Property property = new Property(prop_name,dist_name,environments);
        return property;
    }
    public static PropertyDTO initValidPropertyDTO(){
        String prop_name = "Propiedad";
        String dist_name = "Distrito";
        String env_name = "Ambiente";
        String env_name2 = "Ambiente2";
        double env1_width = 2;
        double env1_length = 3;
        double env2_width = 3;
        double env2_length =4;
        List<EnvironmentDTO> environmentDTOs = new ArrayList<>();
        environmentDTOs.add(new EnvironmentDTO(env_name,env1_width,env1_length));
        environmentDTOs.add(new EnvironmentDTO(env_name2,env2_width,env2_length));
        PropertyDTO propertyDTO = new PropertyDTO(prop_name,dist_name,environmentDTOs);
        return propertyDTO;
    }

    public static Environment initValidEnvironment(){
        String env_name = "Ambiente";
        double env1_width = 2;
        double env1_length = 3;
        return new Environment(env_name,env1_width,env1_length);
    }
    public static EnvironmentDTO initValidEnvironmentDTO(){
        String env_name = "Ambiente";
        double env1_width = 2;
        double env1_length = 3;
        return new EnvironmentDTO(env_name,env1_width,env1_length);
    }

    public static DistrictDTO initValidDistrictDTO(){
        String dist_name = "Distrito";
        double dist_value = 200;
        return new DistrictDTO(dist_name,dist_value);
    }
    public static District initValidDistrict(){
        String dist_name = "Distrito";
        double dist_value = 200;
        return new District(dist_name,dist_value);
    }
    public static PropertyValueResponse getPropertyValue(){
        Property property = initValidProperty();
        return new PropertyValueResponse(property,3600);
    }

    public static SquareMetersResponse getSquareMetersResponse(){
        return new SquareMetersResponse(initValidProperty().getProp_name(),18);
    }
    public static BiggestEnvironmentResponse getBiggestEnvironment(){
        Property property = initValidProperty();
        return new BiggestEnvironmentResponse(property.getProp_name(),property.getEnvironments().get(1));
    }
    public static SquareMetersEnvironmentResponse getEnvironmentSquareMeters(){
        Property property = initValidProperty();
        HashMap<String,Double> environments = new HashMap<>();
        environments.put(property.getEnvironments().get(0).getEnvironment_name(),6d);
        environments.put(property.getEnvironments().get(1).getEnvironment_name(),12d);
        return new SquareMetersEnvironmentResponse(property.getProp_name(),environments);
    }

}
