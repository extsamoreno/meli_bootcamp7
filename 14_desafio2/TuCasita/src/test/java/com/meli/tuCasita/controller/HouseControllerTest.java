package com.meli.tuCasita.controller;

import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;
import com.meli.tuCasita.service.IHouseService;
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
    public void meter2Exact() {

        // arrange,
        Long id = 1L;
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        AmbientDTO ambientDTO2 = new AmbientDTO("Pieza", 4.0, 3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);

        Mockito.when(houseService.getMeter2(houseID)).thenReturn(27.0D);

        // act
        ResponseEntity<?> structureResponse = housesController.getMeter2(houseID);

        // assert
        Mockito.verify(houseService, Mockito.atLeastOnce()).getMeter2(houseID);
        Assertions.assertEquals((double) structureResponse.getBody(), 27.0D);
    }

    @Test
    public void meterNotExact() {
        //Arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        AmbientDTO ambientDTO2 = new AmbientDTO("Pieza", 4.0, 3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);

        Mockito.when(houseService.getMeter2(houseID)).thenReturn(27.0D);

        //Act
        ResponseEntity<?> structureResponse = housesController.getMeter2(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getMeter2(houseID);
        Assertions.assertNotEquals((double) structureResponse.getBody(), 30D);
    }

    @Test
    public void getPriceExist() {
        //Arrange
        Long houseID = 1L;
        Double value = 3000.0D;
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        ambientDTOS.add(ambientDTO1);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);

        Mockito.when(houseService.getPrice(houseID)).thenReturn(value);

        //Act
        Double received = houseService.getPrice(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getPrice(houseID);
        Assertions.assertEquals(value, received);
    }

    @Test
    public void getPriceNotValid() {
        //Arrange
        Long houseID = 1L;
        Double value = 3000.0D;
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        ambientDTOS.add(ambientDTO1);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);

        Mockito.when(houseService.getPrice(houseID)).thenReturn(value);

        //Act
        Double received = houseService.getPrice(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getPrice(houseID);
        Assertions.assertNotEquals(4000.D, received);
    }


    @Test
    public void AmbientWithMaxSize() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        AmbientDTO ambientDTO2 = new AmbientDTO("Pieza", 4.0, 3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);

        Mockito.when(houseService.getMaxAmbient(houseID)).thenReturn(ambientDTO1);

        //Act
        AmbientDTO received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getMaxAmbient(houseID);
        Assertions.assertEquals(ambientDTO1, received);
    }

    @Test
    public void AmbientWithMaxSizeNotEquals() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        AmbientDTO ambientDTO2 = new AmbientDTO("Pieza", 4.0, 3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);

        Mockito.when(houseService.getMaxAmbient(houseID)).thenReturn(ambientDTO1);

        //Act
        AmbientDTO received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getMaxAmbient(houseID);
        Assertions.assertNotEquals(ambientDTO2, received);
    }

    @Test
    public void GetmaxambientforambientNotEquals() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new AmbientDTO("Cosina", 5.0, 3.0);//15
        ambientDTOS.add(ambientDTO1);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte", 200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro", 200.0);
        HouseDTO houseDTO = new HouseDTO(houseID, "Agustin", districtDTO, ambientDTOS);
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put(ambientDTO1.getName(), 15.0D);
        Mockito.when(houseService.getmaxambientforambient(houseID, ambientDTO1.getName())).thenReturn(expect);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambientDTO1.getName());

        //Assert

        Mockito.verify(houseService, Mockito.atLeastOnce()).getmaxambientforambient(houseID, ambientDTO1.getName());
        Assertions.assertEquals(expect, received);
    }
}


