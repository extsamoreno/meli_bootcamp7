package com.tucasita.tasaciones.TestUtils;

import com.tucasita.tasaciones.project.models.Environment;
import com.tucasita.tasaciones.project.models.Property;
import com.tucasita.tasaciones.project.services.Dto.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class TestUtils {
    public static Property getNewProperty(String propertyName){
        Environment environment1 = new Environment("Banio",10,5); //50 m2
        Environment environment2 = new Environment("Cocina",15,10);// 150 m2
        Environment environment3 = new Environment("Living",20,5);// 100 m2

        ArrayList<Environment> environmentArrayList = new ArrayList<>();
        environmentArrayList.add(environment1);
        environmentArrayList.add(environment2);
        environmentArrayList.add(environment3);

        return new Property(propertyName,"Villa Herrero",environmentArrayList);
    }

    public static PropertyDto getNewPropertyDto(String propertyName){
        Environment environment1 = new Environment("Banio",10,5); //50 m2
        Environment environment2 = new Environment("Cocina",15,10);// 150 m2
        Environment environment3 = new Environment("Living",20,5);// 100 m2

        ArrayList<Environment> environmentArrayList = new ArrayList<>();
        environmentArrayList.add(environment1);
        environmentArrayList.add(environment2);
        environmentArrayList.add(environment3);

        return new PropertyDto(propertyName,"Villa Herrero",environmentArrayList);
    }
}
