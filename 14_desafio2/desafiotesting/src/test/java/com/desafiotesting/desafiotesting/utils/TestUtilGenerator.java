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
        return option.equals("District1") ?
                new District("District1",225.5) :
                new District("District2",235.5);
    }

    public static EnviromentDTO getEnviromentDTO(){
        return new EnviromentDTO(
                "Cocina",22.5,31.5
        );
    }

    public static List<Enviroment> getEnviroments(){
        Enviroment enviroment1 = new Enviroment("Cocina",22,33);
        Enviroment enviroment2 = new Enviroment("Comedor",21.5,32);
        Enviroment enviroment3 = new Enviroment("Baño",12.5,33);
        return List.of(enviroment1,enviroment2,enviroment3);
    }

    public static List<EnviromentDTO> getEnviromentsDTO(){
        EnviromentDTO enviroment1 = new EnviromentDTO("Cocina",20.1,33.0);
        EnviromentDTO enviroment2 = new EnviromentDTO("Comedor",21.5,32.5);
        EnviromentDTO enviroment3 = new EnviromentDTO("Baño",12.5,24.5);
        return List.of(enviroment1,enviroment2,enviroment3);
    }

    public static List<EnviromentWithSquareMetersDTO> getEnviromentsWithSquareMetersDTO(){
        EnviromentWithSquareMetersDTO enviroment1 = new EnviromentWithSquareMetersDTO("Cocina",22,33,726);
        EnviromentWithSquareMetersDTO enviroment2 = new EnviromentWithSquareMetersDTO("Comedor",21.5,32,688);
        EnviromentWithSquareMetersDTO enviroment3 = new EnviromentWithSquareMetersDTO("Baño",12.5,33,412.5);
        return List.of(enviroment1,enviroment2,enviroment3);
    }
}
