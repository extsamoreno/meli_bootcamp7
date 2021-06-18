package com.example.tuCasita.unit.service;

import com.example.tuCasita.dtos.EnviromentAreasDTO;
import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.dtos.HomeResponseDTO;
import com.example.tuCasita.exceptions.*;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;
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
        Integer id = 1;

        District district = new District(1,"District Test",500.00);
        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1",10.00,10.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2",5.00,5.00);
        enviromentList.add(env1);
        enviromentList.add(env2);

        Home home = new Home(1,"Home test",district,enviromentList);

        Mockito.when(repository.getHomeById(id)).thenReturn(home);

        //act
        Double recived = service.getSquareMeterByHome(id);

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).getHomeById(id);
        Assertions.assertEquals(125.0,recived);
    }

    @Test
    public void getSquareMeterHomeIdNotFound (){
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

        District district = new District(1,"District Test",500.00);
        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1",10.00,10.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2",5.00,5.00);
        enviromentList.add(env1);
        enviromentList.add(env2);

        Home home = new Home(1,"Home test",district,enviromentList);

        Mockito.when(repository.getHomeById(id)).thenReturn(home);

        //act
        Enviroment recived = HomeMapper.toModel(service.getBiggest(id));

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).getHomeById(id);
        Assertions.assertEquals(env1,recived);
    }

    @Test
    public void getBiggestHomeIdNotExist() {
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

        District district = new District(1,"District Test",500.00);
        Home home = new Home(1,"Home test",district,expected);

        Mockito.when(repository.getHomeById(id)).thenReturn(home);
        Mockito.when(repository.findEnviromentsById(id)).thenReturn(expected);

        //act
        List<EnviromentAreasDTO> recived = service.getMeterCount(id);

        //assert
        Mockito.verify(repository,Mockito.atLeastOnce()).findEnviromentsById(id);
        Assertions.assertEquals(expectedArea,recived);
    }

    @Test
    public void insertHomeHappyPath() throws AlreadyExistEnviromentIdException, AlreadyExistHomeException, DistrictNotFoundException {
        //arrange
        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment envi1 = new Enviroment(1,"Enviroment 1 test",10.00,10.00);
        Enviroment envi2 = new Enviroment(2,"Enviroment 2 test",8.00,5.00);
        enviromentList.add(envi1);
        enviromentList.add(envi2);

        List<EnviromentDTO> enviromentListDto = new ArrayList<>();
        EnviromentDTO env1 = new EnviromentDTO(1,"Enviroment 1 test",10.00,10.00);
        EnviromentDTO env2 = new EnviromentDTO(2,"Enviroment 2 test",8.00,5.00);
        enviromentListDto.add(env1);
        enviromentListDto.add(env2);

        HomeDTO homeDTO = new HomeDTO(1,"Home name",1,enviromentListDto);

        District district = new District(1,"District Name",200.00);

        HomeResponseDTO expected = new HomeResponseDTO(1,"Home name",district,enviromentListDto);

        Home home = new Home(1,"Home name",district,enviromentList);

        Mockito.when(repository.findDistrictById(1)).thenReturn(district);
        Mockito.when(repository.getHomeById(1)).thenReturn(home);

        //act
        HomeResponseDTO recived = service.insertHome(homeDTO);

        //assert
        //Mockito.verify()
        Assertions.assertEquals(expected,recived);
    }
}
