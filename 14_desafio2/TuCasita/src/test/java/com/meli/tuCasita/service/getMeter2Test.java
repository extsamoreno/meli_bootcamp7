package com.meli.tuCasita.service;

import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;
import com.meli.tuCasita.repository.IHouseDAO;
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
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        Double received = houseService.getMeter2(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(27.0D, received);
    }
    @Test
    public void meterNotExact() {
        //Arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        Double received = houseService.getMeter2(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(100.0D, received);
    }

    @Test
    public void districtExist() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findByDistrict(districtDTO)).thenReturn(houseDTO);

        //Act
        HouseDTO received = houseService.getDistricto(houseDTO);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findByDistrict(districtDTO);
        Assertions.assertEquals(houseDTO, received);
    }

    @Test
    public void districtNotExist() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findByDistrict(districtDTO)).thenReturn(houseDTO);

        //Act
        HouseDTO received = houseService.getDistricto(houseDTO);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findByDistrict(districtDTO);
        Assertions.assertNotEquals(districtDTO1, received);
    }


    @Test
    public void AmbientWithMaxSize() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        AmbientDTO received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(ambientDTO1, received);
    }
    @Test
    public void AmbientWithMaxSizeNotEquals() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        AmbientDTO received = houseService.getMaxAmbient(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(ambientDTO2, received);
    }

    @Test
    public void Meter2forAmbient() {
        //Arrange
        Long houseID = 1L;
        String district = "Banda Norte";
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambientDTO1.getName());
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
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambientDTO1.getName());
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
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        DistrictDTO districtDTO1 = new DistrictDTO("Centro",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        HashMap<String, Double> received = houseService.getmaxambientforambient(houseID, ambientDTO1.getName());
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put("Pieza",12.D);
        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertNotEquals(expect, received);
    }

}
