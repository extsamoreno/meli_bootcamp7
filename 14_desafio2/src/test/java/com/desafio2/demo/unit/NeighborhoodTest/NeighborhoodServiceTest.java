package com.desafio2.demo.unit.NeighborhoodTest;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.repository.INeighborhoodRepository;
import com.desafio2.demo.service.NeighborhoodService;
import com.desafio2.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NeighborhoodServiceTest {
    @Mock
    INeighborhoodRepository iNeighborhoodRepository;

    @InjectMocks
    NeighborhoodService neighborhoodService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();
    }

    @Test
    public void createNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        Neighborhood expected = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        when(iNeighborhoodRepository.saveNeighborhood(neighborhood)).thenReturn(neighborhood);

        // act
        Neighborhood received = neighborhoodService.createNeighborhood(neighborhood);

        // assert
        verify(iNeighborhoodRepository, atLeastOnce()).saveNeighborhood(neighborhood);
        assertEquals(expected, received);
    }
}
