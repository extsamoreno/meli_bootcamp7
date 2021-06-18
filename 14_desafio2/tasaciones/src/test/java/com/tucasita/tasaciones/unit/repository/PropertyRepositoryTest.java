package com.tucasita.tasaciones.unit.repository;

import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.repository.PropertyRepository;
import com.tucasita.tasaciones.repository.PropertyRepositoryImpl;
import com.tucasita.tasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyRepositoryTest {

    PropertyRepository propertyRepository;

    @BeforeEach @AfterEach
    private void init() throws IOException {
        TestUtilGenerator.emptyPropertiesFile();
        this.propertyRepository = new PropertyRepositoryImpl();
    }

    @Test
    public void findExistentProperty() throws IOException {

        Property prop = TestUtilGenerator.getPropertyWithTwoRooms();
        propertyRepository.saveProperty(prop);

        Property found = propertyRepository.getPropertyById(prop.getId());
        assertEquals(found, prop);
    }

    @Test
    public void findAll() throws IOException {
        List<Property> props = TestUtilGenerator.getListOfProperties();
        propertyRepository.saveProperty(props.get(0));
        propertyRepository.saveProperty(props.get(1));

        assertEquals(props, propertyRepository.getAllProperties());
    }
}
