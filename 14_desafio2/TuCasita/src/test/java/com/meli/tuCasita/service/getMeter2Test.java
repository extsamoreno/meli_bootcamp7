package com.meli.tuCasita.service;

import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.District;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.repository.IHouseDAO;
import com.meli.tuCasita.service.dto.ResponseMeter2DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class getMeter2Test {
    @Mock
    IHouseDAO houseDAO;

    @InjectMocks
    HouseService houseService;

    @Test
    public void meterExacts() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);
        ResponseMeter2DTO responseMeter2DTO = new ResponseMeter2DTO();
        responseMeter2DTO.setMeter2(27.0D);
        responseMeter2DTO.setHouse(house);
        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        ResponseMeter2DTO received = houseService.getMeter2(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(27.0D, received.getMeter2());
    }
    @Test
    public void meterNotExact() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        ResponseMeter2DTO received = houseService.getMeter2(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(100.0D, received);
    }

    @Test
    public void districtExist() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findByDistrict(districtDTO)).thenReturn(house);

        //Act
        House received = houseService.getDistricto(house);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findByDistrict(districtDTO);
        Assertions.assertEquals(house, received);
    }

    @Test
    public void districtNotExist() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        District district1 = new District("Centro",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findByDistrict(districtDTO)).thenReturn(house);

        //Act
        House received = houseService.getDistricto(house);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findByDistrict(districtDTO);
        Assertions.assertNotEquals(district1, received);
    }


    @Test
    public void AmbientWithMaxSize() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        District district1 = new District("Centro",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        Ambient received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(ambient1, received);
    }
    @Test
    public void AmbientWithMaxSizeNotEquals() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        District district1 = new District("Centro",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        Ambient received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(ambient2, received);
    }

    @Test
    public void Meter2forAmbient() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        District district1 = new District("Centro",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambient1.getName());
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put("Cosina",15.D);
        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(expect, received);
    }

    @Test
    public void Meter2forAmbientFails() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        District district1 = new District("Centro",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambient1.getName());
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put("Pieza",12.D);
        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(expect, received);
    }

    @Test
    public void GetPrice() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte",200.0);
        District district1 = new District("Centro",200.0);
        House house = new House(houseID,"Agustin",districtDTO, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambient1.getName());
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put("Pieza",12.D);
        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(expect, received);
    }

}
