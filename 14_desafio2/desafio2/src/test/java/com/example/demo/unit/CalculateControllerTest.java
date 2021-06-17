package com.example.demo.unit;

import com.example.demo.controller.CalculateController;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.service.IHouseService;
import com.example.demo.service.dto.HouseDTO;
import com.example.demo.service.dto.HouseM2DTO;
import com.example.demo.service.dto.HousePriceDTO;
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
import java.util.List;
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
        HouseDTO houseDTO = new HouseDTO(name,48,9600,"El ambiente más grande es Sala con un área de 20.0",arrayList);
        when(iHouseService.calculateM2(name)).thenReturn(houseDTO.getSquareMeter());
        when(iHouseService.calculatePrice(name)).thenReturn(houseDTO.getPrice());
        when(iHouseService.biggestEnvironment(name)).thenReturn(houseDTO.getBiggestEnvironment());
        when(iHouseService.environmentM2(name)).thenReturn(houseDTO.getListEnvironment());
        ResponseEntity<HouseDTO> expect = new ResponseEntity<>(houseDTO,HttpStatus.OK);
        //act
        ResponseEntity<HouseDTO> response = calculateController.calculateAllRequirements(name);
        //assert
        Assertions.assertEquals(expect,response);
    }
    @Test
    public void getM2HappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        HouseM2DTO houseM2DTO = new HouseM2DTO(name,48);
        when(iHouseService.calculateM2(name)).thenReturn(houseM2DTO.getSquareMeter());
        ResponseEntity<HouseM2DTO> expect = new ResponseEntity<>(houseM2DTO,HttpStatus.OK);
        //act
        ResponseEntity<HouseM2DTO> response = calculateController.getM2(name);
        //assert
        Assertions.assertEquals(expect,response);
    }
    @Test
    public void getPriceHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        HousePriceDTO housePriceDTO = new HousePriceDTO(name,9600);
        when(iHouseService.calculatePrice(name)).thenReturn(housePriceDTO.getPrice());
        ResponseEntity<HousePriceDTO> expect = new ResponseEntity<>(housePriceDTO,HttpStatus.OK);
        //act
        ResponseEntity<HousePriceDTO> response = calculateController.getPrice(name);
        //assert
        Assertions.assertEquals(expect,response);
    }
}
