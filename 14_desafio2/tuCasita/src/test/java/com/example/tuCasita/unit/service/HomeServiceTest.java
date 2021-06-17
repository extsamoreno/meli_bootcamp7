package com.example.tuCasita.unit.service;

import com.example.tuCasita.dtos.EnviromentAreasDTO;
import com.example.tuCasita.exceptions.DistrictNotFoundException;
import com.example.tuCasita.exceptions.HomeIdNotFoundException;
import com.example.tuCasita.exceptions.HomeWithNoEnviromentsException;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.repositories.IHomeRepository;
import com.example.tuCasita.services.HomeService;
import com.example.tuCasita.services.mapper.HomeMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HomeServiceTest {
    @Mock
    IHomeRepository repository;

    @InjectMocks
    HomeService service;

    @Test
    public void getSquareMeterByHomeHappyPath () throws HomeIdNotFoundException {
        //arrange
        Integer homeId = 1;
        Double expected = 20.00;
        Mockito.when(repository.getSquareMeterByHome(homeId)).thenReturn(expected);

        //act
        Double recived = service.getSquareMeterByHome(homeId);

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).getSquareMeterByHome(homeId);
        Assertions.assertEquals(expected,recived);
    }

    @Test
    public void getSquareMeterHomeIdNotFound () throws HomeIdNotFoundException {
        //arrange
        Mockito.when(repository.getSquareMeterByHome(1)).thenThrow(new HomeIdNotFoundException(1));

        //assert
        Assertions.assertThrows(HomeIdNotFoundException.class, ()-> service.getSquareMeterByHome(1));
    }

    @Test
    public void getExistingDistrict() throws DistrictNotFoundException {
        //arrange
        Integer id = 1;
        District expected = new District(id,"District test",0.00);
        Mockito.when(repository.findDistrictById(id)).thenReturn(expected);

        //act
        District recived = service.findDistrictById(id);

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).findDistrictById(id);
        Assertions.assertEquals(expected,recived);
    }

    @Test
    public void getNotExistingDistrict() throws DistrictNotFoundException {
        //arrange
        Mockito.when(repository.findDistrictById(1)).thenThrow(new DistrictNotFoundException(1));

        //assert
        Assertions.assertThrows(DistrictNotFoundException.class, ()-> service.findDistrictById(1));
    }

    @Test
    public void getBiggestEnvHappyPath() throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        //arrange
        Integer id = 1;
        Enviroment expected = new Enviroment(id,"Enviroment test",10.00,10.00);
        Mockito.when(repository.getBiggest(id)).thenReturn(expected);

        //act
        Enviroment recived = HomeMapper.toModel(service.getBiggest(id));

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).getBiggest(id);
        Assertions.assertEquals(expected,recived);
    }

    @Test
    public void getBiggestEnvNotExist() throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        //arrange
        Mockito.when(repository.getBiggest(1)).thenThrow(new HomeWithNoEnviromentsException(1));

        //assert
        Assertions.assertThrows(HomeWithNoEnviromentsException.class, ()-> service.getBiggest(1));
    }

    @Test
    public void getBiggestHomeNotExist() throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        //arrange
        Mockito.when(repository.getBiggest(1)).thenThrow(new HomeIdNotFoundException(1));

        //assert
        Assertions.assertThrows(HomeIdNotFoundException.class, ()-> service.getBiggest(1));
    }

    @Test
    public void getSquareMeterHappyPath() throws HomeIdNotFoundException {
        //arrange
        Integer id = 1;
        List<Enviroment> expected = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1 test",10.00,8.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2 test",5.00,10.00);

        expected.add(env1);
        expected.add(env2);

        List<EnviromentAreasDTO> expectedArea = new ArrayList<>();
        EnviromentAreasDTO envArea1 = new EnviromentAreasDTO("Enviroment 1 test",80.00);
        EnviromentAreasDTO envArea2 = new EnviromentAreasDTO("Enviroment 2 test",50.00);

        expectedArea.add(envArea1);
        expectedArea.add(envArea2);

        Mockito.when(repository.findEnviromentsById(id)).thenReturn(expected);

        //act
        List<EnviromentAreasDTO> recived = service.getMeterCount(id);

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).findEnviromentsById(id);
        Assertions.assertEquals(expectedArea,recived);
    }
}
