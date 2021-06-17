package com.example.desafio2.unit.controller;

import com.example.desafio2.controller.PropertyController;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.IPropertyService;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

        @Mock
        IPropertyService service;

        @InjectMocks
        PropertyController controller;

        @Test
        public void createProperty() {
            // arrange
            try{
                PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith1Room("Ciudad de la Costa");
                Mockito.doNothing().when(service).createProperty(prop);
                // act

                // act
                controller.createProperty(prop);

                // assert
                verify(service, atLeastOnce()).createProperty(prop);
            }
            catch(Exception ex){
            }
        }



}
