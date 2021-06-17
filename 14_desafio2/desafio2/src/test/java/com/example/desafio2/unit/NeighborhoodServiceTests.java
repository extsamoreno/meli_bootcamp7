package com.example.desafio2.unit;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.repositories.INeighborhoodRepository;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.services.NeighborhoodService;
import com.example.desafio2.services.PropertyService;
import com.example.desafio2.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NeighborhoodServiceTests {

    @Mock
    INeighborhoodRepository iNeighborhoodRepository;

    @InjectMocks
    NeighborhoodService neighborhoodService;

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
        when(iNeighborhoodRepository.saveNeighborhood(neighborhood)).thenReturn(neighborhood);

        // act
        NeighborhoodDTO received = neighborhoodService.createNeighborhood(neighborhood);

        // assert
        verify(iNeighborhoodRepository, atLeastOnce()).saveNeighborhood(neighborhood);
        assertEquals(expected, received);
    }
}
