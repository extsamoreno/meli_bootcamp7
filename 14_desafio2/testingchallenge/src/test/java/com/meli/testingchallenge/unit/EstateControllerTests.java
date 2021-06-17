package com.meli.testingchallenge.unit;

import com.meli.testingchallenge.controllers.EstateController;
import com.meli.testingchallenge.dtos.*;
import com.meli.testingchallenge.exceptions.DistrictNotFoundException;
import com.meli.testingchallenge.exceptions.ExistentDistrictNameException;
import com.meli.testingchallenge.services.EstateService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EstateControllerTests {

    @Mock
    EstateService service;

    @InjectMocks
    EstateController controller;

    private String districtName;
    private DistrictDTO districtDto;
    private EstateAssessmentDTO expected;
    private EstateDTO estateDto;

    @BeforeEach
    public void init(){
        String propName = "House1";
        districtName= "District1";
        String environmentName1 = "bigger";
        String environmentName2 = "medium";
        String environmentName3 = "smaller";
        districtDto = new DistrictDTO(districtName, 2.0);
        EnvironmentDTO environment1 = new EnvironmentDTO(environmentName1, 2.0, 2.0);
        EnvironmentDTO environment2 = new EnvironmentDTO(environmentName2, 2.0, 1.0);
        EnvironmentDTO environment3 = new EnvironmentDTO(environmentName3, 1.0, 1.0);
        List<EnvironmentDTO> environmentList = new ArrayList();
        environmentList.add(environment1);
        environmentList.add(environment2);
        environmentList.add(environment3);
        EnvironmentDTORes environmentResDto1 = new EnvironmentDTORes(environmentName1, 4.0);
        EnvironmentDTORes environmentResDto2 = new EnvironmentDTORes(environmentName2, 2.0);
        EnvironmentDTORes environmentResDto3 = new EnvironmentDTORes(environmentName3, 1.0);
        List<EnvironmentDTORes> environmentResDtosList = new ArrayList();
        environmentResDtosList.add(environmentResDto1);
        environmentResDtosList.add(environmentResDto2);
        environmentResDtosList.add(environmentResDto3);
        expected = new EstateAssessmentDTO(propName, 7.0, 14, environmentResDto1, environmentResDtosList);
        estateDto = new EstateDTO(propName, districtName, environmentList);

    }

    @Test
    public void should_call_assessment_service_and_return_correct_response() throws DistrictNotFoundException {

        // Arrange
        when(service.getAssessment(estateDto)).thenReturn(expected);

        // Act
        ResponseEntity<EstateAssessmentDTO> received = controller.getAssessment(estateDto);

        // Assert
        verify(service, times(1)).getAssessment(estateDto);
        Assert.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assert.assertEquals(expected, received.getBody());

    }

    @Test
    public void should_call_add_district_service_and_return_correct_response() throws ExistentDistrictNameException {

        // Arrange
        String expected = "District was added Successfully";
        when(service.addDistrict(districtDto)).thenReturn(expected);

        // Act
        ResponseEntity<String> received = controller.addDistrict(districtDto);

        // Assert
        verify(service, times(1)).addDistrict(districtDto);
        Assert.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assert.assertEquals(expected, received.getBody());

    }
}
