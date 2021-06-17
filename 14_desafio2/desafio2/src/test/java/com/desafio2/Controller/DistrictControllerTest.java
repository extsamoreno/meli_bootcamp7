package com.desafio2.Controller;

import com.desafio2.Model.District;
import com.desafio2.Service.IDistrictService;
import com.desafio2.Utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerTest {
    @Mock
    IDistrictService iDistrictService;

    @InjectMocks
    DistrictController districtController;

    @Test
    public void createDistrict() {
        // arrange
        District district = TestUtils.createWestDistrict100USD();

        // act
        districtController.createDistrict(district);

        // assert
        verify(iDistrictService, atLeastOnce()).create(district);
    }
}
