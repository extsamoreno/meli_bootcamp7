package com.example.Challenge2.Services.Mappers;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Services.DTOs.DistrictDTO;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.PropertyService;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class DistrictMapperTest {

    @Test
    public void toDTOTest(){
        Long id = 1L;
        District district = TestUtilsGenerator.get100USDollarsDistrict(id);
        DistrictDTO expectedDistrictDTO = new DistrictDTO(district.getName(),district.getPricePerM2());

        DistrictDTO districtDTO = DistrictMapper.toDTO(district);

        assertEquals(districtDTO,expectedDistrictDTO);
    }

    @Test
    public void toDistrictTest(){
        Long id = 1L;
        District expectedDistrict = TestUtilsGenerator.get100USDollarsDistrict(null);


        DistrictDTO districtDTO = new DistrictDTO(expectedDistrict.getName(),expectedDistrict.getPricePerM2());

        District district = DistrictMapper.toDistrict(districtDTO);

        assertEquals(expectedDistrict,district);
    }
}
