package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.mapper.DistrictMapper;
import com.didney.junit.tucasitatasaciones.model.District;
import com.didney.junit.tucasitatasaciones.repository.IDistrictRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DistrictServiceTest {
    @Mock
    IDistrictRepository iDistrictRepository;

    @Mock
    DistrictMapper districtMapper;

    @InjectMocks
    DistrictService districtService;

    @Test
    void addDistrict() {
        //arrange
        DistrictDTO expected = getDistrictDTO();
        DistrictDTO districtDTO = getDistrictDTO();
        when(districtMapper.districtDTOToDistrict(getDistrictDTO())).thenReturn(getDistrict());
        when(iDistrictRepository.addDistrict(getDistrict())).thenReturn(getDistrict());
        when(districtMapper.districtToDistrictDTO(getDistrict())).thenReturn(districtDTO);
        //act
        DistrictDTO received = districtService.addDistrict(getDistrictDTO());
        //assert
        verify(districtMapper, atLeast(1)).districtDTOToDistrict(getDistrictDTO());
        verify(iDistrictRepository, atLeast(1)).addDistrict(getDistrict());
        verify(districtMapper, atLeast(1)).districtToDistrictDTO(getDistrict());
        assertEquals(expected, received);
    }

    @Test
    void addDistricts() {
        //arrange
        List<DistrictDTO> expected = new ArrayList<>();
        expected.add(getDistrictDTO());
        expected.add(getDistrictDTO());
        List<DistrictDTO> listSend = new ArrayList<>();
        listSend.add(getDistrictDTO());
        listSend.add(getDistrictDTO());
        DistrictDTO districtDTO = getDistrictDTO();
        when(districtMapper.districtDTOToDistrict(getDistrictDTO())).thenReturn(getDistrict());
        when(iDistrictRepository.addDistrict(getDistrict())).thenReturn(getDistrict());
        when(districtMapper.districtToDistrictDTO(getDistrict())).thenReturn(districtDTO);
        //act
        List<DistrictDTO> received = districtService.addDistricts(listSend);
        //assert
        verify(districtMapper, atLeast(listSend.size())).districtDTOToDistrict(getDistrictDTO());
        verify(iDistrictRepository, atLeast(listSend.size())).addDistrict(getDistrict());
        verify(districtMapper, atLeast(listSend.size())).districtToDistrictDTO(getDistrict());
        assertEquals(expected, received);
    }

    @Test
    void getDistricts() {
        //arrange
        List<District> districtsList = new ArrayList<>();
        districtsList.add(getDistrict());
        districtsList.add(getDistrict());
        List<DistrictDTO> expected = new ArrayList<>();
        expected.add(getDistrictDTO());
        expected.add(getDistrictDTO());
        when(districtMapper.listDistrictToDistrictDTO(districtsList)).thenReturn(expected);
        when(iDistrictRepository.getDistricts()).thenReturn(districtsList);
        //act
        List<DistrictDTO> received = districtService.getDistricts();
        //assert
        verify(districtMapper, atLeast(1)).listDistrictToDistrictDTO(districtsList);
        verify(iDistrictRepository, atLeast(1)).getDistricts();
        assertEquals(expected, received);
    }

    private District getDistrict() {
        return new District(1, "District 1", 4000);
    }

    private DistrictDTO getDistrictDTO() {
        return new DistrictDTO("District 1", 4000);
    }

}