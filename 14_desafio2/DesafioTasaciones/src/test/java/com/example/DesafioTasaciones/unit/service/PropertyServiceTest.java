package com.example.DesafioTasaciones.unit.service;

import com.example.DesafioTasaciones.dtos.PropertyDTO;
import com.example.DesafioTasaciones.dtos.ResponseDTO;
import com.example.DesafioTasaciones.dtos.RoomDTO;
import com.example.DesafioTasaciones.exceptions.DistrictNotFound;
import com.example.DesafioTasaciones.models.District;
import com.example.DesafioTasaciones.models.Property;
import com.example.DesafioTasaciones.repository.IPropertyRepository;
import com.example.DesafioTasaciones.services.PropertyService;
import com.example.DesafioTasaciones.util.TestUtilGenerator;
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
    ModelMapper mapper = new ModelMapper();

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    PropertyService propertyService;


    @Test
    public void createPropertyWithExistingDistrict() {
        //Arrange
        String districtName = "Capital";
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO(districtName);
        Property property = mapper.map(propertyDTO, Property.class);
        Mockito.when(iPropertyRepository.findDistrictByName(districtName)).thenReturn(new District("Capital",200.0));
        Mockito.when(modelMapper.map(propertyDTO, Property.class)).thenReturn(property);

        //Act
        propertyService.createProperty(propertyDTO);

        //Assert
        Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).saveProperty(property);
        Mockito.verify(iPropertyRepository, Mockito.atLeastOnce()).findDistrictByName(districtName);
        Assertions.assertEquals(property.getDistrict().getName(),districtName);
    }

    @Test
    public void createPropertyWithNonExistingDistrict() {
        //Arrange
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("Barrio 1");

        //Act & Assert
        Assertions.assertThrows(DistrictNotFound.class, () -> propertyService.createProperty(propertyDTO));
    }

    @Test
    public void getAllProperties() {
        //Arrange
        List<Property> properties = TestUtilGenerator.getProperties();

        Mockito.when(iPropertyRepository.getAllProperties()).thenReturn(properties);

        //Act
        List<PropertyDTO> foundProperties = propertyService.getAllProperties();

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getAllProperties();
    }

    @Test
    public void propertyTotalSquareMeters() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        //Act
        ResponseDTO response = propertyService.totalSquareMeters(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(40.0,response.getTotalSquareMeters());
    }

    @Test
    public void propertyValue() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        //Act
        ResponseDTO response = propertyService.propertyValue(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(8000.0,response.getPropertyValue());
    }

    @Test
    public void getBiggestEnvironment() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        RoomDTO room = mapper.map(property.getRooms().get(0), RoomDTO.class);
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);
        Mockito.when(modelMapper.map(property.getRooms().get(0),RoomDTO.class)).thenReturn(room);

        //Act
        ResponseDTO response = propertyService.largestEnvironment(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(room,response.getLargestEnvironment());
    }

    @Test
    public void roomsSquareMeters() {
        //Arrange
        Property property = TestUtilGenerator.getProperty();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        //Act
        ResponseDTO response = propertyService.roomsSquareMeters(property.getId());

        //Assert
        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).findPropertyById(property.getId());
        Assertions.assertEquals(30.0,response.getRoomsSquareMeters().get(0).getSquareMeters());
    }
}
