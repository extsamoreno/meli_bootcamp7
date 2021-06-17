package com.meli.tucasitatasaciones.unit.repository;

import com.meli.tucasitatasaciones.exception.PropertyNotFoundException;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import com.meli.tucasitatasaciones.repository.property.PropertyRepository;
import com.meli.tucasitatasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PropertyRepositoryTest {
    IPropertyRepository iPropertyRepository;

    @BeforeEach @AfterEach
    private void setUp() { this.iPropertyRepository = new PropertyRepository(); }

    @Test
    public void saveNewProperty() {
        //Arrange
        Property property = TestUtilGenerator.getNewProperty();

        //Act
        iPropertyRepository.saveProperty(property);

        //Assert
        Assertions.assertEquals(1,property.getId());
        Assertions.assertEquals(iPropertyRepository.findPropertyById(property.getId()),property);
    }

    @Test
    public void findExistentPropertyById() {
        //Arrange
        Property property = TestUtilGenerator.getNewProperty();
        iPropertyRepository.saveProperty(property);

        //Act
        Property found = iPropertyRepository.findPropertyById(property.getId());

        //Assert
        Assertions.assertEquals(found,property);
    }

    @Test
    public void findNonExistentPropertyById() {
        //Arrange
        Integer propertyId = 1;

        //Act & Assert
        Assertions.assertThrows(PropertyNotFoundException.class, () -> iPropertyRepository.findPropertyById(propertyId));
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<Property> properties = TestUtilGenerator.getProperties();
        properties.forEach((prop) -> iPropertyRepository.saveProperty(prop));

        //Act
        List<Property> foundList = iPropertyRepository.getAllProperties();

        //Assert
        Assertions.assertEquals(properties,foundList);
    }
}