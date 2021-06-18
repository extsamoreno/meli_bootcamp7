package com.tucasitatasaciones.demo.unit;

import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.exception.BadRequestException;
import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.models.Property;
import com.tucasitatasaciones.demo.repository.IDistrictRepository;
import com.tucasitatasaciones.demo.repository.IPropertyRepository;
import com.tucasitatasaciones.demo.service.PropertyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    IDistrictRepository districtRepository;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    PropertyService propertyService;

    private Property property;
    private PropertyDTO propertyDTO;
    private PropertySquareMettersDTO propertySquareMetters;
    private PropertyPriceDTO propertyPrice;
    private PropertyBiggestEnvironmentDTO propertyBiggestEnvironment;
    private PropertyEnvironmentSquareMetterDTO propertyEnvironmentMetters;
    private District district;
    private DistrictDTO districtDTO;

    @BeforeEach
    @AfterEach
    public void init(){
        property = Utils.getProperty();
        propertyDTO = Utils.getPropertyDTO();
        propertySquareMetters = Utils.getPropertySquareMetters();
        propertyPrice = Utils.getPropertyPrice();
        propertyBiggestEnvironment = Utils.getPropertyBiggestEnvironment();
        propertyEnvironmentMetters = Utils.getPropertyEnviromentsSquareMetters();
        district = Utils.getDistrict();
        districtDTO = Utils.getDistrictDTO();
    }

    @Test
    public void testAddPropertyWithValidPayload() throws BadRequestException {
        //Arrange
        when(districtRepository.findDistrictById(property.getDistrictId())).thenReturn(district);
        when(mapper.map(propertyDTO, Property.class)).thenReturn(property);
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(propertyRepository.findPropertyByName(property.getName())).thenReturn(null);
        when(propertyRepository.addProperty(property)).thenReturn(property);

        //Act
        PropertyDTO propertyReceived = propertyService.addProperty(propertyDTO);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyByName(propertyDTO.getName());
        verify(districtRepository, atLeastOnce()).findDistrictById(property.getDistrictId());
        verify(propertyRepository, atLeastOnce()).addProperty(property);

        assertEquals(propertyDTO, propertyReceived);
    }

    @Test
    public void testAddPropertyWithInvalidDistrict() throws BadRequestException {
        //Arrange
        BadRequestException exceptionExpected = new BadRequestException("El id de barrio no corresponde a ningun barrio existente.");
        when(districtRepository.findDistrictById(property.getDistrictId())).thenReturn(null);

        //Act
        BadRequestException exceptionReceived = assertThrows(BadRequestException.class, () -> {
            propertyService.addProperty(propertyDTO);
        });

        //Assert
        verify(districtRepository, atLeastOnce()).findDistrictById(property.getDistrictId());
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
        assertEquals(exceptionExpected.getStatus(), exceptionReceived.getStatus());
    }

    @Test
    public void testAddPropertyWithPropertyExist() throws BadRequestException {
        //Arrange
        BadRequestException exceptionExpected = new BadRequestException("La propiedad que intenta crear ya existe.");

        when(districtRepository.findDistrictById(property.getDistrictId())).thenReturn(district);
        when(propertyRepository.findPropertyByName(property.getName())).thenReturn(property);

        //Act
        BadRequestException exceptionReceived = assertThrows(BadRequestException.class, () -> {
            propertyService.addProperty(propertyDTO);
        });

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyByName(propertyDTO.getName());
        verify(districtRepository, atLeastOnce()).findDistrictById(property.getDistrictId());

        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
        assertEquals(exceptionExpected.getStatus(), exceptionReceived.getStatus());
    }

    @Test
    public void testCalculateSquareMettersByIdWithValidProperty() throws BadRequestException {
        //Arrange
        double squareMettersExpected = 1500;

        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(propertyDTO, PropertySquareMettersDTO.class)).thenReturn(propertySquareMetters);
        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        //Act
        PropertySquareMettersDTO propertyReceived = propertyService.calculateSquareMettersById(1);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(1);

        assertEquals(squareMettersExpected, propertyReceived.getSquareMetters());
    }

    @Test
    public void testCalculatePropertyPriceByIdWithValidProperty() throws BadRequestException {
        //Arrange
        double priceExpected = 30000;

        when(districtRepository.findDistrictById(property.getDistrictId())).thenReturn(district);
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(district, DistrictDTO.class)).thenReturn(districtDTO);
        when(mapper.map(propertyDTO, PropertyPriceDTO.class)).thenReturn(propertyPrice);
        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        //Act
        PropertyPriceDTO propertyReceived = propertyService.calculatePropertyPriceById(1);

        //Assert
        verify(districtRepository, atLeastOnce()).findDistrictById(property.getDistrictId());
        verify(propertyRepository, atLeastOnce()).findPropertyById(1);

        assertEquals(priceExpected, propertyReceived.getPrice());
    }

    @Test
    public void testCalculateBiggestEnvironmentByIdWithValidProperty() throws BadRequestException {
        //Arrange
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(propertyDTO, PropertyBiggestEnvironmentDTO.class)).thenReturn(propertyBiggestEnvironment);
        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        //Act
        PropertyBiggestEnvironmentDTO propertyReceived = propertyService.calculateBiggestEnvironmentById(1);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(1);

        assertEquals(propertyBiggestEnvironment.getBiggestEnvironment(), propertyReceived.getBiggestEnvironment());
    }


    @Test
    public void testCalculateSquareMettersEnvironmentsByIdWithValidProperty() throws BadRequestException {
        //Arrange
        when(propertyRepository.findPropertyById(1)).thenReturn(property);
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(propertyDTO, PropertyEnvironmentSquareMetterDTO.class)).thenReturn(propertyEnvironmentMetters);
        when(mapper.map(propertyDTO.getEnvironments().get(0), EnvironmentSquareMetterDTO.class)).thenReturn(propertyEnvironmentMetters.getEnvironments().get(0));
        when(mapper.map(propertyDTO.getEnvironments().get(1), EnvironmentSquareMetterDTO.class)).thenReturn(propertyEnvironmentMetters.getEnvironments().get(1));
        when(mapper.map(propertyDTO.getEnvironments().get(2), EnvironmentSquareMetterDTO.class)).thenReturn(propertyEnvironmentMetters.getEnvironments().get(2));
        //Act
        PropertyEnvironmentSquareMetterDTO propertyReceived = propertyService.calculateSquareMettersEnvironmentsById(1);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(1);

        assertEquals(propertyEnvironmentMetters.getEnvironments(), propertyReceived.getEnvironments());
    }


    @Test
    public void testFindByIdWithValidId() throws BadRequestException {
        //Arrange
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(propertyRepository.findPropertyById(1)).thenReturn(property);

        //Act
        PropertyDTO propertyReceived = propertyService.findPropertyById(1);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(1);

        assertEquals(propertyDTO, propertyReceived);
    }

    @Test
    public void testFindByIdWithInvalidId() throws BadRequestException {
        //Arrange
        BadRequestException exceptionExpected = new BadRequestException("El id ingresado es invalido.");

        //Act
        BadRequestException exceptionReceived = assertThrows(BadRequestException.class, ()-> {
            propertyService.findPropertyById(0);
        });

        //Assert
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
        assertEquals(exceptionExpected.getStatus(), exceptionReceived.getStatus());
    }

    @Test
    public void testFindByIdWithNotExistProperty() throws BadRequestException {
        //Arrange
        BadRequestException exceptionExpected = new BadRequestException("La propiedad con el id 1 no existe.");

        when(propertyRepository.findPropertyById(1)).thenReturn(null);

        //Act
        BadRequestException exceptionReceived = assertThrows(BadRequestException.class, ()-> {
            propertyService.findPropertyById(1);
        });

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(1);
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
        assertEquals(exceptionExpected.getStatus(), exceptionReceived.getStatus());
    }

}
