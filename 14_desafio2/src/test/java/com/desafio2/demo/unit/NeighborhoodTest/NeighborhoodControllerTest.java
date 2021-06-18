package com.desafio2.demo.unit.NeighborhoodTest;

import com.desafio2.demo.controller.NeighborhoodController;
import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.service.INeighborhoodService;
import com.desafio2.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NeighborhoodControllerTest {

    @Mock
    INeighborhoodService iNeighborhoodService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();
    }

    @InjectMocks
    NeighborhoodController neighborhoodController;

    @Test
    public void createNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        Neighborhood expected = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        HttpStatus expectedStatus = HttpStatus.CREATED;
        when(iNeighborhoodService.createNeighborhood(neighborhood)).thenReturn(neighborhood);

        // act
        ResponseEntity<Neighborhood> received = neighborhoodController.createNeighborhood(neighborhood);

        // assert
        verify(iNeighborhoodService, atLeastOnce()).createNeighborhood(neighborhood);
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }
}
