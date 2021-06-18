package com.meli.tuCasita.controller;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.District;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.service.IHouseService;
import com.meli.tuCasita.service.dto.ResponseGetPriceDTO;
import com.meli.tuCasita.service.dto.ResponseMeter2DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class HouseControllerTest {

    @Mock
    IHouseService houseService;

    @InjectMocks
    HousesController housesController;
    @Test
    public void meter2Exceptions() {

        // arrange,
        Long id = 1L;
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);

        // act

        // assert
        Mockito.when(houseService.getMeter2(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> housesController.getMeter2(houseID));
    }


    @Test
    public void meter2Exact() {

        // arrange,
        Long id = 1L;
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);
        ResponseMeter2DTO responseMeter2DTO = new ResponseMeter2DTO();
        responseMeter2DTO.setMeter2(27.0D);
        responseMeter2DTO.setHouse(house);

        Mockito.when(houseService.getMeter2(houseID)).thenReturn(responseMeter2DTO);

        // act
        ResponseEntity<?> structureResponse = housesController.getMeter2(houseID);

        // assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).getMeter2(houseID);
        Assertions.assertEquals(structureResponse.getBody(), responseMeter2DTO);
    }

    @Test
    public void meter2NotExact() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);
        ResponseMeter2DTO responseMeter2DTO = new ResponseMeter2DTO();
        responseMeter2DTO.setMeter2(27.0D);
        responseMeter2DTO.setHouse(house);

        Mockito.when(houseService.getMeter2(houseID)).thenReturn(responseMeter2DTO);

        //Act
        ResponseEntity<?> structureResponse = housesController.getMeter2(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getMeter2(houseID);
        ResponseMeter2DTO responseMeter2DTO2 = new ResponseMeter2DTO();
        responseMeter2DTO.setHouse(house);
        responseMeter2DTO2.setMeter2(30.0D);
        Assertions.assertNotEquals(structureResponse.getBody(), responseMeter2DTO2);
    }


    @Test
    public void getPriceExist() {
        //Arrange
        Long houseID = 1L;
        Double value = 3000.0D;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        ambients.add(ambient1);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);
        ResponseGetPriceDTO responseGetPriceDTO = new ResponseGetPriceDTO();
        responseGetPriceDTO.setHouse(house);
        responseGetPriceDTO.setPrice(3000.0D);
        Mockito.when(houseService.getPrice(houseID)).thenReturn(responseGetPriceDTO);

        //Act
        ResponseGetPriceDTO received = houseService.getPrice(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getPrice(houseID);
        Assertions.assertEquals(value, received.getPrice());
    }
    @Test
    public void getPriceExact() {

        // arrange,
        Long id = 1L;
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);
        ResponseGetPriceDTO responseGetPriceDTO = new ResponseGetPriceDTO();
        responseGetPriceDTO.setHouse(house);
        responseGetPriceDTO.setPrice(5400D);
        Mockito.when(houseService.getPrice(houseID)).thenReturn(responseGetPriceDTO);

        // act
        ResponseEntity<?> structureResponse = housesController.getPrice(houseID);

        // assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).getPrice(houseID);
        Assertions.assertEquals( structureResponse.getBody(), responseGetPriceDTO);
    }

    @Test
    public void getPriceNotValid() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        ambients.add(ambient1);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);
        ResponseGetPriceDTO responseGetPriceDTO = new ResponseGetPriceDTO();
        responseGetPriceDTO.setHouse(house);
        responseGetPriceDTO.setPrice(3000.0D);
        Mockito.when(houseService.getPrice(houseID)).thenReturn(responseGetPriceDTO);

        //Act
        ResponseGetPriceDTO received = houseService.getPrice(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getPrice(houseID);
        Assertions.assertNotEquals(4000.D, received.getPrice());
    }


    @Test
    public void AmbientWithMaxSize() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte", 200.0);
        District district1 = new District("Centro", 200.0);
        House house = new House(houseID, "Agustin", districtDTO, ambients);

        Mockito.when(houseService.getMaxAmbient(houseID)).thenReturn(ambient1);

        //Act
        Ambient received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getMaxAmbient(houseID);
        Assertions.assertEquals(ambient1, received);
    }
    @Test
    public void AmbientWithMaxSizeExact() {

        // arrange,
        Long id = 1L;
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);

        Mockito.when(houseService.getMaxAmbient(houseID)).thenReturn(ambient1);

        // act
        ResponseEntity<?> structureResponse = housesController.getMaxAmbient(houseID);

        // assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).getMaxAmbient(houseID);
        Assertions.assertEquals((Ambient) structureResponse.getBody(), ambient1);
    }

    @Test
    public void AmbientWithMaxSizeNotEquals() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District districtDTO = new District("Banda Nrte", 200.0);
        District district1 = new District("Centro", 200.0);
        House house = new House(houseID, "Agustin", districtDTO, ambients);

        Mockito.when(houseService.getMaxAmbient(houseID)).thenReturn(ambient1);

        //Act
        Ambient received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getMaxAmbient(houseID);
        Assertions.assertNotEquals(ambient2, received);
    }

    @Test
    public void GetmaxambientforambientNotEquals() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        ambients.add(ambient1);
        District districtDTO = new District("Banda Nrte", 200.0);
        District district1 = new District("Centro", 200.0);
        House house = new House(houseID, "Agustin", districtDTO, ambients);
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put(ambient1.getName(), 15.0D);
        Mockito.when(houseService.getmaxambientforambient(houseID, ambient1.getName())).thenReturn(expect);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambient1.getName());

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getmaxambientforambient(houseID, ambient1.getName());
        Assertions.assertEquals(expect, received);
    }
    @Test
    public void GetmaxambientforambientExact() {

        // arrange,
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        ambients.add(ambient1);
        District districtDTO = new District("Banda Nrte", 200.0);
        District district1 = new District("Centro", 200.0);
        House house = new House(houseID, "Agustin", districtDTO, ambients);
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put(ambient1.getName(), 15.0D);
        Mockito.when(houseService.getmaxambientforambient(houseID, ambient1.getName())).thenReturn(expect);

        // act
        ResponseEntity<?> structureResponse = housesController.getmaxambient(houseID,"Cosina");

        // assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).getmaxambientforambient(houseID, ambient1.getName());
        Assertions.assertEquals(structureResponse.getBody(), expect);
    }

}


