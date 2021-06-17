package com.example.challenge_2.service;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.models.Environment;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import com.example.challenge_2.service.dto.EnvironmentSquareMetersDTO;
import com.example.challenge_2.service.mapper.EnviromentMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnvironmentServiceTest {

    @InjectMocks
    EnvironmentService environmentService;

    @Test
    public void calculateSquareMetersTest() {
        //Arrange
        Environment environment = TestUtilsGenerator.getEnvironmentTest();

        //Act
        double result = environmentService.calculateSquareMeters(environment);

        //Assert
        assertEquals((environment.getHeight() * environment.getWidth()), result);
    }

    @Test
    public void getBiggestEnviroment() {
        //Arrange
        List<Environment> environments = TestUtilsGenerator.getEnvironmentListTest();
        EnvironmentDTO environmentMaxValuesDTO = new EnvironmentDTO("Kitchen", 30d, 5d);

        //Act
        EnvironmentDTO result = environmentService.getBiggestEnviroment(environments);
        //Assert

        assertEquals(environmentMaxValuesDTO, result);
    }

    @Test
    public void getSquareMetersEachEnvironment() {
        //Arrange
        List<Environment> environments = TestUtilsGenerator.getEnvironmentListTest();
        List<EnvironmentSquareMetersDTO> environmentSquareMetersDTOS = TestUtilsGenerator.getEnvironmentSquareMetersDTOTest();

        //Act
        List<EnvironmentSquareMetersDTO> result = environmentService.getSquareMetersEachEnvironment(environments);

        //Assert
        assertTrue(CollectionUtils.isEqualCollection(environmentSquareMetersDTOS, result));
    }
}
