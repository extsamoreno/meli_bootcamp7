package com.desafio2.Controller;

import com.desafio2.DTO.EnvironmentDTO;
import com.desafio2.Model.Environment;
import com.desafio2.Model.Property;
import com.desafio2.Service.IPropertyService;
import com.desafio2.Utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @Test
    public void createProperty() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");

        // act
        propertyController.createProperty(property);

        // assert
        verify(iPropertyService, atLeastOnce()).create(property);
    }

    @Test
    public void getTotalSqaureMeters() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");
        Mockito.when(iPropertyService.getTotalSquareMeters(property.getProp_name())).thenReturn(188D);

        // act
        propertyController.getTotalSqaureMeters(property.getProp_name());

        // assert
        Mockito.verify(iPropertyService, atLeastOnce()).getTotalSquareMeters(property.getProp_name());
    }

    @Test
    public void getPropertyPrice() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");
        Mockito.when(iPropertyService.getPropertyPrice(property.getProp_name())).thenReturn(188D);

        // act
        propertyController.getPropertyPrice(property.getProp_name());

        // assert
        Mockito.verify(iPropertyService, atLeastOnce()).getPropertyPrice(property.getProp_name());
    }

    @Test
    public void getBiggestEnvironment() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");
        Environment environment = TestUtils.createEnvironment();
        Mockito.when(iPropertyService.getBiggestEnvironment(property.getProp_name())).thenReturn(environment);

        // act
        propertyController.getBiggestEnvironment(property.getProp_name());

        // assert
        Mockito.verify(iPropertyService, atLeastOnce()).getBiggestEnvironment(property.getProp_name());
    }

    @Test
    public void getEnvironmentSquareMeters() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");
        List<EnvironmentDTO> environments = TestUtils.getEnvironments();
        Mockito.when(iPropertyService.getEnvironmentListWithSquareMeters(property.getProp_name())).thenReturn(environments);

        // act
        propertyController.getEnvironmentsSquareMeters(property.getProp_name());

        // assert
        Mockito.verify(iPropertyService, atLeastOnce()).getEnvironmentListWithSquareMeters(property.getProp_name());
    }
}
