package com.desafiotesting.api.unit;

import com.desafiotesting.api.dto.*;
import com.desafiotesting.api.exception.NotFoundDistrictException;
import com.desafiotesting.api.model.District;
import com.desafiotesting.api.repository.IDistrictsRepository;
import com.desafiotesting.api.service.TasacionesService;
import com.desafiotesting.api.service.mapper.DistrictMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TasacionesServiceTest {
    @Mock
    IDistrictsRepository repository;
    @Mock
    DistrictMapper mapper;
    @InjectMocks
    TasacionesService service;


    PropertyDTO house = new PropertyDTO("Casa1", "Centro", new ArrayList<>(){
        {
            add(new EnvironmentDTO("Cocina", 3.0, 2.0));
            add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
        }
    });

    @Test
    public void totalAreaHappyPath(){
        //arrange
        TotalAreaDTO expected = new TotalAreaDTO("Casa1",18.0);

        //act
        TotalAreaDTO received = service.totalArea(house);

        //assert
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void priceHappyPath() throws NotFoundDistrictException {
        //arrange
        PriceDTO expected = new PriceDTO("Casa1", 18.0*100.0);

        District district = new District("Centro", 100.0);
        Map<String, District> districts = new HashMap<>();
        districts.put("Centro", district);

        Mockito.when(repository.getDistricts()).thenReturn(districts);

        //act
        PriceDTO recieved = service.price(house);

        //assert
        Mockito.verify(repository, Mockito.atLeast(1)).getDistricts();
        Assertions.assertEquals(expected,recieved);
    }

    @Test
    public void priceThrowsNotFoundDistrictException() throws NotFoundDistrictException {
        //arrange
        PriceDTO expected = new PriceDTO("Casa1", 18.0*100.0);

        District district = new District("Barrio", 100.0);
        Map<String, District> districts = new HashMap<>();
        districts.put("Barrio", district);

        Mockito.when(repository.getDistricts()).thenReturn(districts);

        //act

        //assert
        Assertions.assertThrows(NotFoundDistrictException.class,  () -> service.price(house));
        Mockito.verify(repository, Mockito.atLeast(1)).getDistricts();
    }

    @Test
    public void biggerEnvironmentHappyPath(){
        //arrange
        BiggerEnvironmentDTO expected = new BiggerEnvironmentDTO("Habitacion");

        //act
        BiggerEnvironmentDTO received = service.biggerEnvironment(house);

        //assert
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void environmentsAreaHappyPath(){
        //arrange
        ArrayList<EnvironmentAreaDTO> expected = new ArrayList<>(){
            {   add(new EnvironmentAreaDTO("Cocina",6.0));
                add(new EnvironmentAreaDTO("Habitacion",12.0));
            }
        };

        //act
        ArrayList<EnvironmentAreaDTO>  received = service.environmentsArea(house);

        //assert
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void newDistrictHappyPath() throws Exception {
        //arrange
        DistrictDTO dto = new DistrictDTO("Oeste", 34.0);
        Mockito.when(repository.getDistricts().put(dto.getName(), mapper.dtoToModel(dto))).thenReturn(null);

        //act
        String received = service.newDistrict(dto);

        //assert
        Mockito.verify(repository, Mockito.atLeast(1)).getDistricts();
        Assertions.assertEquals("District Added to repository.",received);

    }



}
