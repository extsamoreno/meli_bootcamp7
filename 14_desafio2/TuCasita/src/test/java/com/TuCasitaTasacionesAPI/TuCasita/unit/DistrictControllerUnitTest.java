package com.TuCasitaTasacionesAPI.TuCasita.unit;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.controllers.DistrictController;
import com.TuCasitaTasacionesAPI.TuCasita.dtos.DistrictDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.services.IDistrictService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DistrictControllerUnitTest {
    @Mock
    IDistrictService iDistrictService;

    @InjectMocks
    DistrictController districtController;

    @Test
    public void createHappyPath() throws DistrictAlreadyExistsException {
        DistrictDTO districtDTO = UtilsDataTests.generateDistrictDTO();

        when(iDistrictService.create(districtDTO)).thenReturn(1);

        ResponseEntity<Integer> received = districtController.create(districtDTO);

        assertEquals(1, received.getBody());
        assertEquals(HttpStatus.CREATED, received.getStatusCode());
    }
}
