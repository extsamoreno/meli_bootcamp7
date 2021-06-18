package com.tucasitatasaciones.demo.unit;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.tucasitatasaciones.demo.models.Property;
import com.tucasitatasaciones.demo.repository.IPropertyRepository;
import com.tucasitatasaciones.demo.repository.PropertyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PropertyRepositoryTest {

    private IPropertyRepository propertyRepository;
    private Property property;

    @BeforeEach @AfterEach
    public void setUp(){
        property = Utils.getProperty();
        propertyRepository = new PropertyRepository();
    }

    @Test
    public void testAddProperty(){
        //Arrange
        Property propertyExpected = property;
        //Act
        Property propertyReceived = propertyRepository.addProperty(property);

        //Assert
        assertEquals(propertyExpected, propertyReceived);
    }

    @Test
    public void testFindById(){
        //Arrange
        int propertyId = 1;
        Property propertyExpected = property;
        //Act
        Property propertyReceived = propertyRepository.findPropertyById(propertyId);

        //Assert
        assertEquals(propertyExpected, propertyReceived);
    }

    @Test
    public void testFindByName(){
        //Arrange
        String name = "Las fincas";

        //Act
        Property propertyReceived = propertyRepository.findPropertyByName(name);

        //Assert
        assertEquals(property, propertyReceived);
    }

    @Test
    public void testFindByNameWithNotExistProperty(){
        //Arrange
        String name = "No existe";

        //Act
        Property propertyReceived = propertyRepository.findPropertyByName(name);

        //Assert
        assertNull(propertyReceived);
    }

    @Test
    public void testFindByIdWithNotExistProperty(){
        //Arrange
        int propertyId = 150000;

        //Act
        Property propertyReceived = propertyRepository.findPropertyById(propertyId);

        //Assert
        assertNull(propertyReceived);
    }
}
