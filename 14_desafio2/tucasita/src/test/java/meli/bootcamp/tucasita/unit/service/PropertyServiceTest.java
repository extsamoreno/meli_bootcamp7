package meli.bootcamp.tucasita.unit.service;


import meli.bootcamp.tucasita.exception.PropertyNotFoundException;
import meli.bootcamp.tucasita.model.Property;
import meli.bootcamp.tucasita.repository.IDistrictRepository;
import meli.bootcamp.tucasita.repository.IPropertyRepository;
import meli.bootcamp.tucasita.service.PropertyService;
import meli.bootcamp.tucasita.service.dto.*;
import meli.bootcamp.tucasita.service.mapper.EnviromentMapper;
import meli.bootcamp.tucasita.service.mapper.PropertyDTOMapper;
import meli.bootcamp.tucasita.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static meli.bootcamp.tucasita.util.TestUtilsGenerator.DECIMAL_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {


    @Mock
    IDistrictRepository iDistrictRepository;

    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;



    @Test
    public void getPropertyAndVerifyMetersSuccessTest() throws PropertyNotFoundException {
        // arrange
        Property property= TestUtilsGenerator.getPropertyWith3Environments("Ascienda");
        PropertyDTO propertyDTO= PropertyDTOMapper.toDTO(property);
        PropertyResponseDTO expect= new PropertyResponseDTO(DECIMAL_FORMAT.format(897.5D),null,propertyDTO);
        when(iDistrictRepository.save(property.getDistrict())).thenReturn(property.getDistrict());
        doNothing().when(iPropertyRepository).save(property);

        // act
        PropertyResponseDTO result = propertyService.getMetersProperty(propertyDTO);

        // assert
        verify(iPropertyRepository, atLeastOnce()).save(property);
        verify(iDistrictRepository, atLeastOnce()).save(property.getDistrict());
        assertEquals(expect, result);
    }

    @Test
    public void getPropertyByNameAndVerifyMetersSuccessTest() throws PropertyNotFoundException {
        // arrange
        Property property= TestUtilsGenerator.getPropertyWith3Environments("Ascienda");
        PropertyDTO propertyDTO= PropertyDTOMapper.toDTO(property);
        PropertyResponseDTO expect= new PropertyResponseDTO(DECIMAL_FORMAT.format(897.5D),null,propertyDTO);
        when(iPropertyRepository.findById(property.getProp_name())).thenReturn(property);
        // act
        PropertyResponseDTO result = propertyService.getMetersProperty(property.getProp_name());
        // assert
        verify(iPropertyRepository, atLeastOnce()).findById(property.getProp_name());
        assertEquals(expect, result);
    }

    @Test
    public void getPropertyByNameAndVerifyPriceSuccessTest() throws PropertyNotFoundException {
        // arrange
        Property property= TestUtilsGenerator.getPropertyWith3Environments("Ascienda");
        PropertyDTO propertyDTO= PropertyDTOMapper.toDTO(property);
        PropertyResponseDTO expect= new PropertyResponseDTO(null,DECIMAL_FORMAT.format(897.5D*500),propertyDTO);
        when(iPropertyRepository.findById(property.getProp_name())).thenReturn(property);

        // act
        PropertyResponseDTO result = propertyService.getPricePropertyById(propertyDTO.getProp_name());

        // assert
        verify(iPropertyRepository, atLeastOnce()).findById(property.getProp_name());
        assertEquals(expect, result);
    }

    @Test
    public void getEnvironmentMostLargeOfOnePropertySuccessTest() throws PropertyNotFoundException {
        // arrange
        Property property= TestUtilsGenerator.getPropertyWith3Environments("Ascienda");
        EnviromentResponseDTO expect= new EnviromentResponseDTO(property.getProp_name(), EnviromentMapper.toDTOSquareMetersNull(property.getEnvironments().get(1)));
        when(iPropertyRepository.findById(property.getProp_name())).thenReturn(property);

        // act
        EnviromentResponseDTO result = propertyService.getLargerEnvironmentPropertyById(property.getProp_name());

        // assert
        verify(iPropertyRepository, atLeastOnce()).findById(property.getProp_name());
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void getEnvironmentsWithMetersOfOnePropertySuccessTest() throws PropertyNotFoundException {
        // arrange
        Property property= TestUtilsGenerator.getPropertyWith3Environments("Ascienda");
        List<EnvironmentDTO> environmentDTOS= Arrays.asList(
                EnviromentMapper.toDTO(property.getEnvironments().get(0)),EnviromentMapper.toDTO(property.getEnvironments().get(1)),
                EnviromentMapper.toDTO(property.getEnvironments().get(2))
        );
        EnviromentsMetersResponseDTO expect= new EnviromentsMetersResponseDTO(property.getProp_name(), environmentDTOS);
        when(iPropertyRepository.findById(property.getProp_name())).thenReturn(property);

        // act
        EnviromentsMetersResponseDTO result = propertyService.getMetersEnvironmentPropertyById(property.getProp_name());

        // assert
        verify(iPropertyRepository, atLeastOnce()).findById(property.getProp_name());
        Assertions.assertEquals(expect, result);
    }

}
