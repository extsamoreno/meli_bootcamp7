package com.example.desafio2.unit;

import com.example.desafio2.controllers.NeighborhoodController;
import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.services.INeighborhoodService;
import com.example.desafio2.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class NeighborhoodControllerTests {

    @Mock
    INeighborhoodService iNeighborhoodService;

    @InjectMocks
    NeighborhoodController neighborhoodController;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyFiles();
    }

    @Test
    public void createNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        HttpStatus expectedStatus = HttpStatus.CREATED;
        when(iNeighborhoodService.createNeighborhood(neighborhood)).thenReturn(neighborhood);

        // act
        ResponseEntity<NeighborhoodDTO> received = neighborhoodController.createNeighborhood(neighborhood);

        // assert
        verify(iNeighborhoodService, atLeastOnce()).createNeighborhood(neighborhood);
        boolean result = (received.getStatusCode() == expectedStatus && Objects.equals(received.getBody(), expected));
        assertTrue(result);
    }
}
