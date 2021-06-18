package com.desafiotesting.desafiotesting.utils;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.models.Enviroment;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;

import java.util.List;

public class TestUtilGenerator {

    public static Property getProperty(String district) {
        Property property = new Property(
                1,
                "Property1",
                getDistrict(district),
                getEnviroments()
        );
        return property;
    }

    public static PropertyDTO getPropertyDTO(String district) {
        PropertyDTO property = new PropertyDTO(
                1,
                "Property1",
                district,
                getEnviromentsDTO()
        );
        return property;
    }

    public static District getDistrict(String option){
        return option.equals("district1") ?
                new District("District1",225.5) :
                new District("District2",235.5);
    }

    public static EnviromentDTO getEnviromentDTO(){
        return new EnviromentDTO(
                "Cocina",32.5,34.5
        );
    }

    public static List<Enviroment> getEnviroments(){
        Enviroment enviroment1 = new Enviroment("Cocina",32.5,34.5);
        Enviroment enviroment2 = new Enviroment("Comedor",21.5,34.5);
        Enviroment enviroment3 = new Enviroment("Baño",12.5,34.5);
        return List.of(enviroment1,enviroment2,enviroment3);
    }

    public static List<EnviromentDTO> getEnviromentsDTO(){
        EnviromentDTO enviroment1 = new EnviromentDTO("Cocina",32.5,34.5);
        EnviromentDTO enviroment2 = new EnviromentDTO("Comedor",21.5,34.5);
        EnviromentDTO enviroment3 = new EnviromentDTO("Baño",12.5,34.5);
        return List.of(enviroment1,enviroment2,enviroment3);
    }

    public static List<EnviromentWithSquareMetersDTO> getEnviromentsWithSquareMetersDTO(){
        EnviromentWithSquareMetersDTO enviroment1 = new EnviromentWithSquareMetersDTO("Cocina",22.3,33,735.9);
        EnviromentWithSquareMetersDTO enviroment2 = new EnviromentWithSquareMetersDTO("Comedor",21.5,33,709.5);
        EnviromentWithSquareMetersDTO enviroment3 = new EnviromentWithSquareMetersDTO("Baño",12.5,34.5,431.25);
        return List.of(enviroment1,enviroment2,enviroment3);
    }
}
