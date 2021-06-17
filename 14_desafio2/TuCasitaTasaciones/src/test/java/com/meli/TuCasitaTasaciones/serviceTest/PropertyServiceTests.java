package com.meli.TuCasitaTasaciones.serviceTest;

import com.meli.TuCasitaTasaciones.model.EnvironmentAreaResponseDTO;
import com.meli.TuCasitaTasaciones.model.EnvironmentDTO;
import com.meli.TuCasitaTasaciones.model.HouseDTO;
import com.meli.TuCasitaTasaciones.repository.IPropertyDAO;
import com.meli.TuCasitaTasaciones.service.PropertyService;
import com.meli.TuCasitaTasaciones.util.TestUtilsGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {

    @Mock
    IPropertyDAO propertyDAO;

    @InjectMocks
    PropertyService service;

    @Test
    public void calculateAreaWellCalculated() {
        // arrange
        List<EnvironmentDTO> env = TestUtilsGenerator.getEnvironments();

        // act
        double received = service.calculateArea(env);

        // assert
        Assertions.assertEquals(received, 1219.0);
    }
//

    @Test
    public void calculatePriceHappyPath() {
        // arrange
        HouseDTO hDTO = TestUtilsGenerator.getHouseDTO();
        HashMap<String, Double> hm = TestUtilsGenerator.getDistrictsList();
        when(propertyDAO.getDistrictList()).thenReturn(hm);

        // act
        double received = service.calculatePrice(hDTO);

        // assert
        //verify(propertyDAO, atLeastOnce()).getPropertyList();
        Assertions.assertEquals(received, 5995000);
    }

    @Test
    public void environmentsBiggestHappyPath() {
        // arrange
        List<EnvironmentDTO> env = TestUtilsGenerator.getEnvironments();
        EnvironmentAreaResponseDTO expected = TestUtilsGenerator.getEnvironmentAreaResponseDTO();

        // act
        EnvironmentAreaResponseDTO received = service.environmentsBiggest(env);


        // assert
        Assertions.assertEquals(received, expected);

    }

    @Test
    public void environmentAreaHappyPath() {
        // arrange
        List<EnvironmentDTO> env = TestUtilsGenerator.getEnvironments();

        List<EnvironmentAreaResponseDTO> expected = TestUtilsGenerator.getListEnvironmentAreaResponseDTO();

        // act
        List<EnvironmentAreaResponseDTO> received = service.environmentArea(env);

        // assert

        Assertions.assertEquals(received, expected);
    }
}
