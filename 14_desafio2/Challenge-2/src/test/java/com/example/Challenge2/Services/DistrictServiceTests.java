package com.example.Challenge2.Services;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Repositories.IDataRepository;
import com.example.Challenge2.Services.DTOs.DistrictDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;
import com.example.Challenge2.Services.DTOs.StructureDTO;
import com.example.Challenge2.Services.DTOs.ValueDTO;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
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
public class DistrictServiceTests {

    @Mock
    IDataRepository iDataRepository;

    @InjectMocks
    DistrictService districtService;


    @Test
    public void storeTest() {

        // arrange
        Long id = 1L;
        DistrictDTO districtDTO = DistrictMapper.toDTO(TestUtilsGenerator.get100USDollarsDistrict(id));

        when(iDataRepository.getAllDistricts()).thenReturn(new ArrayList<>());

        // act
        Boolean response = districtService.storeDistrict(districtDTO);

        // assert
        verify(iDataRepository, atLeastOnce()).getAllDistricts();
        assertTrue(response);
    }


}
