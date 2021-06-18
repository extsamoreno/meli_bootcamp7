package com.tucasitaTasaciones.unit.service;

import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.exceptions.DistrictNotFoundException;
import com.tucasitaTasaciones.model.District;
import com.tucasitaTasaciones.model.Property;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import com.tucasitaTasaciones.repository.IPropertyRepository;
import com.tucasitaTasaciones.service.PropertyService;
import com.tucasitaTasaciones.unit.TestUtilGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {
    ModelMapper mapper = new ModelMapper();

    @Mock
    ModelMapper modelMapper;

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    IDistrictRepository districtRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void addNewPropertyWithExistingDistrict() {
        String districtName = "Snohomish";
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO(districtName);
        Property property = mapper.map(propertyDTO,Property.class);
        Mockito.when(districtRepository.findDistrictByName(districtName))
                .thenReturn(new District("Snohomish",2300.0));
        Mockito.when(modelMapper.map(propertyDTO,Property.class)).thenReturn(property);

        propertyService.addNewProperty(propertyDTO);

        Mockito.verify(propertyRepository, Mockito.atLeastOnce()).addNewProperty(property);
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findDistrictByName(districtName);
        Assertions.assertEquals(property.getDistrict().getDistrict_name(),districtName);
    }

    @Test
    public void addNewPropertyWithException() {
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("Washington");

        Assertions.assertThrows(DistrictNotFoundException.class, () -> propertyService.addNewProperty(propertyDTO));
    }


    @Test
    public void getProperties() {
        List<Property> properties = TestUtilGenerator.getProperties();
        when(propertyRepository.getProperties()).thenReturn(properties);

        List<PropertyDTO> foundProperties = propertyService.getProperties();

        Mockito.verify(propertyRepository,Mockito.atLeastOnce()).getProperties();
    }

}

