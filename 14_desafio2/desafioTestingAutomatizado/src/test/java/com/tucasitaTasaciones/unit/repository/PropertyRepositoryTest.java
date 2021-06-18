package com.tucasitaTasaciones.unit.repository;

import com.tucasitaTasaciones.exceptions.PropertyNotFoundException;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import com.tucasitaTasaciones.repository.PropertyRepository;
import com.tucasitaTasaciones.unit.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PropertyRepositoryTest {

    IPropertyRepository repository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        repository = new PropertyRepository();
    }

    @Test
    public void addNewProperty() {
        Property property = TestUtilGenerator.getProperty();

        repository.addNewProperty(property);

        Assertions.assertEquals(1, property.getPropId());
        Assertions.assertEquals(repository.findProperty(property.getPropId()), property);

    }

    @Test
    public void findExistentProperty() {
        Property property = TestUtilGenerator.getProperty();
        repository.addNewProperty(property);

        Property found = repository.findProperty(property.getPropId());

        Assertions.assertEquals(found, property);

    }

    @Test
    public void findNonExistentProperty() {
        Integer id = 5;

        Assertions.assertThrows(PropertyNotFoundException.class,
                () -> repository.findProperty(id));

    }

    @Test
    public void getProperties() {
        List<Property> propertyList = TestUtilGenerator.getProperties();
        for (Property p : propertyList) {
            repository.addNewProperty(p);
        }

        List<Property> found = repository.getProperties();

        Assertions.assertEquals(found, propertyList);
    }


}

/*void addNewProperty(Property property);

    Property findProperty(Integer id);

    List<Property> getProperties();*/