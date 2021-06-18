package com.example.tucasita.unit.repository;

import com.example.tucasita.exception.ExistentPropertyException;
import com.example.tucasita.exception.PropertyNotFoundException;
import com.example.tucasita.model.EnvironmentDTO;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.repository.PropertyDAO;
import com.example.tucasita.repository.PropertyDAOImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PropertyDAOTests {

    PropertyDAO propertyDAO;

    @BeforeEach
    public void init() {
        propertyDAO = new PropertyDAOImple();
    }

    @Test
    public void testCreateNewProperty() {
        //ARRANGE
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        //ACT
        propertyDAO.create(newProperty);
        PropertyDTO createdProperty = propertyDAO.findById(newProperty.getPropId());

        //ASSERT
        Assertions.assertEquals(newProperty, createdProperty);
    }

    @Test
    public void testCreateExistentProperty() {
        //ARRANGE
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 5.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Cocina", 5.00, 5.00, null));
        PropertyDTO existentProperty = new PropertyDTO(1, "Torre Pedro Goyena", "Caballito", propertyEnvironments);

        //ACT

        //ASSERT
        Assertions.assertThrows(ExistentPropertyException.class, () -> propertyDAO.create(existentProperty));
    }

    @Test
    public void testFindByIdExistentProperty() {
        //ARRANGE
        int propertyId = 1;
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Cocina", 5.00, 5.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 5.00, null));
        PropertyDTO expectedProperty = new PropertyDTO(1, "Torre Pedro Goyena", "Caballito", propertyEnvironments);

        //ACT
        PropertyDTO receivedProperty = propertyDAO.findById(propertyId);

        //ASSERT
        Assertions.assertEquals(expectedProperty, receivedProperty);
    }

    @Test
    public void testFindByIdInexistentProperty() {
        //ARRANGE
        int propertyId = 10;

        //ACT

        //ASSERT
        Assertions.assertThrows(PropertyNotFoundException.class, () -> propertyDAO.findById(propertyId));
    }
}
