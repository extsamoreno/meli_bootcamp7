package com.desafiotesting.desafiotesting.unittest.services;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.repositories.IPropertyRepository;
import com.desafiotesting.desafiotesting.services.PropertyService;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentDTO;
import com.desafiotesting.desafiotesting.services.dtos.EnviromentWithSquareMetersDTO;
import com.desafiotesting.desafiotesting.utils.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void totalSquareMetersTest(){
        Property property = TestUtilGenerator.getProperty("district1");

        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(property);

        double totalResponse = propertyService.totalSquareMeters(property.getId());

        Mockito.verify(propertyRepository,Mockito.atLeast(1)).findById(property.getId());
        Assertions.assertEquals(2294.25,totalResponse);
    }

    @Test
    public void getBiggerEnviromentTest(){
        Property property = TestUtilGenerator.getProperty("district1");
        EnviromentDTO enviromentExpected = mapper.map(property.getEnviroments().get(0),EnviromentDTO.class);

        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(property);

        EnviromentDTO enviromentDTOResponse = propertyService.getBiggerEnviroment(property.getId());

        Mockito.verify(propertyRepository,Mockito.atLeast(1)).findById(property.getId());
        Assertions.assertEquals(enviromentExpected,enviromentDTOResponse);
    }

    @Test
    public void getPricePropertyTest(){
        Property property = TestUtilGenerator.getProperty("district1");

        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(property);

        double totalResponse = propertyService.getPriceProperty(property.getId());

        Mockito.verify(propertyRepository,Mockito.atLeast(1)).findById(property.getId());
        Assertions.assertEquals(517353.375,totalResponse);
    }


    @Test
    public void getEnviromentsInfoTest(){
        Property property = TestUtilGenerator.getProperty("district1");

        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(property);

        List<EnviromentWithSquareMetersDTO> responseList = propertyService.getEnviromentsInfo(property.getId());

        Mockito.verify(propertyRepository,Mockito.atLeast(1)).findById(property.getId());
        Assertions.assertEquals(1121.25,responseList.get(0).getSquareMeters());
        Assertions.assertEquals(741.75,responseList.get(1).getSquareMeters());
        Assertions.assertEquals(431.25,responseList.get(2).getSquareMeters());
    }






}
