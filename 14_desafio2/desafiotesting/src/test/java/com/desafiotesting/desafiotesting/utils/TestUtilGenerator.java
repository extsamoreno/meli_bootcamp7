package com.desafiotesting.desafiotesting.utils;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.models.Enviroment;
import com.desafiotesting.desafiotesting.models.Property;
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

    public static District getDistrict(String option){
        return option.equals("district1") ?
                new District("District1",225.5) :
                new District("District2",235.5);
    }

    public static List<Enviroment> getEnviroments(){
        Enviroment enviroment1 = new Enviroment("Cocina",32.5,34.5); //1121.25
        Enviroment enviroment2 = new Enviroment("Comedor",21.5,34.5); //741.75
        Enviroment enviroment3 = new Enviroment("Baño",12.5,34.5); // 431.25
        return List.of(enviroment1,enviroment2,enviroment3);
    }
}
