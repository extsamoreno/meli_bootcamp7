package com.example.challenge2.unit;

import com.example.challenge2.exceptions.PropertyNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.models.Property;
import com.example.challenge2.repositories.IPropertyDAO;
import com.example.challenge2.repositories.PropertyDAO;
import com.example.challenge2.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyDAOTest {

    IPropertyDAO propertyDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.propertyDAO = new PropertyDAO();
        TestUtilGenerator.emptyFiles();
    }

    @Test
    public void savePropertyOk() {
        // arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1", 4.0, 5.0);
        Environment cuarto2 = new Environment("Cuarto2", 6.0, 5.0);
        List<Environment> environments = new ArrayList<>();
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName(district.getName());
        property.setEnvironmentList(environments);

        // act
        Property received = propertyDAO.save(property);

        // assert
        Assertions.assertEquals(received, property);
    }


    @Test
    public void findExistentPropertyById() {
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1", 4.0, 5.0);
        Environment cuarto2 = new Environment("Cuarto2", 6.0, 5.0);
        List<Environment> environments = new ArrayList<>();
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName(district.getName());
        property.setEnvironmentList(environments);
        propertyDAO.save(property);

        //Act
        Property found = propertyDAO.findByName(property.getName());

        //Assert
        Assertions.assertEquals(found, property);
    }

    @Test
    public void findNonExistentPropertyById() {
        //Arrange
        String name = "Error";

        //Assert
        Assertions.assertThrows(PropertyNotFoundException.class, () -> propertyDAO.findByName(name));
    }

}
