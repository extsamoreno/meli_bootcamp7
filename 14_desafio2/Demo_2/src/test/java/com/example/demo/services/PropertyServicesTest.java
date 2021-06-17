package com.example.demo.services;

import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.controller.PropertyController;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.repository.IPropertyRepository;
import com.example.demo.repository.RepositoryData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class PropertyServicesTest {

    @Mock
    IPropertyRepository repository;

    @InjectMocks
    PropertyServices services;

    @Test
    public void calculateSquareMeterHappyPath(){
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        Integer id = 1;
        when(repository.findPropertyById(id)).thenReturn(prop);
        PropertyDTO expected = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,159.0,0.0);

        // act
        PropertyDTO result = services.calculateSquareMeter(id);

        // assert
        verify(repository, atLeastOnce()).findPropertyById(id);
        assertEquals(expected, result);
    }

    @Test
    public void calculatePriceHappyPath(){
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        Integer id = 1;
        when(repository.findPropertyById(id)).thenReturn(prop);
        PropertyDTO expected = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,159.0,111300.0);

        // act
        PropertyDTO result = services.calculatePrice(id);

        // assert
        verify(repository, atLeastOnce()).findPropertyById(id);
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

        PropertyDTO prop = new PropertyDTO(3,"Casa familiar", new DistrictDTO("Colina",1000),env3,0.0,0.0);
        PropertyDTO expected = new PropertyDTO(3,"Casa familiar", new DistrictDTO("Colina",1000),env3,301.0,0.0);

        HashMap<Integer,PropertyDTO> propertyData = RepositoryData.loadProperty();
        when(repository.getAllProperty()).thenReturn(propertyData);

        // act
        PropertyDTO result = services.calculateBigger();

        // assert
        verify(repository, atLeastOnce()).getAllProperty();
        assertEquals(expected, result);
    }

    @Test
    public void calculateSquareMeterByEnvironmentHappyPath(){
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,32.0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,21.0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,6.0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,15.0));

        List<EnvironmentDTO> env2 = new ArrayList<>();
        env2.add(new EnvironmentDTO("First Room", 10,8.5,0.0));
        env2.add(new EnvironmentDTO("Secod Room", 8,4,0.0));
        env2.add(new EnvironmentDTO("Thirt Room", 7,3,0.0));
        env2.add(new EnvironmentDTO("BathRoom", 3,2,0.0));
        env2.add(new EnvironmentDTO("Kitchen", 5,3,0.0));

        PropertyDTO expected = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,0.0,0.0);
        PropertyDTO propIn = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env2,0.0,0.0);


        Integer id = 1;
        when(repository.findPropertyById(id)).thenReturn(propIn);

        // act
        PropertyDTO result = services.calculateSquareMeterByEnvironment(id);

        // assert
        verify(repository, atLeastOnce()).findPropertyById(id);
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
        when(repository.findDistrictByName(prop.getDistrict().getName())).thenReturn(new DistrictDTO("ParkWay",700));

        // act
        services.addProperty(prop);
        // assert
        verify(repository, atLeastOnce()).addProperty(prop);
        //assertEquals(expected, result);
    }

    @Test
    public  void addPropertyDistrictNotFoundException() throws DistrictNotFoundException {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("Cuarto", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Baño", 3,2,6.0));
        env1.add(new EnvironmentDTO("Cocina", 5,1,5.0));

        PropertyDTO prop = new PropertyDTO(5,"Casa prueba", new DistrictDTO("ParkWa",700),env1,0.0,0.0);
        when(repository.findDistrictByName(prop.getDistrict().getName())).thenReturn(null);

        // act & assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> services.addProperty(prop));

    }
}
