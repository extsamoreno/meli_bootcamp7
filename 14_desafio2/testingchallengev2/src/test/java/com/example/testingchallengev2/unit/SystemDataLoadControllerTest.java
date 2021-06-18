package com.example.testingchallengev2.unit;

import com.example.testingchallengev2.controller.SystemDataLoadController;
import com.example.testingchallengev2.model.request.DistrictDTO;
import com.example.testingchallengev2.model.request.HouseDTO;
import com.example.testingchallengev2.model.response.DistrictCreatedResponseDTO;
import com.example.testingchallengev2.model.response.DistrictUpdatedResponseDTO;
import com.example.testingchallengev2.model.response.NewHouseResponseDTO;
import com.example.testingchallengev2.service.IAdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.swing.plaf.DesktopPaneUI;

@ExtendWith(MockitoExtension.class)
public class SystemDataLoadControllerTest {

    @Mock
    IAdminService iAdminService;

    @InjectMocks
    SystemDataLoadController systemDataLoadController;

    @Test
    public void newDistrictPostTest()
    {
        DistrictDTO district = new DistrictDTO("Acosta", 100.33);
        DistrictCreatedResponseDTO response = new DistrictCreatedResponseDTO(
                district.getName(), "District created successfully."
        );
        Mockito.when(iAdminService.newDistrict(district)).thenReturn(response);
        ResponseEntity<DistrictCreatedResponseDTO> expected = new ResponseEntity<>(
                response, HttpStatus.OK
        );

        ResponseEntity<DistrictCreatedResponseDTO> received =
                systemDataLoadController.createDistrict(district);

        Mockito.verify(iAdminService, Mockito.atLeastOnce()).newDistrict(district);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void newDistrictPostFailedTest()
    {
        DistrictDTO district = new DistrictDTO("Acosta", 100.33);
        DistrictCreatedResponseDTO response = new DistrictCreatedResponseDTO(
                district.getName(), "Can't create district. May be already exist."
        );
        Mockito.when(iAdminService.newDistrict(district)).thenReturn(response);
        ResponseEntity<DistrictCreatedResponseDTO> expected = new ResponseEntity<>(
                response, HttpStatus.OK
        );

        ResponseEntity<DistrictCreatedResponseDTO> received =
                systemDataLoadController.createDistrict(district);

        Mockito.verify(iAdminService, Mockito.atLeastOnce()).newDistrict(district);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void updateDistrictTest()
    {
        DistrictDTO district = new DistrictDTO("Acosta", 100.33);
        DistrictUpdatedResponseDTO response = new DistrictUpdatedResponseDTO(
                district.getName(), "District updated successfully."
        );
        Mockito.when(iAdminService.updateDistrict(district)).thenReturn(response);
        ResponseEntity<DistrictUpdatedResponseDTO> expected = new ResponseEntity<>(
                response, HttpStatus.OK
        );

        ResponseEntity<DistrictUpdatedResponseDTO> received =
                systemDataLoadController.updateDistrict(district);

        Mockito.verify(iAdminService, Mockito.atLeastOnce()).updateDistrict(district);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void updateDistrictFailTest()
    {
        DistrictDTO district = new DistrictDTO("Acosta", 100.33);
        DistrictUpdatedResponseDTO response = new DistrictUpdatedResponseDTO(
                district.getName(), "Can't update district. May be it doesn't exist."
        );
        Mockito.when(iAdminService.updateDistrict(district)).thenReturn(response);
        ResponseEntity<DistrictUpdatedResponseDTO> expected = new ResponseEntity<>(
                response, HttpStatus.OK
        );

        ResponseEntity<DistrictUpdatedResponseDTO> received =
                systemDataLoadController.updateDistrict(district);

        Mockito.verify(iAdminService, Mockito.atLeastOnce()).updateDistrict(district);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void newHousePostTest()
    {
        HouseDTO newHouse = TestUtils.getHouseDTOWithName("Casa 1");
        NewHouseResponseDTO response = new NewHouseResponseDTO(
                newHouse.getName(), "House created successfully.",
                newHouse);
        Mockito.when(iAdminService.createHouse(newHouse)).thenReturn(response);
        ResponseEntity<NewHouseResponseDTO> expected = new ResponseEntity<>(
                response, HttpStatus.OK
        );

        ResponseEntity<NewHouseResponseDTO> received =
                systemDataLoadController.createHouse(newHouse);

        Mockito.verify(iAdminService, Mockito.atLeastOnce()).createHouse(newHouse);
        Assertions.assertEquals(expected, received);
    }

    @Test
    public void newHousePostFailedTest()
    {
        HouseDTO newHouse = TestUtils.getHouseDTOWithName("Casa 1");
        NewHouseResponseDTO response = new NewHouseResponseDTO(
                newHouse.getName(), "Can't create house. May be already exist.",
                newHouse);
        Mockito.when(iAdminService.createHouse(newHouse)).thenReturn(response);
        ResponseEntity<NewHouseResponseDTO> expected = new ResponseEntity<>(
                response, HttpStatus.OK
        );

        ResponseEntity<NewHouseResponseDTO> received =
                systemDataLoadController.createHouse(newHouse);

        Mockito.verify(iAdminService, Mockito.atLeastOnce()).createHouse(newHouse);
        Assertions.assertEquals(expected, received);
    }
}
