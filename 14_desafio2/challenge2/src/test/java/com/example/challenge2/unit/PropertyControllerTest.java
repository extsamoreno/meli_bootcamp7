package com.example.challenge2.unit;

import com.example.challenge2.controllers.PropertyController;
import com.example.challenge2.dtos.*;
import com.example.challenge2.models.Environment;
import com.example.challenge2.serivces.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {
    @Mock
    IPropertyService propertyService;
    @InjectMocks
    PropertyController propertyController;


    @Test
    public void registerNewProperty() {
        //Arrange
        PropertyDTO propertyDTO =new PropertyDTO();
        Environment cuarto1 = new Environment("Cuarto1",6.0,9.0);
        Environment cuarto2 = new Environment("Cuarto2",7.0,1.8);

        List<Environment> environments = new ArrayList<>();
        environments.add(cuarto1);
        environments.add(cuarto2);

        propertyDTO.setName("Propiedad1");
        propertyDTO.setDistrictName("Carrasco");
        propertyDTO.setEnvironmentList(environments);

        //Act
        ResponseEntity<?> received = propertyController.registerProperty(propertyDTO);

        //Asset
        Mockito.verify(propertyService,Mockito.atLeastOnce()).create(propertyDTO);
        Assertions.assertEquals(HttpStatus.CREATED,received.getStatusCode());
    }



    @Test
    public void getSize() {
        //arrange
        String name = "Propiedad1";
        SizeResponseDTO sizeResponseDTO = new SizeResponseDTO();
        sizeResponseDTO.setSize(46.0);
        Mockito.when(propertyService.getSize(name)).thenReturn(sizeResponseDTO);

        //act
        ResponseEntity<SizeResponseDTO> received = propertyController.getSize(name);

        //asset
        Mockito.verify(propertyService,Mockito.atLeastOnce()).getSize(name);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(sizeResponseDTO.getSize(),received.getBody().getSize());
    }

    @Test
    public void getPrice() {
        //arrange
        String name = "Propiedad1";
        PriceResponseDTO priceResponseDTO = new PriceResponseDTO();
        priceResponseDTO.setPrice(36800.00);
        Mockito.when(propertyService.getPrice(name)).thenReturn(priceResponseDTO);

        //act
        ResponseEntity<PriceResponseDTO> received = propertyController.getPrice(name);

        //asset
        Mockito.verify(propertyService,Mockito.atLeastOnce()).getPrice(name);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(priceResponseDTO.getPrice(),received.getBody().getPrice());
    }

    @Test
    public void getBiggerEnvironment() {
        //arrange
        String name = "Propiedad1";
        BiggerEnvironmentResponseDTO biggerEnvironmentResponseDTO = new BiggerEnvironmentResponseDTO(name, new Environment("Cuarto1", 4.00, 5.00));
        Mockito.when(propertyService.getBiggerEnvironment(name)).thenReturn(biggerEnvironmentResponseDTO);

        //act
        ResponseEntity<BiggerEnvironmentResponseDTO> received = propertyController.getBiggerEnvironment(name);

        //asset
        Mockito.verify(propertyService,Mockito.atLeastOnce()).getBiggerEnvironment(name);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(biggerEnvironmentResponseDTO.getBiggerEnvironment(),received.getBody().getBiggerEnvironment());
    }


    @Test
    public void getEnvironments() {
        //arrange
        String name = "Propiedad1";
        EnvironmentSizesDTO environmentSizesDTO = new EnvironmentSizesDTO();
        List<SizeResponseDTO> environments = new ArrayList<>();
        environments.add(new SizeResponseDTO("Cuarto1", 16.00));
        environments.add(new SizeResponseDTO("Cuarto2", 30.00));
        environmentSizesDTO.setEnvironments(environments);
        Mockito.when(propertyService.getEnvironments(name)).thenReturn(environmentSizesDTO);

        //act
        ResponseEntity<EnvironmentSizesDTO> received = propertyController.getEnvironments(name);

        //assert
        Mockito.verify(propertyService,Mockito.atLeastOnce()).getEnvironments(name);
        Assertions.assertEquals(HttpStatus.OK,received.getStatusCode());
        Assertions.assertEquals(environmentSizesDTO.getEnvironments(),received.getBody().getEnvironments());
    }





    /*PropertyDTO property = new PropertyDTO("Propiedad1", "Carrasco", new ArrayList<>(){
        {
            add(new Environment("Cuarto1", 4.0, 2.0));
            add(new Environment("Cuarto2", 2.0, 2.0));
        }
    });

    @Test
    public void totalSizeHappyPath() throws Exception {
        //arrange
        SizeResponseDTO dto= new SizeResponseDTO("Propiedad1",12.0);
        ResponseEntity<?> expected = new ResponseEntity<>(dto, HttpStatus.OK);
        Mockito.when(propertyService.getSize(property.getName())).thenReturn(new SizeResponseDTO("Propiedad1",12.0));

        //act
        ResponseEntity<?> received = propertyController.getSize(property.getName());

        //assert
        Mockito.verify(service,Mockito.atLeast(1)).totalArea(house);
        Assertions.assertEquals(expected,received);
    }*/

}
