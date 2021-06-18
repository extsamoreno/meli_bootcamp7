package com.tucasitaTasaciones.unit.repository;

import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import com.tucasitaTasaciones.repository.PropertyRepository;
import com.tucasitaTasaciones.unit.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyRepositoryTest {

    IPropertyRepository repository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        repository = new PropertyRepository();
    }

    @Test
    public void addNewPropertyTest() {
        Property property = TestUtilGenerator.getProperty();
        repository.addNewProperty(property);

        assertEquals(1, property.getPropId());
        assertEquals(repository.findProperty(property.getPropId()), property);

    }

    @Test
    public void findExistentPropertyTest() {
        Property property = TestUtilGenerator.getProperty();
        repository.addNewProperty(property);

        Property found = repository.findProperty(property.getPropId());

        assertEquals(found, property);

    }

    @Test
    public void findNonExistentPropertyTest() {
        Property property = repository.findProperty(1);
        Assertions.assertNull(property);
    }


    @Test
    public void getPropertiesTest() {
        List<Property> propertyList = TestUtilGenerator.getProperties();
        for (Property p : propertyList) {
            repository.addNewProperty(p);
        }

        List<Property> found = repository.getProperties();

        assertEquals(found, propertyList);
    }


}
