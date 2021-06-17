package com.meli.tucasitatasaciones.unit.service;

import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.dto.ResponseDTO;
import com.meli.tucasitatasaciones.model.Environment;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import com.meli.tucasitatasaciones.service.appraisal.AppraisalService;
import com.meli.tucasitatasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class AppraisalServiceTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    AppraisalService appraisalService;

    @Test
    public void getPropertyTotalSquareMetersWellCalculated() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        //Act
        ResponseDTO response = appraisalService.getPropertyTotalSquareMeters(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(40.0,response.getTotalSquareMeters());
    }

    @Test
    public void getPropertyValueWellCalculated() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        //Act
        ResponseDTO response = appraisalService.getPropertyValue(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(10000.0,response.getPropertyValue());
    }

    @Test
    public void getBiggestEnvironment() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        EnvironmentDTO env = TestUtilGenerator.toEnvironmentDTO(property.getEnvironments().get(0));
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);
        Mockito.when(modelMapper.map(property.getEnvironments().get(0),EnvironmentDTO.class)).thenReturn(env);

        //Act
        ResponseDTO response = appraisalService.getBiggestEnvironment(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(env,response.getBiggestEnvironment());
    }

    @Test
    public void getEnvironmentSquareMetersWellCalculated() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        //Act
        ResponseDTO response = appraisalService.getEnvironmentsSquareMeters(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(30.0,response.getEnvironmentsSquareMeters().get(0).getSquareMeters());
    }
}