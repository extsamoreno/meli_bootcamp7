package com.example.tucasita.unit.service;

import com.example.tucasita.exception.InvalidPropertyException;
import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.EnvironmentDTO;
import com.example.tucasita.dto.PropertyDTO;
import com.example.tucasita.dto.ResponseDTO;
import com.example.tucasita.model.District;
import com.example.tucasita.model.Environment;
import com.example.tucasita.model.Property;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.PropertyDAO;
import com.example.tucasita.service.PropertyServiceImple;
import org.junit.jupiter.api.Assertions;
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
public class PropertyServiceTests {
    @Mock
    PropertyDAO propertyDAO;

    @Mock
    DistrictDAO districtDAO;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    PropertyServiceImple propertyService;

    @Test
    public void testAddOnePropertyNewPropertyExistingDistrict() {
        //ARRANGE
        String districtName = "Caballito";

        List<EnvironmentDTO> propertyEnvironmentsDTO = new ArrayList<>();
        propertyEnvironmentsDTO.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironmentsDTO.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newPropertyDTO = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironmentsDTO);

        List<Environment> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new Environment("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new Environment("Comedor", 15.00, 20.00, null));
        Property newProperty = new Property(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        ResponseDTO responseExpected = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");

        Mockito.when(districtDAO.findByName(districtName)).thenReturn(new District("Caballito", 100.00));
        Mockito.when(modelMapper.map(newPropertyDTO, Property.class)).thenReturn(newProperty);
        Mockito.doNothing().when(propertyDAO).create(newProperty);

        //ACT
        ResponseDTO responseReceived = propertyService.addOneProperty(newPropertyDTO);

        //ASSERT
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).create(newProperty);
        Assertions.assertEquals(responseExpected, responseReceived);
    }

    @Test
    public void testAddOnePropertyNewPropertyInexistingDistrict() {
        //ARRANGE
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(6, "Torre Triunvirato", "Villa Urquiza", propertyEnvironments);

        //ACT

        //ASSERT
        Assertions.assertThrows(InvalidPropertyException.class, () -> propertyService.addOneProperty(newProperty));
    }

    @Test
    public void testCalculatePropertyTotalSquareMeters() {
        //ARRANGE
        int idProperty = 5;

        List<EnvironmentDTO> propertyEnvironmentsDTO = new ArrayList<>();
        EnvironmentDTO environmentDTO = new EnvironmentDTO("Living", 10.00, 20.00, null);
        propertyEnvironmentsDTO.add(environmentDTO);
        PropertyDTO newPropertyDTO = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironmentsDTO);

        List<Environment> propertyEnvironments = new ArrayList<>();
        Environment environment = new Environment("Living", 10.00, 20.00, null);
        propertyEnvironments.add(environment);
        Property newProperty = new Property(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        ResponseDTO responseExpected = new ResponseDTO(200, "La propiedad con ID 5 tiene un total de 200.0 metros cuadrados.");

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(newProperty);
        Mockito.when(modelMapper.map(newProperty, PropertyDTO.class)).thenReturn(newPropertyDTO);
        Mockito.when(modelMapper.map(environment, EnvironmentDTO.class)).thenReturn(environmentDTO);

        //ACT
        ResponseDTO responseReceived = propertyService.calculatePropertyTotalSquareMeters(idProperty);

        //ASSERT
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).findById(idProperty);
        Assertions.assertEquals(responseExpected, responseReceived);
    }

    @Test
    public void testCalculatePropertyPrice() {
        //ARRANGE
        int idProperty = 5;
        String districtName = "Caballito";

        List<EnvironmentDTO> propertyEnvironmentsDTO = new ArrayList<>();
        EnvironmentDTO environmentDTO = new EnvironmentDTO("Living", 10.00, 20.00, null);
        propertyEnvironmentsDTO.add(environmentDTO);
        PropertyDTO newPropertyDTO = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironmentsDTO);

        List<Environment> propertyEnvironments = new ArrayList<>();
        Environment environment = new Environment("Living", 10.00, 20.00, null);
        propertyEnvironments.add(environment);
        Property newProperty = new Property(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        District district = new District("Caballito", 100.00);
        DistrictDTO districtDTO = new DistrictDTO("Caballito", 100.0);

        ResponseDTO responseExpected = new ResponseDTO(200, "La propiedad con ID 5 tiene un valor de 20000.0 U$S.");

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(newProperty);
        Mockito.when(modelMapper.map(newProperty, PropertyDTO.class)).thenReturn(newPropertyDTO);
        Mockito.when(districtDAO.findByName(districtName)).thenReturn(new District("Caballito", 100.00));
        Mockito.when(modelMapper.map(district, DistrictDTO.class)).thenReturn(districtDTO);
        Mockito.when(modelMapper.map(environment, EnvironmentDTO.class)).thenReturn(environmentDTO);

        //ACT
        ResponseDTO responseReceived = propertyService.calculatePropertyPrice(idProperty);

        //ASSERT
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).findById(idProperty);
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).findByName(districtName);
        Assertions.assertEquals(responseExpected, responseReceived);
    }

    @Test
    public void testGetBiggestEnvironment() {
        //ARRANGE
        int idProperty = 5;

        List<EnvironmentDTO> propertyEnvironmentsDTO = new ArrayList<>();
        EnvironmentDTO environmentDTO = new EnvironmentDTO("Living", 10.00, 20.00, null);
        propertyEnvironmentsDTO.add(environmentDTO);
        PropertyDTO propertyDTO = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironmentsDTO);

        List<Environment> propertyEnvironments = new ArrayList<>();
        Environment environment = new Environment("Living", 10.00, 20.00, null);
        propertyEnvironments.add(environment);
        Property property = new Property(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        ResponseDTO responseExpected = new ResponseDTO(200, "El ambiente más grande de la propiedad con ID 5 es el ambiente Living con un total de 200.0 metros cuadrados.");

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(property);
        Mockito.when(modelMapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        Mockito.when(modelMapper.map(environment, EnvironmentDTO.class)).thenReturn(environmentDTO);

        //ACT
        ResponseDTO responseReceived = propertyService.getBiggestEnvironment(idProperty);

        //ASSERT
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).findById(idProperty);
        Assertions.assertEquals(responseExpected, responseReceived);
    }

    @Test
    public void testCalculateEnvironmentsSquareMeters() {
        //ARRANGE
        int idProperty = 5;

        List<EnvironmentDTO> propertyEnvironmentsDTO = new ArrayList<>();
        EnvironmentDTO environmentDTO = new EnvironmentDTO("Living", 10.00, 20.00, null);
        propertyEnvironmentsDTO.add(environmentDTO);
        PropertyDTO propertyDTO = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironmentsDTO);

        List<Environment> propertyEnvironments = new ArrayList<>();
        Environment environment = new Environment("Living", 10.00, 20.00, null);
        propertyEnvironments.add(environment);
        Property property = new Property(5, "Torre Rivadavia", "Caballito", propertyEnvironments);

        List<EnvironmentDTO> expectedEnvironments = new ArrayList<>();
        expectedEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, 200.0));

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(property);
        Mockito.when(modelMapper.map(property, PropertyDTO.class)).thenReturn(propertyDTO);
        Mockito.when(modelMapper.map(environment, EnvironmentDTO.class)).thenReturn(environmentDTO);

        //ACT
        List<EnvironmentDTO> receivedEnvironments = propertyService.calculateEnvironmentsSquareMeters(idProperty);

        //ASSERT
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).findById(idProperty);
        Assertions.assertEquals(expectedEnvironments, receivedEnvironments);
    }
}
