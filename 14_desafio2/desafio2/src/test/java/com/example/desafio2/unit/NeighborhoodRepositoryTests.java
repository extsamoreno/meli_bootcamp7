package com.example.desafio2.unit;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.repositories.NeighborhoodRepository;
import com.example.desafio2.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class NeighborhoodRepositoryTests {

    NeighborhoodRepository neighborhoodRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyFiles();

        this.neighborhoodRepository = new NeighborhoodRepository();
    }

    @Test
    public void saveNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        int id = 1; // because test database is empty and the util method set id in 9999
        expected.setId(id);

        // act
        NeighborhoodDTO received = neighborhoodRepository.saveNeighborhood(neighborhood);

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void saveNeighborhoodWithException() {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");

        TestUtilsGenerator.appendNewNeighborhood(neighborhood);
        this.neighborhoodRepository = new NeighborhoodRepository();

        // assert
        assertThrows(NeighborhoodAlreadyExistException.class,() -> neighborhoodRepository.saveNeighborhood(neighborhood));
    }

    @Test
    public void getNeighborhoodByNameOk() throws NeighborhoodNotFoundException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        TestUtilsGenerator.appendNewNeighborhood(neighborhood);
        this.neighborhoodRepository = new NeighborhoodRepository();

        // act
        NeighborhoodDTO received = neighborhoodRepository.getNeighborhoodByName(neighborhood.getName());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getNeighborhoodByNameWithException() {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        this.neighborhoodRepository = new NeighborhoodRepository();

        // assert
        assertThrows(NeighborhoodNotFoundException.class,() ->
                neighborhoodRepository.getNeighborhoodByName(neighborhood.getName()));
    }
}
