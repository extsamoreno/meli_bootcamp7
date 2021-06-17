package com.meli.desafio2.unit;

import com.meli.desafio2.web.dto.DistrictDTO;
import com.meli.desafio2.web.dto.EnvironmentDTO;
import com.meli.desafio2.web.dto.PropertyDTO;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.model.Environment;
import com.meli.desafio2.web.model.Property;
import com.meli.desafio2.web.repository.IDistrictRepository;
import com.meli.desafio2.web.responses.BiggestEnvironmentResponse;
import com.meli.desafio2.web.responses.SquareMetersEnvironmentResponse;
import com.meli.desafio2.web.responses.SquareMetersResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
