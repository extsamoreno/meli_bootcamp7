package com.desafio2.demo.unit;

import com.desafio2.demo.dtos.*;
import com.desafio2.demo.exception.DistrictAlreadyExistException;
import com.desafio2.demo.model.District;
import com.desafio2.demo.repository.IPropertyRepository;
import com.desafio2.demo.service.PropertyService;
import com.desafio2.demo.service.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;


@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository iPropertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        Util.emptyFiles();
    }


    @Test
    public void createDistrictOk() throws DistrictAlreadyExistException {
        // arrange
        District district = Util.getDistrictPriceTest("Alberdi");
        District expected = Util.getDistrictPriceTest("Alberdi");
        when(iPropertyRepository.saveDistrict(district)).thenReturn(district);

        // act
        District received = propertyService.createDistrict(district);

        // assert
        verify(iPropertyRepository, atLeastOnce()).saveDistrict(district);
        assertEquals(expected, received);
    }
}
