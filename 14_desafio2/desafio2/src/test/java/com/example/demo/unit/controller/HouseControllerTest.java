package com.example.demo.unit.controller;

import com.example.demo.controller.HouseController;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.ExistingDistrictException;
import com.example.demo.exception.ExistingHouseException;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.service.IHouseService;
import com.example.demo.service.dto.DistrictDTO;
import com.example.demo.service.dto.HouseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class HouseControllerTest {
    @Mock
    IHouseService iHouseService;
    @InjectMocks
    HouseController houseController;
    @Test
    public void addNewHouseHappyPath() throws DistrictNotFoundException, ExistingHouseException {
        //arrange
        HouseDTO expect = new HouseDTO();
        expect.setProp_name("Casa 1");
        expect.setDistric_name("Cañiza");
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        expect.setEnvironmentArrayList(environments);
        //act
        ResponseEntity<Void> response = houseController.addNewHouse(expect);
        //assert
        Mockito.verify(iHouseService,Mockito.atLeast(1)).addHouse(expect);
        assert (response.getStatusCode()== HttpStatus.OK);
    }@Test
    public void addNewHouseExistingHouseException () throws DistrictNotFoundException, ExistingHouseException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        HouseDTO houseDTO = new HouseDTO(name,"Cañiza",environments);
        Mockito.doThrow(new ExistingHouseException(name)).when(iHouseService).addHouse(houseDTO);
        //act
        //assert
        Assertions.assertThrows(ExistingHouseException.class, ()-> houseController.addNewHouse(houseDTO));
    }

}
