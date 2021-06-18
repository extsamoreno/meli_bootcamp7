package com.example.demo.unit.service;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IHouseRepository;
import com.example.demo.service.HouseService;
import com.example.demo.service.dto.*;
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

import static org.mockito.Mockito.when;

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
        HouseDTO houseDTO = new HouseDTO(name,"Compartir",environments);
        House house = new House(name,"Compartir",environments);
        District district = new District(house.getDistric_name(),200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(district.getDistric_name())).thenReturn(district);
        //act
        houseService.addHouse(houseDTO);
        //assert
        Mockito.verify(iHouseRepository, Mockito.atLeast(1)).findHouseByName(name);
        Mockito.verify(iDistrictRepository, Mockito.atLeast(1)).findDistrictByName(district.getDistric_name());
    }
    @Test
    public void addDistrictHappyPath () throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Compartir";
        District district = new District(name,200);
        DistrictDTO districtDTO = new DistrictDTO(name,200);
        Mockito.when(iDistrictRepository.findDistrictByName(name)).thenReturn(district);
        //act
        houseService.addDistrict(districtDTO);
        //assert
        Mockito.verify(iDistrictRepository, Mockito.atLeast(1)).findDistrictByName(district.getDistric_name());
    }
    @Test
    public void calculateAllRequirementsHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        HouseDTO houseDTO = new HouseDTO(name,"Compartir",environments);
        House house = new House(name,"Compartir",environments);
        District district = new District(house.getDistric_name(),200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(district.getDistric_name())).thenReturn(district);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cocina 12.0");
        arrayList.add("Sala 20.0");
        arrayList.add("Habitacion 16.0");
        ResponseHouseDTO expected = new ResponseHouseDTO(name,48,9600,"El ambiente más grande es Sala con un área de 20.0",
                arrayList);
        //act
        ResponseHouseDTO response = houseService.calculateAllRequirements(name);
        // assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void getM2HappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        HouseDTO houseDTO = new HouseDTO(name,"Compartir",environments);
        House house = new House(name,"Compartir",environments);
        HouseM2DTO expected = new HouseM2DTO(name,48);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        //act
        HouseM2DTO response = houseService.getM2(name);
        // assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void getPriceHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        HouseDTO houseDTO = new HouseDTO(name,"Compartir",environments);
        House house = new House(name,"Compartir",environments);
        District district = new District(house.getDistric_name(),200);
        HousePriceDTO expected = new HousePriceDTO(name,9600);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(district.getDistric_name())).thenReturn(district);
        //act
        HousePriceDTO response = houseService.getPrice(name);
        // assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void getBiggestEnvironmentHappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        HouseBiggestEnvironmentDTO expected = new HouseBiggestEnvironmentDTO(name,"El ambiente más grande es Sala con un área de 20.0");
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        //act
        HouseBiggestEnvironmentDTO response = houseService.getBiggestEnvironment(name);
        // assert
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void getListEnvironmentWhitM2HappyPath() throws HouseNotFoundException, DistrictNotFoundException {
        //arrange
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Compartir",environments);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cocina 12.0");
        arrayList.add("Sala 20.0");
        arrayList.add("Habitacion 16.0");
        HouseListEnvironmentDTO expected = new HouseListEnvironmentDTO(name,arrayList);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        //act
        HouseListEnvironmentDTO response = houseService.getListEnvironmentWhitM2(name);
        // assert
        Assertions.assertEquals(expected,response);
    }


}
