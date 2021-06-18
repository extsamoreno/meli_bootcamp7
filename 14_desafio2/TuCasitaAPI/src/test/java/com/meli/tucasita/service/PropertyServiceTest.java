package com.meli.tucasita.service;

import com.meli.tucasita.exception.DistrictNotFoundException;
import com.meli.tucasita.exception.PropertyNotFoundException;
import com.meli.tucasita.model.District;
import com.meli.tucasita.model.Environment;
import com.meli.tucasita.model.Property;
import com.meli.tucasita.repository.IDistrictRepository;
import com.meli.tucasita.repository.IPropertyRepository;
import com.meli.tucasita.service.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    IDistrictRepository iDistrictRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void matchTotalMetersOfAnProperty1() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        Property property= new Property(propertyName,new District("Fontibon",2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithM2DTO response= propertyService.getTotalM2(propertyName);
        // Assert
        Assertions.assertEquals(1666.0,response.getTotal_m2());
    }

    @Test
    public void matchTotalMetersOfAnProperty2() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 2";
        Property property= new Property(propertyName,new District("Kennedy",1500),new ArrayList<>(Arrays.asList(
                new Environment("Baño",15,15),
                new Environment("Cocina",15,15),
                new Environment("Habitacion 1",15,15),
                new Environment("Habitacion 2",15,15)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithM2DTO response= propertyService.getTotalM2(propertyName);
        // Assert
        Assertions.assertEquals(900.0,response.getTotal_m2());
    }

    @Test
    public void matchBiggerEnvironmentOfAnProperty1() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        Property property= new Property(propertyName,new District("Fontibon",2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithBiggerEnvDTO response= propertyService.getBiggerEnvironment(propertyName);
        // Assert
        Assertions.assertEquals(new PropertyWithBiggerEnvDTO(propertyName,new EnvironmentResponseDTO("Cocina",720)),response);
    }

    @Test
    public void matchBiggerEnvironmentOfAnProperty2() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 2";
        Property property= new Property(propertyName,new District("Kennedy",1500),new ArrayList<>(Arrays.asList(
                new Environment("Baño",15,15),
                new Environment("Cocina",15,15),
                new Environment("Habitacion 1",15,15),
                new Environment("Habitacion 2",15,15)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithBiggerEnvDTO response= propertyService.getBiggerEnvironment(propertyName);
        // Assert
        Assertions.assertEquals(new PropertyWithBiggerEnvDTO(propertyName,new EnvironmentResponseDTO("Baño",225)),response);
    }

    @Test
    public void matchBiggerEnvironmentOfAnProperty3() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 3";
        Property property= new Property(propertyName,new District("Kennedy",1500),new ArrayList<>(Arrays.asList(
                new Environment("Habitacion 2",15,15)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithBiggerEnvDTO response= propertyService.getBiggerEnvironment(propertyName);
        // Assert
        Assertions.assertEquals(new PropertyWithBiggerEnvDTO(propertyName,new EnvironmentResponseDTO("Habitacion 2",225)),response);
    }

    @Test
    public void matchTotalMetersPerEnvironment() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        Property property= new Property(propertyName,new District("Fontibon",2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithEnvAndMetersDTO response= propertyService.getMetersPerEnvironment(propertyName);
        // Assert
        PropertyWithEnvAndMetersDTO expected= new PropertyWithEnvAndMetersDTO(propertyName,new ArrayList<>(Arrays.asList(
                new EnvironmentResponseDTO("Baño",300),
                new EnvironmentResponseDTO("Cocina",720),
                new EnvironmentResponseDTO("Habitacion 1",285),
                new EnvironmentResponseDTO("Habitacion 2",361)
        )));
        Assertions.assertEquals(expected,response);
    }

    @Test
    public void matchPriceWithAnExistentProperty() throws PropertyNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        Property property= new Property(propertyName,new District("Fontibon",2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Mockito.when(iPropertyRepository.getPropertyByName(propertyName)).thenReturn(property);
        // Act
        PropertyWithPriceDTO received= propertyService.getPrice(propertyName);
        // Assert
        PropertyWithPriceDTO expected= new PropertyWithPriceDTO(propertyName,3332000);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void addANewPropertyWithExistentDistrict() throws DistrictNotFoundException {
        // Arrange
        String propertyName= "Propiedad prueba 1";
        String districtName= "Fontibon";
        PropertyDTORequest propertyRequest= new PropertyDTORequest(propertyName,districtName,new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        Property property= new Property(propertyName,new District(districtName,2000),new ArrayList<>(Arrays.asList(
                new Environment("Baño",20,15),
                new Environment("Cocina",24,30),
                new Environment("Habitacion 1",15,19),
                new Environment("Habitacion 2",19,19)
        )));
        District district= new District(districtName,2000);
        Mockito.when(iDistrictRepository.getDistrictByName(districtName)).thenReturn(district);
        Mockito.when(iPropertyRepository.addNewProperty(property)).thenReturn(HttpStatus.CREATED);
        // Act
        HttpStatus received= propertyService.addNewProperty(propertyRequest);
        // Assert
        Assertions.assertEquals(HttpStatus.CREATED,received);
    }

}
