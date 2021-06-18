package com.desafio2.Service;

import com.desafio2.Model.District;
import com.desafio2.Repository.IDistrctRepository;
import com.desafio2.Utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {
    @Mock
    IDistrctRepository iDistrctRepository;

    @InjectMocks
    DistrictService districtService;

    @Test
    public void createDistrictSuccessfullyTest() {
        //arrange
        District district = TestUtils.createWestDistrict100USD();
        Mockito.doNothing().when(iDistrctRepository).save(district);

        //act
        districtService.create(district);

        //assert
        Mockito.verify(iDistrctRepository, Mockito.atLeast(1)).save(district);
    }
}
