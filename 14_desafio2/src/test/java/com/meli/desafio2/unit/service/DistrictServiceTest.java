package com.meli.desafio2.unit.service;

import com.meli.desafio2.unit.Utils;
import com.meli.desafio2.web.dto.request.DistrictDTO;
import com.meli.desafio2.web.exception.DistrictAlreadyExistException;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.repository.IDistrictRepository;
import com.meli.desafio2.web.service.DistrictMapper;
import com.meli.desafio2.web.service.DistrictService;
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
    IDistrictRepository iDistrictRepository;

    @InjectMocks
    DistrictService districtService;

    DistrictDTO districtDTO = Utils.initValidDistrictDTO();
    District district = DistrictMapper.toModel(districtDTO);
    String name = districtDTO.getDistrict_name();
    @Test
    public void saveTest() throws DistrictAlreadyExistException {
        //arrange
        Mockito.when(iDistrictRepository.getDistrictByName(name)).thenReturn(null);
        Mockito.doNothing().when(iDistrictRepository).saveDistrict(district);
        //act
        districtService.save(districtDTO);
        //assert
        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).getDistrictByName(name);
        Mockito.verify(iDistrictRepository,Mockito.atLeast(1)).saveDistrict(district);
    }
    @Test
    public void ExceptionInSaveTest() throws DistrictAlreadyExistException {
        //arrange
        Mockito.when(iDistrictRepository.getDistrictByName(name)).thenReturn(district);
        //act

        //assert

        Assertions.assertThrows(DistrictAlreadyExistException.class, () -> districtService.save(districtDTO));
        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).getDistrictByName(name);
    }

    @Test
    public void getDistrictByNameTest(){
        //arrange
        Mockito.when(iDistrictRepository.getDistrictByName(name)).thenReturn(district);
        //act
        DistrictDTO response = districtService.getDistrictByName(name);
        //assert
        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).getDistrictByName(name);
        Assertions.assertEquals(districtDTO,response);

    }




}
