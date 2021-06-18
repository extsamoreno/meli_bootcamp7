package com.example.demo.unit.service;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IHouseRepository;
import com.example.demo.service.HouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {
    @Mock
    IHouseRepository iHouseRepository;
    @Mock
    IDistrictRepository iDistrictRepository;
    @InjectMocks
    HouseService houseService;
    @Test
    public void calculateM2HappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        double expect = 48;
        //act
        double received = houseService.calculateM2(house.getProp_name());
        //assert
        Mockito.verify(iHouseRepository, Mockito.atLeast(1)).findHouseByName(name);
        Assertions.assertEquals(expect, received);
    }
    @Test
    public void calculatePriceHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        District district = new District(house.getDistric_name(),200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(district.getDistric_name())).thenReturn(district);
        double expect = 9600;
        //act
        double received = houseService.calculatePrice(house.getProp_name());
        //assert
        Mockito.verify(iHouseRepository, Mockito.atLeast(1)).findHouseByName(name);
        Mockito.verify(iDistrictRepository, Mockito.atLeast(1)).findDistrictByName(district.getDistric_name());
        Assertions.assertEquals(expect, received);
    }
    @Test
    public void biggestEnvironmentHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        District district = new District(house.getDistric_name(),200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(district.getDistric_name())).thenReturn(district);
        String expect = "El ambiente más grande es Sala con un área de 20.0";
        //act
        String received = houseService.biggestEnvironment(house.getProp_name());
        //assert
        Mockito.verify(iHouseRepository, Mockito.atLeast(1)).findHouseByName(name);
        Mockito.verify(iDistrictRepository, Mockito.atLeast(1)).findDistrictByName(district.getDistric_name());
        Assertions.assertEquals(expect, received);
    }
    @Test
    public void environmentM2tHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        ArrayList<String> expect = new ArrayList<>();
        expect.add("Cocina 12.0");
        expect.add("Sala 20.0");
        expect.add("Habitacion 16.0");
        //act
        List<String> received = houseService.environmentM2(house.getProp_name());
        //assert
        Mockito.verify(iHouseRepository, Mockito.atLeast(1)).findHouseByName(name);
        Assertions.assertEquals(expect, received);
    }
    @Test
    public void addHouseHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        District district = new District(house.getDistric_name(),200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(district.getDistric_name())).thenReturn(district);
        //act
        houseService.addHouse(house);
        //assert
        Mockito.verify(iHouseRepository, Mockito.atLeast(1)).findHouseByName(name);
        Mockito.verify(iDistrictRepository, Mockito.atLeast(1)).findDistrictByName(district.getDistric_name());
    }
    @Test
    public void addDistrictHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Compartir";
        District district = new District(name,200);
        Mockito.when(iDistrictRepository.findDistrictByName(name)).thenReturn(district);
        //act
        houseService.addDistrict(district);
        //assert
        Mockito.verify(iDistrictRepository, Mockito.atLeast(1)).findDistrictByName(district.getDistric_name());
    }

}
