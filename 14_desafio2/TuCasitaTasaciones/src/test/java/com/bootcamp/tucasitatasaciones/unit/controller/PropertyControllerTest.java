package com.bootcamp.tucasitatasaciones.unit.controller;

import com.bootcamp.tucasitatasaciones.DTO.*;
import com.bootcamp.tucasitatasaciones.controller.PropertyController;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import com.bootcamp.tucasitatasaciones.model.Environment;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.bootcamp.tucasitatasaciones.service.IPropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService propertyService;

    @InjectMocks
    PropertyController propertyController;

    static PropertyDTO propertyDTO;
    static Property property;
    static EnvironmentDTO biggestEnvironmentDTO;
    static List<EnvironmentWithSquareMetersDTO> environmentWithSquareMeters;
    static PropertyAppraisalDTO propertyAppraisalDTO;
    static TotalSquareMetersDTO totalSquareMetersDTO;

    @BeforeAll
    public static void beforeAll() {
        propertyDTO = new PropertyDTO("Casa 1", new DistrictDTO("Bella Vista"),
                new ArrayList<>() {{
                    add(new EnvironmentDTO("Env1", 10.0, 20.0));
                    add(new EnvironmentDTO("Env2", 5.0, 7.0));
                    add(new EnvironmentDTO("Env3", 8.0, 5.0));
                }});

        property = new Property(1L, "Casa 1", 2L,
                new ArrayList<>() {{
                    add(new Environment("Env1", 10.0, 20.0));
                    add(new Environment("Env2", 5.0, 7.0));
                    add(new Environment("Env3", 8.0, 5.0));
                }});

        biggestEnvironmentDTO = new EnvironmentDTO("Env1", 10.0, 20.0);

        environmentWithSquareMeters = new ArrayList<>() {{
            add(new EnvironmentWithSquareMetersDTO("Env1", 200.0));
            add(new EnvironmentWithSquareMetersDTO("Env2", 35.0));
            add(new EnvironmentWithSquareMetersDTO("Env3", 40.0));
        }};

        propertyAppraisalDTO = new PropertyAppraisalDTO("Casa 1", 247500.0);

        totalSquareMetersDTO = new TotalSquareMetersDTO("Casa 1", 275.0);
    }

    //==================================TESTS==================================================

    @Test
    public void registerPropertyHappyPath() throws NotFoundException {
        //arrange
        Mockito.doNothing().when(propertyService).registerProperty(propertyDTO);

        //act
        propertyController.registerProperty(propertyDTO);

        //assert
        Mockito.verify(propertyService, Mockito.atLeast(1)).registerProperty(propertyDTO);
    }

    @Test
    public void registerPropertyDistrictNotFound() throws NotFoundException {
        //arrange
        Mockito.doThrow(NotFoundException.class).when(propertyService).registerProperty(propertyDTO);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyController.registerProperty(propertyDTO));
        Mockito.verify(propertyService, Mockito.atLeast(1)).registerProperty(propertyDTO);
    }

    @Test
    public void getTotalSquareMetersHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.getTotalSquareMeters(property.getId())).thenReturn(totalSquareMetersDTO);

        //act
        ResponseEntity<TotalSquareMetersDTO> received = propertyController.getTotalSquareMeters(property.getId());

        //assert
        Assertions.assertEquals(totalSquareMetersDTO, received.getBody());
        Mockito.verify(propertyService, Mockito.atLeast(1)).getTotalSquareMeters(property.getId());
    }

    @Test
    public void getTotalSquareMetersPropertyNotFound() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.getTotalSquareMeters(property.getId())).thenThrow(NotFoundException.class);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyController.getTotalSquareMeters(property.getId()));
        Mockito.verify(propertyService, Mockito.atLeast(1)).getTotalSquareMeters(property.getId());
    }

    @Test
    public void appraiseProperty() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.appraiseProperty(property.getId())).thenReturn(propertyAppraisalDTO);

        //act
        ResponseEntity<PropertyAppraisalDTO> received = propertyController.appraiseProperty(property.getId());

        //assert
        Assertions.assertEquals(propertyAppraisalDTO, received.getBody());
        Mockito.verify(propertyService, Mockito.atLeast(1)).appraiseProperty(property.getId());
    }

    @Test
    public void appraisePropertyNotFound() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.appraiseProperty(property.getId())).thenThrow(NotFoundException.class);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyController.appraiseProperty(property.getId()));
        Mockito.verify(propertyService, Mockito.atLeast(1)).appraiseProperty(property.getId());
    }

    @Test
    public void getBiggestEnviromentHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.getBiggestEnvironment(property.getId())).thenReturn(biggestEnvironmentDTO);

        //act
        ResponseEntity<EnvironmentDTO> received = propertyController.getBiggestEnvironment(property.getId());

        //assert
        Assertions.assertEquals(biggestEnvironmentDTO, received.getBody());
        Mockito.verify(propertyService, Mockito.atLeast(1)).getBiggestEnvironment(property.getId());
    }

    @Test
    public void getBiggestEnvironmetPropertyNotFound() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.getBiggestEnvironment(property.getId())).thenThrow(NotFoundException.class);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyController.getBiggestEnvironment(property.getId()));
        Mockito.verify(propertyService, Mockito.atLeast(1)).getBiggestEnvironment(property.getId());
    }

    @Test
    public void getAllEnvironmentsWithSquareMetersHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.getAllEnvironmentsWithSquareMeters(property.getId())).thenReturn(environmentWithSquareMeters);

        //act
        ResponseEntity<List<EnvironmentWithSquareMetersDTO>> received = propertyController.getAllEnvironmentsWithSquareMeters(property.getId());

        //assert
        Assertions.assertEquals(environmentWithSquareMeters, received.getBody());
        Mockito.verify(propertyService, Mockito.atLeast(1)).getAllEnvironmentsWithSquareMeters(property.getId());
    }

    @Test
    public void getAllEnvironmentsWithSquareMetersPropertyNotFound() throws NotFoundException {
        //arrange
        Mockito.when(propertyService.getAllEnvironmentsWithSquareMeters(property.getId())).thenThrow(NotFoundException.class);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyController.getAllEnvironmentsWithSquareMeters(property.getId()));
        Mockito.verify(propertyService, Mockito.atLeast(1)).getAllEnvironmentsWithSquareMeters(property.getId());
    }

}
