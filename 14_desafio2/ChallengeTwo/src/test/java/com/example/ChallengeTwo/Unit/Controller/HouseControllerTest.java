package com.example.ChallengeTwo.Unit.Controller;

import com.example.ChallengeTwo.Util.TestUtilsGenerator;
import com.example.ChallengeTwo.controller.HouseController;
import com.example.ChallengeTwo.db.HousesDB;
import com.example.ChallengeTwo.dto.*;
import com.example.ChallengeTwo.exception.ProgramException;
import com.example.ChallengeTwo.repository.IHouseRepository;
import com.example.ChallengeTwo.service.HouseServiceImple;
import com.example.ChallengeTwo.service.IHouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HouseControllerTest {

    @Mock
    IHouseService iHouseService;
    @InjectMocks
    HouseController houseController;

    @Test
    public void createHouseSuccesfullTest() throws ProgramException {
        //arrange
        HouseDTO house = TestUtilsGenerator.getHouseDTOWith4Environments("House1","Chapinero");
        //act
        houseController.createHouse(house);
        //assert
        verify(iHouseService,atLeastOnce()).createNewHouse(house);
    }

   @Test
    public void createDistrictTest() throws ProgramException {
        //arrange
        DistrictDTO districtDTO = new DistrictDTO("center",150.0);
        //act
        houseController.createDistrict(districtDTO);
        //assert
        verify(iHouseService,atLeastOnce()).createNewDistrict(districtDTO);
    }
    @Test
    public void getTotalAreaHouseTest() throws ProgramException {
        //arrange
        String houseName="House1";
        HouseTotalAreaDTO houseExpec = new HouseTotalAreaDTO(houseName, 5000);
        when(iHouseService.getTotalAreaHouse(houseName)).thenReturn(houseExpec);
        // act
        ResponseEntity<HouseTotalAreaDTO> houseReceived = houseController.getTotalAreaHouse(houseName);
        // assert
        verify(iHouseService, atLeastOnce()).getTotalAreaHouse(houseName);
        assertEquals(HttpStatus.OK,houseReceived.getStatusCode());
        assertEquals(houseExpec.getTotalArea(),houseReceived.getBody().getTotalArea());

    }
    @Test
    public void getTotalValueHouseTest() throws ProgramException {
        //arrange
        String houseName="House2";
        HouseTotalValueDTO houseExpect = new HouseTotalValueDTO(houseName,2,45.5,3500.0);
        when(iHouseService.getTotalValueHouse(houseName)).thenReturn(houseExpect);
        //act

        ResponseEntity<HouseTotalValueDTO> houseReceived = houseController.getTotalValueHouse(houseName);
        //assert
        verify(iHouseService, atLeastOnce()).getTotalValueHouse(houseName);
        assertEquals(HttpStatus.OK,houseReceived.getStatusCode());
        assertEquals(houseExpect.getPrice(),houseReceived.getBody().getPrice());
    }
    @Test
    public void getBiggestEnvironmentTest() throws ProgramException {
        //arrange
        String houseName="House2";
        BiggestEnvironmentDTO environmentExpect = new BiggestEnvironmentDTO(houseName,"living-room",65.3);
        when(iHouseService.getBiggestEnviroment(houseName)).thenReturn(environmentExpect);
        //act
        ResponseEntity<BiggestEnvironmentDTO> environmentReceived = houseController.getBiggestEnvironment(houseName);
        //assert
        verify(iHouseService, atLeastOnce()).getBiggestEnviroment(houseName);
        assertEquals(HttpStatus.OK,environmentReceived.getStatusCode());
        assertEquals(environmentExpect.toString(),environmentReceived.getBody().toString());

    }
    @Test
    public void getAllEnvironmentsAreaTest() throws ProgramException {
        //arrange
        String houseName="House2";
        List<EnvironmentAreaDTO> environmentExpect = TestUtilsGenerator.getListENvironmentDTO();
        when(iHouseService.getAllEnviromentsArea(houseName)).thenReturn(environmentExpect);
        //act
        ResponseEntity<List<EnvironmentAreaDTO >> environmentReceived = houseController.getAllEnviromentsArea(houseName);
        //assert
        verify(iHouseService, atLeastOnce()).getAllEnviromentsArea(houseName);
        assertEquals(HttpStatus.OK,environmentReceived.getStatusCode());
        assertEquals(environmentExpect,environmentReceived.getBody());
    }

}
