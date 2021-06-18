package com.example.tucasita.unit.service;

import com.example.tucasita.exception.DistrictNotFoundException;
import com.example.tucasita.exception.InvalidPropertyException;
import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.EnvironmentDTO;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.DistrictDAOImple;
import com.example.tucasita.repository.PropertyDAO;
import com.example.tucasita.repository.PropertyDAOImple;
import com.example.tucasita.service.DistrictServiceImple;
import com.example.tucasita.service.PropertyServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {
    @Mock
    PropertyDAO propertyDAO;

    @Mock
    DistrictDAO districtDAO;

    //@Mock
    //PropertyRepository propertyRepository;

    @InjectMocks
    PropertyServiceImple propertyService;

    @Test
    public void testAddOnePropertyNewPropertyExistingDistrict() {
        //ARRANGE
        String districtName = "Caballito";
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO responseExpected = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");

        Mockito.when(districtDAO.findByName(districtName)).thenReturn(new DistrictDTO("Caballito", 100.00));
        Mockito.doNothing().when(propertyDAO).create(newProperty);

        //ACT
        ResponseDTO responseReceived = propertyService.addOneProperty(newProperty);

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
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO responseExpected = new ResponseDTO(200, "La propiedad con ID 5 tiene un total de 500.0 metros cuadrados.");

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(newProperty);

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
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO responseExpected = new ResponseDTO(200, "La propiedad con ID 5 tiene un valor de 50000.0 U$S.");

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(newProperty);
        Mockito.when(districtDAO.findByName(districtName)).thenReturn(new DistrictDTO("Caballito", 100.00));

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
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO responseExpected = new ResponseDTO(200, "El ambiente más grande de la propiedad con ID 5 es el ambiente Comedor con un total de 300.0 metros cuadrados.");

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(newProperty);

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
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO newProperty = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        List<EnvironmentDTO> expectedEnvironments = new ArrayList<>();
        expectedEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, 200.0));
        expectedEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, 300.0));

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(newProperty);

        //ACT
        List<EnvironmentDTO> receivedEnvironments = propertyService.calculateEnvironmentsSquareMeters(idProperty);

        //ASSERT
        Mockito.verify(propertyDAO, Mockito.atLeastOnce()).findById(idProperty);
        Assertions.assertEquals(expectedEnvironments, receivedEnvironments);
    }
}
