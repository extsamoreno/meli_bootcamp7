package com.tucasitatasaciones.demo.unit;

import com.tucasitatasaciones.demo.dto.*;
import com.tucasitatasaciones.demo.exception.BadRequestException;
import com.tucasitatasaciones.demo.models.District;
import com.tucasitatasaciones.demo.models.Property;
import com.tucasitatasaciones.demo.repository.IDistrictRepository;
import com.tucasitatasaciones.demo.repository.IPropertyRepository;
import com.tucasitatasaciones.demo.service.PropertyService;
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

    @Test
    public void testAddPropertyWithValidPayload() throws BadRequestException {
        //Arrange
        Property property = Utils.getProperty();
        District district = new District(3, "Nueva Cordoba", 55);
        PropertyDTO propertyExpected = Utils.getPropertyDTO();

        when(districtRepository.findDistrictById(property.getDistrictId())).thenReturn(district);
        when(mapper.map(propertyExpected, Property.class)).thenReturn(property);
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyExpected);
        when(propertyRepository.findPropertyByName(property.getName())).thenReturn(null);
        when(propertyRepository.addProperty(property)).thenReturn(property);

        //Act
        PropertyDTO propertyReceived = propertyService.addProperty(propertyExpected);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyByName(propertyExpected.getName());
        verify(districtRepository, atLeastOnce()).findDistrictById(property.getDistrictId());
        verify(propertyRepository, atLeastOnce()).addProperty(property);

        assertEquals(propertyExpected, propertyReceived);
    }

    @Test
    public void testAddPropertyWithInvalidDistrict() throws BadRequestException {
        //Arrange
        Property property = Utils.getProperty();
        PropertyDTO propertyDTO = Utils.getPropertyDTO();
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
        Property property = Utils.getProperty();
        District district = new District(3, "Nueva Cordoba", 55);
        PropertyDTO propertyDTO = Utils.getPropertyDTO();
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
        int propertyId = 1;
        Property property = Utils.getProperty();
        PropertyDTO propertyDTO = Utils.getPropertyDTO();
        PropertySquareMettersDTO propertySquareMetters = new PropertySquareMettersDTO(propertyId, propertyDTO.getName(),1500);
        double squareMettersExpected = 1500;

        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(propertyDTO, PropertySquareMettersDTO.class)).thenReturn(propertySquareMetters);
        when(propertyRepository.findPropertyById(propertyId)).thenReturn(property);

        //Act
        PropertySquareMettersDTO propertyReceived = propertyService.calculateSquareMettersById(propertyId);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(propertyId);

        assertEquals(squareMettersExpected, propertyReceived.getSquareMetters());
    }

    @Test
    public void testCalculatePropertyPriceByIdWithValidProperty() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        Property property = Utils.getProperty();
        District district = new District(3, "Nueva Cordoba", 20);
        DistrictDTO districtDTO = new DistrictDTO(3, "Nueva Cordoba", 20);
        PropertyDTO propertyDTO = Utils.getPropertyDTO();
        PropertyPriceDTO propertyExpected = new PropertyPriceDTO(propertyId, propertyDTO.getName(), 30000);
        double priceExpected = 30000;

        when(districtRepository.findDistrictById(property.getDistrictId())).thenReturn(district);
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(district, DistrictDTO.class)).thenReturn(districtDTO);
        when(mapper.map(propertyDTO, PropertyPriceDTO.class)).thenReturn(propertyExpected);
        when(propertyRepository.findPropertyById(propertyId)).thenReturn(property);

        //Act
        PropertyPriceDTO propertyReceived = propertyService.calculatePropertyPriceById(propertyId);

        //Assert
        verify(districtRepository, atLeastOnce()).findDistrictById(property.getDistrictId());
        verify(propertyRepository, atLeastOnce()).findPropertyById(propertyId);

        assertEquals(priceExpected, propertyReceived.getPrice());
    }

    @Test
    public void testCalculateBiggestEnvironmentByIdWithValidProperty() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        Property property = Utils.getProperty();
        PropertyDTO propertyDTO = Utils.getPropertyDTO();
        EnvironmentDTO environmentExpected = new EnvironmentDTO("Habitacion", 20, 30);
        PropertyBiggestEnvironmentDTO propertyExpected = new PropertyBiggestEnvironmentDTO(propertyId, "Las fincas", environmentExpected);

        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(propertyDTO, PropertyBiggestEnvironmentDTO.class)).thenReturn(propertyExpected);
        when(propertyRepository.findPropertyById(propertyId)).thenReturn(property);

        //Act
        PropertyBiggestEnvironmentDTO propertyReceived = propertyService.calculateBiggestEnvironmentById(propertyId);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(propertyId);

        assertEquals(environmentExpected, propertyReceived.getBiggestEnvironment());
    }


    @Test
    public void testCalculateSquareMettersEnvironmentsByIdWithValidProperty() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        Property property = Utils.getProperty();
        PropertyDTO propertyDTO = Utils.getPropertyDTO();
        ArrayList<EnvironmentSquareMetterDTO> environmentsExpected = new ArrayList<>();
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Baño", 15.5, 25.0, 387.5));
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Cocina", 20.5, 25.0, 512.5));
        environmentsExpected.add(new EnvironmentSquareMetterDTO("Habitacion", 20.0, 30.0, 600));
        PropertyEnvironmentSquareMetterDTO propertyExpected = new PropertyEnvironmentSquareMetterDTO(propertyId, "Las fincas", environmentsExpected);

        when(propertyRepository.findPropertyById(propertyId)).thenReturn(property);
        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        when(mapper.map(propertyDTO, PropertyEnvironmentSquareMetterDTO.class)).thenReturn(propertyExpected);
        when(mapper.map(propertyDTO.getEnvironments().get(0), EnvironmentSquareMetterDTO.class)).thenReturn(environmentsExpected.get(0));
        when(mapper.map(propertyDTO.getEnvironments().get(1), EnvironmentSquareMetterDTO.class)).thenReturn(environmentsExpected.get(1));
        when(mapper.map(propertyDTO.getEnvironments().get(2), EnvironmentSquareMetterDTO.class)).thenReturn(environmentsExpected.get(2));
        //Act
        PropertyEnvironmentSquareMetterDTO propertyReceived = propertyService.calculateSquareMettersEnvironmentsById(propertyId);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(propertyId);

        assertEquals(environmentsExpected, propertyReceived.getEnvironments());
    }


    @Test
    public void testFindByIdWithValidId() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        Property property = Utils.getProperty();
        PropertyDTO propertyExpected = Utils.getPropertyDTO();

        when(mapper.map(property, PropertyDTO.class)).thenReturn(propertyExpected);
        when(propertyRepository.findPropertyById(propertyId)).thenReturn(property);

        //Act
        PropertyDTO propertyReceived = propertyService.findPropertyById(propertyId);

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(propertyId);

        assertEquals(propertyExpected, propertyReceived);
    }

    @Test
    public void testFindByIdWithInvalidId() throws BadRequestException {
        //Arrange
        int propertyId = 0;
        BadRequestException exceptionExpected = new BadRequestException("El id ingresado es invalido.");

        //Act
        BadRequestException exceptionReceived = assertThrows(BadRequestException.class, ()-> {
            propertyService.findPropertyById(propertyId);
        });

        //Assert
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
        assertEquals(exceptionExpected.getStatus(), exceptionReceived.getStatus());
    }

    @Test
    public void testFindByIdWithNotExistProperty() throws BadRequestException {
        //Arrange
        int propertyId = 1;
        BadRequestException exceptionExpected = new BadRequestException("La propiedad con el id " + propertyId + " no existe.");

        when(propertyRepository.findPropertyById(propertyId)).thenReturn(null);

        //Act
        BadRequestException exceptionReceived = assertThrows(BadRequestException.class, ()-> {
            propertyService.findPropertyById(propertyId);
        });

        //Assert
        verify(propertyRepository, atLeastOnce()).findPropertyById(propertyId);
        assertEquals(exceptionExpected.getMessage(), exceptionReceived.getMessage());
        assertEquals(exceptionExpected.getStatus(), exceptionReceived.getStatus());
    }

}
