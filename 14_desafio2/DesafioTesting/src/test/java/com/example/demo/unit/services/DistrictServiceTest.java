package com.example.demo.unit.services;

import com.example.demo.Utils.Utils;
import com.example.demo.dtos.DistrictDTO;
import com.example.demo.dtos.DistrictRequestDTO;
import com.example.demo.exceptions.DistrictDontFoundException;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.services.DistrictServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {

    @Mock
    DistrictRepository districtRepository;

    @InjectMocks
    DistrictServiceImple districtServiceImple;

    @Test
    public void createDistrict(){

        //arrange
        DistrictRequestDTO expected = Utils.getDistrictRequestDTO();

        Mockito.when(districtRepository.createDistrict(expected)).thenReturn(expected);

        //act
        DistrictRequestDTO received = districtServiceImple.createDistrict(expected);

        //assert
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).createDistrict(expected);
        Assertions.assertEquals(expected,received);

    }


    @Test
    public void findDistrictById() throws DistrictDontFoundException {
        //arrange
        DistrictDTO expected = Utils.getDistrictDTO();
        int id = 1;
        Mockito.when(districtRepository.findDistrictById(id)).thenReturn(expected);

        //act
        DistrictDTO received = districtServiceImple.findDistrictById(id);

        //assert
        Mockito.verify(districtRepository, Mockito.atLeastOnce()).findDistrictById(id);
        Assertions.assertEquals(expected,received);

    }

}
