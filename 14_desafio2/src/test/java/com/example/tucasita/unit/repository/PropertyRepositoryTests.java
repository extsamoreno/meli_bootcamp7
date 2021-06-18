package com.example.tucasita.unit.repository;

import com.example.tucasita.model.EnvironmentDTO;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.PropertyRepository;
import com.example.tucasita.repository.PropertyRepositoryImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PropertyRepositoryTests {

    PropertyRepository propertyRepository;

    @BeforeEach
    public void init() {
        propertyRepository = new PropertyRepositoryImple();
    }

    @Test
    public void testFindAll() {
        //ARRANGE
        List<EnvironmentDTO> propertyEnvironments1 = new ArrayList<>();
        propertyEnvironments1.add(new EnvironmentDTO("Cocina", 5.00, 5.00, null));
        propertyEnvironments1.add(new EnvironmentDTO("Living", 10.00, 5.00, null));
        PropertyDTO expectedProperty1 = new PropertyDTO(1, "Torre Pedro Goyena", "Caballito", propertyEnvironments1);
        List<EnvironmentDTO> propertyEnvironments2 = new ArrayList<>();
        propertyEnvironments2.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments2.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO expectedProperty2 = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments2);
        ResponseDTO responseExpected = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");

        Set<PropertyDTO> expectedProperties = new HashSet<>();
        expectedProperties.add(expectedProperty1);
        expectedProperties.add(expectedProperty2);

        //ACT
        Set<PropertyDTO> receivedProperties = propertyRepository.findAll();

        //ASSERT
        Assertions.assertEquals(expectedProperties, receivedProperties);
    }
}
