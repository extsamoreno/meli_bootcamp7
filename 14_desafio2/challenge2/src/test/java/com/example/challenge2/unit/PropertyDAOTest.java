package com.example.challenge2.unit;

import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.exceptions.PropertyNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.repositories.IPropertyDAO;
import com.example.challenge2.repositories.PropertyDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PropertyDAOTest {

    IPropertyDAO propertyDAO;

    @BeforeEach
    @AfterEach
    private void setUp() { this.propertyDAO = new PropertyDAO(); }

    @Test
    public void savePropertyOk() {
        // arrange
        PropertyDTO propertyDTO = new PropertyDTO();
        Environment cuarto1 = new Environment("Cuarto1",4.0,5.0);
        Environment cuarto2 = new Environment("Cuarto2",6.0,5.0);
        List<Environment> environments = new ArrayList<>();
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        environments.add(cuarto1);
        environments.add(cuarto2);
        propertyDTO.setName("Propiedad1");
        propertyDTO.setDistrictName(district.getName());
        propertyDTO.setEnvironmentList(environments);
        // act
        PropertyDTO received = propertyDAO.save(propertyDTO);

        // assert
        Assertions.assertEquals(propertyDAO.findByName(received.getName()), propertyDTO);
    }


    @Test
    public void findExistentPropertyById() {
        //Arrange
        PropertyDTO propertyDTO = new PropertyDTO();
        Environment cuarto1 = new Environment("Cuarto1",4.0,5.0);
        Environment cuarto2 = new Environment("Cuarto2",6.0,5.0);
        List<Environment> environments = new ArrayList<>();
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        environments.add(cuarto1);
        environments.add(cuarto2);
        propertyDTO.setName("Propiedad1");
        propertyDTO.setDistrictName(district.getName());
        propertyDTO.setEnvironmentList(environments);
        propertyDAO.save(propertyDTO);

        //Act
        PropertyDTO found = propertyDAO.findByName(propertyDTO.getName());

        //Assert
        Assertions.assertEquals(found,propertyDTO);
    }

    @Test
    public void findNonExistentPropertyById() {
        //Arrange
        String name = "Error";

        //Assert
        Assertions.assertThrows(PropertyNotFoundException.class,() -> propertyDAO.findByName(name));
    }

}
