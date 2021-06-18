package com.tucasita.tasaciones.unit.repository;

import com.tucasita.tasaciones.TestUtils.TestUtils;
import com.tucasita.tasaciones.project.exceptions.PropertyAlreadyExistsException;
import com.tucasita.tasaciones.project.exceptions.PropertyDistrictNameNotFoundException;
import com.tucasita.tasaciones.project.exceptions.PropertyNameNotFoundException;
import com.tucasita.tasaciones.project.models.Property;
import com.tucasita.tasaciones.project.repository.PropertyRepository;
import com.tucasita.tasaciones.project.utils.Database;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryUnitTests {

    private PropertyRepository propertyRepository = new PropertyRepository();

    @BeforeEach
    public void loadDb() {
        Database db = new Database();
        db.loadPropertiesDataBase();
        db.loadDistrictsDataBase();
    }


    @Test
    public void verifyDistrictHappyPathTest() {
        //Arrange
        Property property = TestUtils.getNewProperty("Casa4");
        property.setProp_district_name("Villa Herrero");

        //Asserts
        Assertions.assertDoesNotThrow(() -> propertyRepository.saveProperty(property));
    }

    @Test
    public void verifyPropertyDistrictNotFoundExceptionTest(){
        //Arrange
        Property property = TestUtils.getNewProperty("Casa4");
        property.setProp_district_name("invalid district test name");

        //Asserts
        Assertions.assertThrows(PropertyDistrictNameNotFoundException.class, () -> propertyRepository.saveProperty(property));
        Assertions.assertThrows(PropertyDistrictNameNotFoundException.class, () -> propertyRepository.findDistrictByName(property.getProp_district_name()));

    }

    @Test
    public void verifyPropertyNameNotFoundExceptionTest(){
        //Arrange
        Property property = TestUtils.getNewProperty("test");

        //Asserts
        Assertions.assertThrows(PropertyNameNotFoundException.class, () -> propertyRepository.findPropertyByName(property.getProp_name()));

    }

    @Test
    public void verifyPropertyAlreadyExistsExceptionTest(){
        //Arrange
        Property property = TestUtils.getNewProperty("Casa1");

        //Asserts
        Assertions.assertThrows(PropertyAlreadyExistsException.class, () -> propertyRepository.saveProperty(property));
    }
}