package com.example.tucasita.unit.repository;

import com.example.tucasita.exception.ExistentPropertyException;
import com.example.tucasita.exception.PropertyNotFoundException;
import com.example.tucasita.model.Environment;
import com.example.tucasita.model.Property;
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
        List<Environment> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new Environment("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new Environment("Comedor", 15.00, 20.00, null));
        Property newProperty = new Property(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        //ACT
        propertyDAO.create(newProperty);
        Property createdProperty = propertyDAO.findById(newProperty.getPropId());

        //ASSERT
        Assertions.assertEquals(newProperty, createdProperty);
    }

    @Test
    public void testCreateExistentProperty() {
        //ARRANGE
        List<Environment> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new Environment("Living", 10.00, 5.00, null));
        propertyEnvironments.add(new Environment("Cocina", 5.00, 5.00, null));
        Property existentProperty = new Property(1, "Torre Pedro Goyena", "Caballito", propertyEnvironments);

        //ACT

        //ASSERT
        Assertions.assertThrows(ExistentPropertyException.class, () -> propertyDAO.create(existentProperty));
    }

    @Test
    public void testFindByIdExistentProperty() {
        //ARRANGE
        int propertyId = 1;
        List<Environment> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new Environment("Cocina", 5.00, 5.00, null));
        propertyEnvironments.add(new Environment("Living", 10.00, 5.00, null));
        Property expectedProperty = new Property(1, "Torre Pedro Goyena", "Caballito", propertyEnvironments);

        //ACT
        Property receivedProperty = propertyDAO.findById(propertyId);

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
