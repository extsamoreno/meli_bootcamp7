package com.example.demo.unit.controller;

import com.example.demo.controller.CalculateController;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.service.IHouseService;
import com.example.demo.service.dto.*;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerTest {
    @Mock
    IHouseService iHouseService;
    @InjectMocks
    CalculateController calculateController;
    @Test
    public void calculateAllRequirementsHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cocina 12.0");
        arrayList.add("Sala 20.0");
        arrayList.add("Habitacion 16.0");
        ResponseHouseDTO responseHouseDTO = new ResponseHouseDTO(name,48,9600,"El ambiente más grande es Sala con un área de 20.0",arrayList);
        when(iHouseService.calculateAllRequirements(name)).thenReturn(responseHouseDTO);
        ResponseEntity<ResponseHouseDTO> expect = new ResponseEntity<>(responseHouseDTO,HttpStatus.OK);
        //act
        ResponseEntity<ResponseHouseDTO> response = calculateController.calculateAllRequirements(name);
        //assert
        //Mockito.verify(iHouseService,Mockito.atLeast(1)).calculateAllRequirements(name);
        Assertions.assertEquals(expect,response);
    }
    @Test
    public void getM2HappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        HouseM2DTO houseM2DTO = new HouseM2DTO(name,48);
        when(iHouseService.getM2(name)).thenReturn(houseM2DTO);
        ResponseEntity<HouseM2DTO> expect = new ResponseEntity<>(houseM2DTO,HttpStatus.OK);
        //act
        ResponseEntity<HouseM2DTO> response = calculateController.getM2(name);
        //assert
        //Mockito.verify(iHouseService,Mockito.atLeast(1)).getM2(name);
        Assertions.assertEquals(expect,response);
    }
    @Test
    public void getPriceHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        HousePriceDTO housePriceDTO = new HousePriceDTO(name,9600);
        when(iHouseService.getPrice(name)).thenReturn(housePriceDTO);
        ResponseEntity<HousePriceDTO> expect = new ResponseEntity<>(housePriceDTO,HttpStatus.OK);
        //act
        ResponseEntity<HousePriceDTO> response = calculateController.getPrice(name);
        //assert
        //Mockito.verify(iHouseService,Mockito.atLeast(1)).getPrice(name);
        Assertions.assertEquals(expect,response);
    }
    @Test
    public void getBiggestEnvironmentHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        HouseBiggestEnvironmentDTO houseBiggestEnvironmentDTO = new HouseBiggestEnvironmentDTO(name,"El ambiente más grande es Sala con un área de 20.0");
        when(iHouseService.getBiggestEnvironment(name)).thenReturn(houseBiggestEnvironmentDTO);
        ResponseEntity<HouseBiggestEnvironmentDTO> expect = new ResponseEntity<>(houseBiggestEnvironmentDTO,HttpStatus.OK);
        //act
        ResponseEntity<HouseBiggestEnvironmentDTO> response = calculateController.getBiggestEnvironment(name);
        //assert
        //Mockito.verify(iHouseService,Mockito.atLeast(1)).getBiggestEnvironment(name);
        Assertions.assertEquals(expect,response);
    }
    @Test
    public void getListEnvironmentHappyPath() throws HouseNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cocina 12.0");
        arrayList.add("Sala 20.0");
        arrayList.add("Habitacion 16.0");
        HouseListEnvironmentDTO houseListEnvironmentDTO = new HouseListEnvironmentDTO(name,arrayList);
        when(iHouseService.getListEnvironmentWhitM2(name)).thenReturn(houseListEnvironmentDTO);
        ResponseEntity<HouseListEnvironmentDTO> expect = new ResponseEntity<>(houseListEnvironmentDTO,HttpStatus.OK);
        //act
        ResponseEntity<HouseListEnvironmentDTO> response = calculateController.getListEnvironment(name);
        //assert
        //Mockito.verify(iHouseService,Mockito.atLeast(1)).getListEnvironmentWhitM2(name);
        Assertions.assertEquals(expect,response);
    }
}
