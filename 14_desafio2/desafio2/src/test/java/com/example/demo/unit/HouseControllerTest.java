package com.example.demo.unit;

import com.example.demo.controller.HouseController;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.service.IHouseService;
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
    public void addNewHouseHappyPath() throws DistrictNotFoundException {
        //arrange
        House expect = new House();
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
    }
}
