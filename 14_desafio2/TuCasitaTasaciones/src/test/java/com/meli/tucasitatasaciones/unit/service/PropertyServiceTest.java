package com.meli.tucasitatasaciones.unit.service;

import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.exception.DistrictNotFoundException;
import com.meli.tucasitatasaciones.model.District;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.district.IDistrictRepository;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import com.meli.tucasitatasaciones.service.property.PropertyService;
import com.meli.tucasitatasaciones.util.TestUtilGenerator;
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
    IPropertyRepository iPropertyRepository;

    @Mock
    IDistrictRepository iDistrictRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void createPropertyWithExistingDistrict() {
        //Arrange
        String districtName = "Alto Alberdi";
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO(districtName);
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iDistrictRepository.findDistrictByName(districtName)).thenReturn(new District("Alto Alberdi",150.0));
        Mockito.when(modelMapper.map(propertyDTO,Property.class)).thenReturn(property);

        //Act
        propertyService.createProperty(propertyDTO);

        //Assert
        Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).saveProperty(property);
        Mockito.verify(iDistrictRepository, Mockito.atLeastOnce()).findDistrictByName(districtName);
        Assertions.assertEquals(property.getDistrict().getName(),districtName);
    }

    @Test
    public void createPropertyWithNonExistingDistrict() {
        //Arrange
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("Distrito 1");

        //Act & Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.createProperty(propertyDTO));
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<Property> properties = TestUtilGenerator.getProperties();
        Mockito.when(iPropertyRepository.getAllProperties()).thenReturn(properties);

        //Act
        propertyService.getAllProperties();

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getAllProperties();
    }
}
