package com.tucasitatasaciones.tucasitatasaciones.units;

import com.tucasitatasaciones.tucasitatasaciones.controllers.OwnershipController;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.IOwnershipService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.DistrictDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithPriceDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithSquareMeterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class OwnershipControllerUTests {
    @Mock
    private IOwnershipService ownershipService;

    @InjectMocks
    private OwnershipController ownershipController;

    @Test
    public void addOwnershipOkTest() throws DistrictNotFoundException {
        OwnershipWithDataDTO expected = new OwnershipWithDataDTO();
        expected.setId(1);
        expected.setName("Ownership Dummy");
        expected.setDistrict(new DistrictDTO(1, "District Dummy", 20D));
        expected.setRooms(new ArrayList<>());

        Mockito.when(ownershipService.add(expected)).thenReturn(expected);

        var received = ownershipController.addOwnership(expected);

        Mockito.verify(ownershipService, Mockito.atLeastOnce()).add(expected);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void calculateSquareMeterByOwnershipWithDataOkTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        OwnershipWithSquareMeterDTO expected = new OwnershipWithSquareMeterDTO(1, "Ownership Dummy", 20D);

        Mockito.when(ownershipService.calculateSquareMeterByOwnership(expectedId)).thenReturn(expected);

        ResponseEntity<OwnershipWithSquareMeterDTO> received = ownershipController.calculateSquareMeterByOwnership(expectedId);

        Mockito.verify(ownershipService, Mockito.atLeastOnce()).calculateSquareMeterByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void calculateSquareMeterByOwnershipWithoutDataOkTest() throws OwnershipNotFoundException {
        int expectedId = 1;

        Mockito.when(ownershipService.calculateSquareMeterByOwnership(expectedId)).thenReturn(null);

        ResponseEntity<OwnershipWithSquareMeterDTO> received = ownershipController.calculateSquareMeterByOwnership(expectedId);

        Mockito.verify(ownershipService, Mockito.atLeastOnce()).calculateSquareMeterByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertNull(received.getBody());
    }

    @Test
    public void calculatePriceByOwnershipWithDataOkTest() throws OwnershipNotFoundException, DistrictNotFoundException {
        int expectedId = 1;

        OwnershipWithPriceDTO expected = new OwnershipWithPriceDTO(1, "Ownership Dummy", 20D);

        Mockito.when(ownershipService.calculatePriceByOwnership(expectedId)).thenReturn(expected);

        ResponseEntity<OwnershipWithPriceDTO> received = ownershipController.calculatePriceByOwnership(expectedId);

        Mockito.verify(ownershipService, Mockito.atLeastOnce()).calculatePriceByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void calculatePriceByOwnershipWithoutDataOkTest() throws OwnershipNotFoundException, DistrictNotFoundException {
        int expectedId = 1;

        Mockito.when(ownershipService.calculatePriceByOwnership(expectedId)).thenReturn(null);

        ResponseEntity<OwnershipWithPriceDTO> received = ownershipController.calculatePriceByOwnership(expectedId);

        Mockito.verify(ownershipService, Mockito.atLeastOnce()).calculatePriceByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertNull(received.getBody());
    }
}
