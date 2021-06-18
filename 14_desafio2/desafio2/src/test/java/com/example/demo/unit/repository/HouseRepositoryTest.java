package com.example.demo.unit.repository;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.HouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class HouseRepositoryTest {
    @InjectMocks
    HouseRepository houseRepository;
    @Test
    public void findDistrictByNameHappyPath() throws HouseNotFoundException {
        //arrange
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House expected = new House("Casa 1","Cañiza",environments);
        //act
        House response = houseRepository.findHouseByName(expected.getProp_name());
        //asser
        Assertions.assertEquals(expected,response);
    }
    @Test
    public void addDistrictHappyPath() throws HouseNotFoundException {
        //arrange
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House expected = new House("Casa 1","Cañiza",environments);
        //act
        houseRepository.addHouse(expected);
        House received = houseRepository.findHouseByName(expected.getProp_name());
        //asser
        Assertions.assertEquals(expected,received);
    }
    @Test
    public void findDistrictByNameNullHappyPath() throws DistrictNotFoundException {
        //asser
        Assertions.assertThrows(HouseNotFoundException.class, ()-> houseRepository.findHouseByName("xx"));
    }

}
