package com.bootcamp.tucasitatasaciones.unit.service;

import com.bootcamp.tucasitatasaciones.DTO.*;
import com.bootcamp.tucasitatasaciones.exception.NotFoundException;
import com.bootcamp.tucasitatasaciones.model.District;
import com.bootcamp.tucasitatasaciones.model.Environment;
import com.bootcamp.tucasitatasaciones.model.Property;
import com.bootcamp.tucasitatasaciones.repository.IDataRepository;
import com.bootcamp.tucasitatasaciones.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IDataRepository dataRepository;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    PropertyService propertyService;

    static PropertyDTO propertyDTO;
    static Property property;
    static Environment biggestEnvironment;
    static EnvironmentDTO biggestEnvironmentDTO;
    static List<EnvironmentWithSquareMetersDTO> environmentWithSquareMeters;
    static PropertyAppraisalDTO propertyAppraisalDTO;
    static District district;

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

        biggestEnvironment = new Environment("Env1", 10.0, 20.0);
        biggestEnvironmentDTO = new EnvironmentDTO("Env1", 10.0, 20.0);

        environmentWithSquareMeters = new ArrayList<>() {{
            add(new EnvironmentWithSquareMetersDTO("Env1", 200.0));
            add(new EnvironmentWithSquareMetersDTO("Env2", 35.0));
            add(new EnvironmentWithSquareMetersDTO("Env3", 40.0));
        }};

        district = new District(2L, "Bella Vista", 900.0);

        propertyAppraisalDTO = new PropertyAppraisalDTO("Casa 1", 247500.0);
    }

    //==================================TESTS==================================================

    @Test
    public void registerPropertyHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(dataRepository.findDistrictByName(propertyDTO.getDistrict().getName())).thenReturn(district);
        Mockito.when(mapper.map(propertyDTO, Property.class)).thenReturn(property);
        Mockito.doNothing().when(dataRepository).saveProperty(property);

        //act
        propertyService.registerProperty(propertyDTO);

        //assert
        Mockito.verify(mapper, Mockito.atLeast(1)).map(propertyDTO, Property.class);
        Mockito.verify(dataRepository, Mockito.atLeast(1)).saveProperty(property);
    }

    @Test
    public void registerPropertyDistrictNotFound() {
        //arrange
        Mockito.when(dataRepository.findDistrictByName(propertyDTO.getDistrict().getName())).thenReturn(null);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.registerProperty(propertyDTO));
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findDistrictByName(propertyDTO.getDistrict().getName());
    }

    @Test
    public void getTotalSquareMetersHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);

        //act
        TotalSquareMetersDTO received = propertyService.getTotalSquareMeters(property.getId());

        //assert
        Assertions.assertEquals(275, received.getTotalSquareMeter());
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
    }

    @Test
    public void getTotalSquareMetersPropertyNotFound() {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getTotalSquareMeters(property.getId()));
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
    }

    @Test
    public void appraiseProperty() throws NotFoundException {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);
        Mockito.when(dataRepository.findDistrictById(property.getDistrictId())).thenReturn(district);

        //act
        PropertyAppraisalDTO received = propertyService.appraiseProperty(property.getId());

        //assert
        Assertions.assertEquals(propertyAppraisalDTO, received);
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findDistrictById(property.getDistrictId());
    }

    @Test
    public void appraisePropertyNotFound() {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.appraiseProperty(property.getId()));
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
    }

    @Test
    public void getBiggestEnviromentHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);
        Mockito.when(mapper.map(biggestEnvironment, EnvironmentDTO.class)).thenReturn(biggestEnvironmentDTO);

        //act
        EnvironmentDTO received = propertyService.getBiggestEnvironment(property.getId());

        //assert
        Assertions.assertEquals(biggestEnvironmentDTO, received);
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
        Mockito.verify(mapper, Mockito.atLeast(1)).map(biggestEnvironment, EnvironmentDTO.class);
    }

    @Test
    public void getBiggestEnvironmetPropertyNotFound() {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getBiggestEnvironment(property.getId()));
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
    }

    @Test
    public void getAllEnvironmentsWithSquareMetersHappyPath() throws NotFoundException {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(property);

        //act
        List<EnvironmentWithSquareMetersDTO> received = propertyService.getAllEnvironmentsWithSquareMeters(property.getId());

        //assert
        Assertions.assertEquals(environmentWithSquareMeters, received);
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
    }

    @Test
    public void getAllEnvironmentsWithSquareMetersPropertyNotFound() {
        //arrange
        Mockito.when(dataRepository.findPropertyById(property.getId())).thenReturn(null);

        //assert
        Assertions.assertThrows(NotFoundException.class, () -> propertyService.getAllEnvironmentsWithSquareMeters(property.getId()));
        Mockito.verify(dataRepository, Mockito.atLeast(1)).findPropertyById(property.getId());
    }

}
