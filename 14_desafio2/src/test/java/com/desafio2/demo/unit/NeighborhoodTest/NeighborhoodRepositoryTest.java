package com.desafio2.demo.unit.NeighborhoodTest;

import com.desafio2.demo.exception.NeighborhoodAlreadyExistException;
import com.desafio2.demo.exception.NeighborhoodNotFoundException;
import com.desafio2.demo.model.Neighborhood;
import com.desafio2.demo.repository.NeighborhoodRepository;
import com.desafio2.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class NeighborhoodRepositoryTest {
    NeighborhoodRepository neighborhoodRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();

        this.neighborhoodRepository = new NeighborhoodRepository();
    }

    @Test
    public void saveNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        Neighborhood expected = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        int id = 1; // because test database is empty and the util method set id in 9999
        expected.setId(id);

        // act
        Neighborhood received = neighborhoodRepository.saveNeighborhood(neighborhood);

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void saveNeighborhoodWithException() {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");

        TestUtilGenerator.appendNewNeighborhood(neighborhood);
        this.neighborhoodRepository = new NeighborhoodRepository();

        // assert
        assertThrows(NeighborhoodAlreadyExistException.class,() -> neighborhoodRepository.saveNeighborhood(neighborhood));
    }

    @Test
    public void getNeighborhoodByNameOk() throws NeighborhoodNotFoundException {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        Neighborhood expected = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        TestUtilGenerator.this.neighborhoodRepository = new NeighborhoodRepository();

        // act
        Neighborhood received = neighborhoodRepository.getNeighborhoodByName(neighborhood.getName());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getNeighborhoodByNameWithException() {
        // arrange
        Neighborhood neighborhood = TestUtilGenerator.getNeighborhoodPriceTen("Lanus");
        this.neighborhoodRepository = new NeighborhoodRepository();

        // assert
        assertThrows(NeighborhoodNotFoundException.class,() ->
                neighborhoodRepository.getNeighborhoodByName(neighborhood.getName()));
    }
}
