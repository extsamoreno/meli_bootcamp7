package com.example.challenge2.unit;

import com.example.challenge2.controllers.PropertyController;
import com.example.challenge2.dtos.EnvironmentDTO;
import com.example.challenge2.dtos.PriceDTO;
import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.dtos.TotalAreaDTO;
import com.example.challenge2.service.IPropertyService;
import com.example.challenge2.service.PropertyService;
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
    PropertyService service;
    @InjectMocks
    PropertyController controller;

    PropertyDTO house = new PropertyDTO("Prop1", "Ñuñoa", new ArrayList<>() {
        {
            add(new EnvironmentDTO("Environment1", 3.0, 2.0));
            add(new EnvironmentDTO("Environment2", 3.0, 4.0));
        }
    });

    @Test
    public void totalAreaHappyPath() throws Exception {
        //arrange
        TotalAreaDTO dto = new TotalAreaDTO("Prop1", 18.0);
        ResponseEntity<?> expected = new ResponseEntity<>(dto, HttpStatus.OK);
        Mockito.when(service.totalArea(house)).thenReturn(new TotalAreaDTO("Prop1", 18.0));

        //act
        ResponseEntity<?> received = controller.totalAreaDTO(house);

        //assert
        Mockito.verify(service, Mockito.atLeast(1)).totalArea(house);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void priceHappyPath() throws Exception {
        //arrange
        PriceDTO dto = new PriceDTO("Prop1", 15.0 * 50.0);
        ResponseEntity<PriceDTO> expected = new ResponseEntity<>(dto, HttpStatus.OK);

        Mockito.when(service.price(house)).thenReturn(new PriceDTO("prop1", 18.0 * 100.0));

        //act
        ResponseEntity<PriceDTO> received = controller.price(house);

        //assert
        Mockito.verify(service, Mockito.atLeast(1)).priceDTO(house);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void environmentsAreaHappyPath() throws Exception {
        //arrange
        ArrayList<EnvironmentDTO> dto = new ArrayList<>(){
            {   add(new EnvironmentDTO("Environment1",3.0));
                add(new EnvironmentDTO("Environment2",2.0));
            }
        };
        Mockito.when(service.environmentsArea(house)).thenReturn(new ArrayList<>(){
            {   add(new EnvironmentAreaDTO("Environment1",3.0));
                add(new EnvironmentAreaDTO("Environment2",2.0));
            }
        });

        ResponseEntity<List> expected = new ResponseEntity<>(dto,HttpStatus.OK);

        //act
        ResponseEntity<ArrayList<EnvironmentAreaDTO>> received = controller.environmentsArea(house);

        //assert
        Mockito.verify(service,Mockito.atLeast(1)).environmentsAreaDTO(house);
        Assertions.assertEquals(expected,received);
    }
}