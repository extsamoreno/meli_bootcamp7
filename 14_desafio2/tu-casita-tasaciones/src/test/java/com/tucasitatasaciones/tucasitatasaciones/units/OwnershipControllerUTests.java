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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OwnershipControllerUTests {
    @Mock
    private IOwnershipService ownershipService;

    @InjectMocks
    private OwnershipController ownershipController;

    private int expectedId;

    @BeforeEach
    public void InitData() {
        expectedId = 1;
    }

    @Test
    public void addOwnershipOkTest() throws DistrictNotFoundException {
        OwnershipWithDataDTO expected = new OwnershipWithDataDTO();
        expected.setId(expectedId);
        expected.setName("Ownership Dummy");
        expected.setDistrict(new DistrictDTO(1, "District Dummy", 20D));
        expected.setRooms(new ArrayList<>());

        when(ownershipService.add(expected)).thenReturn(expected);

        var received = ownershipController.addOwnership(expected);

        verify(ownershipService, atLeastOnce()).add(expected);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void calculateSquareMeterByOwnershipWithDataOkTest() throws OwnershipNotFoundException {
        OwnershipWithSquareMeterDTO expected = new OwnershipWithSquareMeterDTO(1, "Ownership Dummy", 20D);

        when(ownershipService.calculateSquareMeterByOwnership(expectedId)).thenReturn(expected);

        ResponseEntity<OwnershipWithSquareMeterDTO> received = ownershipController.calculateSquareMeterByOwnership(expectedId);

        verify(ownershipService, atLeastOnce()).calculateSquareMeterByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void calculateSquareMeterByOwnershipWithoutDataOkTest() throws OwnershipNotFoundException {
        when(ownershipService.calculateSquareMeterByOwnership(expectedId)).thenReturn(null);

        ResponseEntity<OwnershipWithSquareMeterDTO> received = ownershipController.calculateSquareMeterByOwnership(expectedId);

        verify(ownershipService, atLeastOnce()).calculateSquareMeterByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertNull(received.getBody());
    }

    @Test
    public void calculatePriceByOwnershipWithDataOkTest() throws OwnershipNotFoundException, DistrictNotFoundException {
        OwnershipWithPriceDTO expected = new OwnershipWithPriceDTO(1, "Ownership Dummy", 20D);

        when(ownershipService.calculatePriceByOwnership(expectedId)).thenReturn(expected);

        ResponseEntity<OwnershipWithPriceDTO> received = ownershipController.calculatePriceByOwnership(expectedId);

        verify(ownershipService, atLeastOnce()).calculatePriceByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertEquals(expected, received.getBody());
    }

    @Test
    public void calculatePriceByOwnershipWithoutDataOkTest() throws OwnershipNotFoundException, DistrictNotFoundException {
        when(ownershipService.calculatePriceByOwnership(expectedId)).thenReturn(null);

        ResponseEntity<OwnershipWithPriceDTO> received = ownershipController.calculatePriceByOwnership(expectedId);

        verify(ownershipService, atLeastOnce()).calculatePriceByOwnership(expectedId);
        Assertions.assertEquals(HttpStatus.OK, received.getStatusCode());
        Assertions.assertNull(received.getBody());
    }
}
