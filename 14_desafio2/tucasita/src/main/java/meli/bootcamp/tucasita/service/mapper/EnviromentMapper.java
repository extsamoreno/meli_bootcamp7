package meli.bootcamp.tucasita.service.mapper;


import meli.bootcamp.tucasita.model.Environment;
import meli.bootcamp.tucasita.service.dto.EnvironmentDTO;

import java.text.DecimalFormat;

public class EnviromentMapper {

    public static EnvironmentDTO toDTO(Environment environment){
        return new EnvironmentDTO(environment.getEnvironment_name(), environment.getEnvironment_width(), environment.getEnvironment_length(),
                new DecimalFormat("#.00").format((environment.getEnvironment_length())* environment.getEnvironment_width()));
    }

    public static EnvironmentDTO toDTOSquareMetersNull(Environment environment){
        return new EnvironmentDTO(environment.getEnvironment_name(), environment.getEnvironment_width(), environment.getEnvironment_length(),
                null);
    }

}
