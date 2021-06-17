package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.IDistrictService;
import com.example.Challenge2.Services.IPropertyService;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {

    @Mock
    IDistrictService iDistrictService;

    @InjectMocks
    DistrictController districtController;




    @Test
    public void storeTest() {

        // arrange,
        Long id = 1L;
        DistrictDTO districtDTO = DistrictMapper.toDTO(TestUtilsGenerator.get100USDollarsDistrict(1L));
        when(iDistrictService.storeDistrict(districtDTO)).thenReturn(true);

        // act
        ResponseEntity<Boolean> structureResponse = districtController.store(districtDTO);

        // assert
        verify(iDistrictService, atLeastOnce()).storeDistrict(districtDTO);
        assertTrue(structureResponse.getBody());
    }
}
