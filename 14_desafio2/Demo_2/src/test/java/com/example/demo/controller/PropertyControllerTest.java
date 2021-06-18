package com.example.demo.controller;

import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.PropertyNotFoundException;
import com.example.demo.services.IPropertyServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyServices service;

    @InjectMocks
    PropertyController controller;

    @Test
    public void calculateSquareMeterHappyPath() throws PropertyNotFoundException {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        prop.setSquareMeters(159.0);
        ResponseEntity<PropertyDTO> expected = new ResponseEntity<>(prop, HttpStatus.OK);
        Integer id = 1;
        when(service.calculateSquareMeter(id)).thenReturn(prop);

        // act
        ResponseEntity<PropertyDTO> result = controller.calculateSquareMeter(id);

        // assert
        verify(service, atLeastOnce()).calculateSquareMeter(id);
        assertEquals(expected, result);
    }

    @Test
    public void calculatePriceHappyPath() throws PropertyNotFoundException {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        ResponseEntity<PropertyDTO> expected = new ResponseEntity<>(prop, HttpStatus.OK);
        prop.setPrice(111300.0);
        Integer id = 1;
        when(service.calculatePrice(id)).thenReturn(prop);

        // act
        ResponseEntity<PropertyDTO> result = controller.calculatePrice(id);

        // assert
        verify(service, atLeastOnce()).calculatePrice(id);
        assertEquals(expected, result);
    }

    @Test
    public void calculateBigger(){
        //arrage
        List<EnvironmentDTO> env3 = new ArrayList<>();
        env3.add(new EnvironmentDTO("First Room", 15,9,0));
        env3.add(new EnvironmentDTO("Secod Room", 10,8.5,0));
        env3.add(new EnvironmentDTO("Lobby", 5,7,0));
        env3.add(new EnvironmentDTO("Sala", 4,3,0));
        env3.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env3.add(new EnvironmentDTO("Kitchen", 7,4,0));

        PropertyDTO prop = new PropertyDTO(3,"Casa familiar", new DistrictDTO("Colina",1000),env3,301.0,0.0);
        ResponseEntity<PropertyDTO> expected = new ResponseEntity<>(prop, HttpStatus.OK);
        when(service.calculateBigger()).thenReturn(prop);

        // act
        ResponseEntity<PropertyDTO> result = controller.calculateBigger();

        // assert
        verify(service, atLeastOnce()).calculateBigger();
        assertEquals(expected, result);

    }

    @Test
    public void calculateSquareMeterByEnvironmentHappyPath() throws PropertyNotFoundException {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,32.0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,21.0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,6.0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,15.0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        ResponseEntity<PropertyDTO> expected = new ResponseEntity<>(prop, HttpStatus.OK);
        prop.setPrice(111300.0);
        Integer id = 1;
        when(service.calculateSquareMeterByEnvironment(id)).thenReturn(prop);

        // act
        ResponseEntity<PropertyDTO> result = controller.calculateSquareMeterByEnvironment(id);

        // assert
        verify(service, atLeastOnce()).calculateSquareMeterByEnvironment(id);
        assertEquals(expected, result);
    }

    @Test
    public void addPropertyHappyPath() throws DistrictNotFoundException {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("Cuarto", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Baño", 3,2,6.0));
        env1.add(new EnvironmentDTO("Cocina", 5,1,5.0));

        PropertyDTO prop = new PropertyDTO(5,"Casa prueba", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        ResponseEntity<Void> expected = new ResponseEntity<>(HttpStatus.OK);

        // act
        ResponseEntity<Void> result = controller.addProperty(prop);
        // assert
        verify(service, atLeastOnce()).addProperty(prop);
        assertEquals(expected, result);

    }

    @Test
    public  void addPropertyDistrictNotFoundException() throws DistrictNotFoundException {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("Cuarto", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Baño", 3,2,6.0));
        env1.add(new EnvironmentDTO("Cocina", 5,1,5.0));

        PropertyDTO prop = new PropertyDTO(5,"Casa prueba", new DistrictDTO("ParkWa",700),env1,0.0,0.0);

        // act & assert
        doThrow(DistrictNotFoundException.class).doNothing().when(service).addProperty(prop);
        Assertions.assertThrows(DistrictNotFoundException.class,() -> controller.addProperty(prop));
    }


}
