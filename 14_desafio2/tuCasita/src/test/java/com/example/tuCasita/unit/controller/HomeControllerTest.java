package com.example.tuCasita.unit.controller;

import com.example.tuCasita.controllers.HomeController;
import com.example.tuCasita.dtos.*;
import com.example.tuCasita.exceptions.*;
import com.example.tuCasita.models.District;
import com.example.tuCasita.services.IHomeService;
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

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {
    @Mock
    IHomeService service;

    @InjectMocks
    HomeController controller;

    @Test
    public void getSquareMeterByHomeHappyPath() throws HomeIdNotFoundException {
        //arrange
        Integer homeId = 1;
        Double expected = 20.00;
        Mockito.when(service.getSquareMeterByHome(homeId)).thenReturn(expected);

        //act
        ResponseEntity<Double> recived = controller.getSquareMeterByHome(homeId);

        //assert
        Mockito.verify(service,Mockito.atLeastOnce()).getSquareMeterByHome(homeId);
        Assertions.assertEquals(expected,recived.getBody());
    }

    @Test
    public void getPriceHomeHappyPath() throws HomeIdNotFoundException {
        //arrange
        Integer homeId = 1;
        Double expected = 3500.00;
        Mockito.when(service.getPrice(homeId)).thenReturn(expected);

        //act
        ResponseEntity<Double> recived = controller.getPrice(homeId);

        //assert
        Mockito.verify(service,Mockito.atLeastOnce()).getPrice(homeId);
        Assertions.assertEquals(expected,recived.getBody());
    }

    @Test
    public void getBiggestEnviromentHappyPath() throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        //arrange
        Integer id = 1;
        EnviromentDTO expected = new EnviromentDTO(id,"Enviroment Name test",10.00,10.00);
        Mockito.when(service.getBiggest(id)).thenReturn(expected);

        //act
        ResponseEntity<EnviromentDTO> recived = controller.getBiggestEnviroment(id);

        //assert
        Mockito.verify(service,Mockito.atLeastOnce()).getBiggest(id);
        Assertions.assertEquals(expected,recived.getBody());
    }

    @Test
    public void getMeterCountHappyPath() throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        //arrange
        Integer id = 1;
        List<EnviromentAreasDTO> expected = new ArrayList<>();
        EnviromentAreasDTO env1 = new EnviromentAreasDTO("Enviroment 1",200.00);
        EnviromentAreasDTO env2 = new EnviromentAreasDTO("Enviroment 2",100.00);

        expected.add(env1);
        expected.add(env2);

        Mockito.when(service.getMeterCount(id)).thenReturn(expected);

        //act
        ResponseEntity<List<EnviromentAreasDTO>> recived = controller.getMeterCount(id);

        //assert
        Mockito.verify(service,Mockito.atLeastOnce()).getMeterCount(id);
        Assertions.assertEquals(expected,recived.getBody());
    }

    @Test
    public void insertHomeHappyPath() throws HomeIdNotFoundException, AlreadyExistDistrictException, AlreadyExistEnviromentIdException, AlreadyExistHomeException, DistrictNotFoundException {
        //arrange
        Integer id = 1;
        List<EnviromentDTO> enviromentList = new ArrayList<>();
        EnviromentDTO env1 = new EnviromentDTO(1,"Enviroment 1",10.00,10.00);
        EnviromentDTO env2 = new EnviromentDTO(2,"Enviroment 2",5.00,5.00);
        enviromentList.add(env1);
        enviromentList.add(env2);

        HomeDTO homeDTO = new HomeDTO(id,"Home name",1,enviromentList);

        //expected arrange
        District district = new District(1,"District 1",500.00);

        HomeResponseDTO expected = new HomeResponseDTO(1,"Home name test",district,enviromentList);

        Mockito.when(service.insertHome(homeDTO)).thenReturn(expected);

        //act
        ResponseEntity<HomeResponseDTO> recived = controller.insertHome(homeDTO);

        //assert
        Mockito.verify(service,Mockito.atLeastOnce()).insertHome(homeDTO);
        Assertions.assertEquals(expected,recived.getBody());
        Assertions.assertEquals(HttpStatus.OK,recived.getStatusCode());
    }

    @Test
    public void insertDistrictHappyPath() throws AlreadyExistDistrictException {
        //arrange
        DistrictDTO districtDTO = new DistrictDTO(1,"District Name",500.00);
        String expected = "Se agrego correctamente";

        Mockito.when(service.insertDistrict(districtDTO)).thenReturn(expected);

        //act
        ResponseEntity<String> recived = controller.insertDistrict(districtDTO);

        //assert
        Mockito.verify(service,Mockito.atLeastOnce()).insertDistrict(districtDTO);
        Assertions.assertEquals(expected,recived.getBody());
        Assertions.assertEquals(HttpStatus.OK,recived.getStatusCode());
    }
}
