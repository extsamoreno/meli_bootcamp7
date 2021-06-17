package com.example.desafio2.unit.repository;

import com.example.desafio2.TestUtils.TestUtils;
import com.example.desafio2.project.exceptions.PropertyAlreadyExistsException;
import com.example.desafio2.project.exceptions.PropertyDistrictNameNotFoundException;
import com.example.desafio2.project.models.Property;
import com.example.desafio2.project.repository.PropertyRepository;
import com.example.desafio2.project.services.Dto.PropertyDto;
import com.example.desafio2.project.services.mapper.mapper;
import com.example.desafio2.project.utils.Database;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

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
    public void verifyDistrictNotFoundTest(){
        //Arrange
        Property property = TestUtils.getNewProperty("Casa4");
        property.setProp_district_name("invalid district test name");

        //Asserts
        Assertions.assertThrows(PropertyDistrictNameNotFoundException.class, () -> propertyRepository.saveProperty(property));

    }

    @Test
    public void verifyDistrictHappyPathTest() {
        //Arrange
        Property property = TestUtils.getNewProperty("Casa4");
        property.setProp_district_name("Villa Herrero");

        //Asserts
        Assertions.assertDoesNotThrow(() -> propertyRepository.saveProperty(property));
    }


}