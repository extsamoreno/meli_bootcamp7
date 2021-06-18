package com.example.challenge2.integration;

import com.example.challenge2.dtos.BiggerEnvironmentResponseDTO;
import com.example.challenge2.dtos.EnvironmentSizesDTO;
import com.example.challenge2.dtos.PriceResponseDTO;
import com.example.challenge2.dtos.SizeResponseDTO;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.models.Property;
import com.example.challenge2.serivces.IPropertyService;
import com.example.challenge2.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyServiceControllerIntegrationTest {

    @Autowired
    IPropertyService propertyService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();
    }


    @Test
    public void getTotalSizeWellCalculated() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        TestUtilGenerator.appendNewProperty(property);
        SizeResponseDTO responseDTO = new SizeResponseDTO(property.getName(), 57.25);
        //Act
        SizeResponseDTO response = propertyService.getSize(property.getName());

        //Assert
        Assertions.assertEquals(responseDTO, response);
    }


    @Test
    public void getPriceWellCalculated() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        District district = new District("Carrasco", 400.00);
        TestUtilGenerator.appendNewProperty(property);
        TestUtilGenerator.appendNewDistrict(district);
        PriceResponseDTO responseDTO = new PriceResponseDTO(property.getName(), 22900.0);

        //Act
        PriceResponseDTO response = propertyService.getPrice(property.getName());

        //Assert
        Assertions.assertEquals(responseDTO, response);
    }

    @Test
    public void getBiggerEnvironmentWellCalculated() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        TestUtilGenerator.appendNewProperty(property);
        Environment environment = new Environment("Cuarto2", 3.5, 9.5);
        BiggerEnvironmentResponseDTO responseDTO = new BiggerEnvironmentResponseDTO(property.getName(), environment);

        //Act
        BiggerEnvironmentResponseDTO response = propertyService.getBiggerEnvironment(property.getName());

        //Assert
        Assertions.assertEquals(responseDTO, response);
    }


    @Test
    public void getEnvironmentsWellDone() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        TestUtilGenerator.appendNewProperty(property);
        List<SizeResponseDTO> environments = new ArrayList<>();
        environments.add(new SizeResponseDTO("Cuarto1", 24.0));
        environments.add(new SizeResponseDTO("Cuarto2", 33.25));
        EnvironmentSizesDTO resposeDTO = new EnvironmentSizesDTO(property.getName(), environments);

        //Act
        EnvironmentSizesDTO response = propertyService.getEnvironments(property.getName());

        //Assert
        Assertions.assertEquals(resposeDTO, response);
    }

    @Test
    public void createPropertyCorrectly() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        property.setName("Nuevo");
        District district = new District("Carrasco", 400.0);
        TestUtilGenerator.appendNewProperty(property);
        TestUtilGenerator.appendNewDistrict(district);

        //Act
        Property res = propertyService.create(property);

        //Assert
        Assertions.assertEquals(property, res);
    }


}
