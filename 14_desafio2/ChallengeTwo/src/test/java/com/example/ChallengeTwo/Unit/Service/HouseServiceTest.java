package com.example.ChallengeTwo.Unit.Service;

import com.example.ChallengeTwo.Util.TestUtilsGenerator;
import com.example.ChallengeTwo.dto.BiggestEnvironmentDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.exception.HouseNameNotFoundException;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;
import com.example.ChallengeTwo.repository.IHouseRepository;
import com.example.ChallengeTwo.service.HouseServiceImple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {
    @Mock
    IHouseRepository iHouseRepository;

    @InjectMocks
    HouseServiceImple houseServiceImple;

    @Test
    public void calculateTotalAreaTest(){
        //arrange
        House house= TestUtilsGenerator.getHouseWith4Environments("House");
        Double expected=0.0;

        for (Environment environment:house.getListEnvironment()){
            expected+=environment.getTotalArea();
        }
        //act
        Double received= houseServiceImple.calculateTotalArea(house);
        //assert
        assertEquals(received,expected);
    }
    @Test
    public void calculateTotalValueTest(){
        //arrange
        House house= TestUtilsGenerator.getHouseWith4Environments("House");
        double expected = houseServiceImple.calculateTotalArea(house)*house.getDistric().getDistricPrice();
        //act
        double received = houseServiceImple.calculateTotalValue(house);
        //assert
        assertEquals(expected,received);
    }

    @Test
    public void getDistrictByNameTest(){
        //arrange
        String districtName="center";
        District expected = new District(districtName, 2100);
        when(iHouseRepository.getDistricByName(districtName)).thenReturn(expected);
        //act
        District received = houseServiceImple.getDistricByName(districtName);
        //assert
        verify(iHouseRepository, atLeastOnce()).getDistricByName(districtName);
        assertEquals(expected,received);
    }
    @Test
    public void getBiggestEnvironmentTest() throws HouseNameNotFoundException {
        //arrange
        String houseName="House";
        BiggestEnvironmentDTO expected= TestUtilsGenerator.getBiggerEnvironmentDTO(houseName,"living-room");
        House house= TestUtilsGenerator.getHouseWith4Environments("House");
        when(iHouseRepository.getHouseByName(houseName)).thenReturn(house);

        //act
        BiggestEnvironmentDTO received = houseServiceImple.getBiggestEnviroment(houseName);
        //assert
        verify(iHouseRepository, atLeastOnce()).getHouseByName(houseName);
        assertEquals(expected,received);
    }
    @Test
    public void getAllEnvironmentsAreaTest() throws HouseNameNotFoundException {
        //arrange
        String houseName="House10";
        List<EnvironmentAreaDTO> expected= TestUtilsGenerator.getListENvironmentDTO();
        House house = TestUtilsGenerator.getHouseWith4Environments(houseName);
        when(iHouseRepository.getHouseByName(houseName)).thenReturn(house);

        //act
        List<EnvironmentAreaDTO> received = houseServiceImple.getAllEnviromentsArea(houseName);
        //assert
        verify(iHouseRepository, atLeastOnce()).getHouseByName(houseName);
        assertEquals(expected,received);
    }



}
