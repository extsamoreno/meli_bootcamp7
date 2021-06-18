package com.example.challenge2.unit;

import com.example.challenge2.dtos.*;
import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.models.Environment;
import com.example.challenge2.models.Property;
import com.example.challenge2.repositories.IDistrictDAO;
import com.example.challenge2.repositories.IPropertyDAO;
import com.example.challenge2.serivces.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyDAO propertyDAO;

    @InjectMocks
    PropertyService propertyService;

    @Mock
    IDistrictDAO districtDAO;



    @Test
    public void getTotalSizeWellCalculated() {
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,1.8);
        List<Environment> environments = new ArrayList<>();
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName("Carrasco");
        property.setEnvironmentList(environments);
        Mockito.when(propertyDAO.findByName(property.getName())).thenReturn(property);

        //Act
        SizeResponseDTO response = propertyService.getSize(property.getName());

        //Assert
        Mockito.verify(propertyDAO,Mockito.atLeastOnce()).findByName(property.getName());
        Assertions.assertEquals(66.6,response.getSize());
    }

    @Test
    public void getPriceWellCalculated() {
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,2.0);
        List<Environment> environments = new ArrayList<>();
        District district = new District("Carrasco", 800.00);
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName("Carrasco");
        property.setEnvironmentList(environments);
        Mockito.when(districtDAO.findByName(property.getDistrictName())).thenReturn(district);
        Mockito.when(propertyDAO.findByName(property.getName())).thenReturn(property);

        //Act
        PriceResponseDTO response = propertyService.getPrice(property.getName());

        //Assert
        Mockito.verify(propertyDAO,Mockito.atLeastOnce()).findByName(property.getName());
        Assertions.assertEquals(54400.00,response.getPrice());
    }

    @Test
    public void getBiggerEnvironmentWellCalculated() {
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,2.0);
        List<Environment> environments = new ArrayList<>();
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName("Carrasco");
        property.setEnvironmentList(environments);
        Mockito.when(propertyDAO.findByName(property.getName())).thenReturn(property);

        //Act
        BiggerEnvironmentResponseDTO response = propertyService.getBiggerEnvironment(property.getName());

        //Assert
        Mockito.verify(propertyDAO,Mockito.atLeastOnce()).findByName(property.getName());
        Assertions.assertEquals(cuarto1,response.getBiggerEnvironment());
    }


    @Test
    public void getEnvironmentsWellDone() {
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,2.0);
        List<Environment> environments = new ArrayList<>();
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName("Carrasco");
        property.setEnvironmentList(environments);
        Mockito.when(propertyDAO.findByName(property.getName())).thenReturn(property);
        EnvironmentSizesDTO res = new EnvironmentSizesDTO(property.getName(), new ArrayList<>());
        res.getEnvironments().add(new SizeResponseDTO("Cuarto1", 54.00));
        res.getEnvironments().add(new SizeResponseDTO("Cuarto2", 14.00));


        //Act
        EnvironmentSizesDTO response = propertyService.getEnvironments(property.getName());

        //Assert
        Mockito.verify(propertyDAO,Mockito.atLeastOnce()).findByName(property.getName());
        Assertions.assertEquals(res.getEnvironments(),response.getEnvironments());
    }

    @Test
    public void createPropertyCorrectly(){
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,2.0);
        List<Environment> environments = new ArrayList<>();
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName(district.getName());
        property.setEnvironmentList(environments);
        Mockito.when(districtDAO.exist(district.getName())).thenReturn(true);
        Mockito.when(propertyService.create(property)).thenReturn(property);

        //Act
        Property res = propertyService.create(property);

        //Assert
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).exist(district.getName());
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).save(property);
        Assertions.assertEquals(property,res);
    }

    @Test
    public void createPropertyWithNonExistingDistrict() {
        //Arrange
        Property property = new Property();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,2.0);
        List<Environment> environments = new ArrayList<>();
        environments.add(cuarto1);
        environments.add(cuarto2);
        property.setName("Propiedad1");
        property.setDistrictName("Districto1");
        property.setEnvironmentList(environments);

        //Act & Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.create(property));
    }






}
