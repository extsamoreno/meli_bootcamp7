package com.example.desafio2.unit;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.exceptions.NeighborhoodNotFoundException;
import com.example.desafio2.exceptions.PropertyAlreadyExistException;
import com.example.desafio2.exceptions.PropertyNotFoundException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.models.PropertyDTO;
import com.example.desafio2.repositories.PropertyRepository;
import com.example.desafio2.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryTests {

    PropertyRepository propertyRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyFiles();

        this.propertyRepository = new PropertyRepository();
    }

    @Test
    public void savePropertyOk() throws PropertyAlreadyExistException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        PropertyDTO expected = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        int id = 1; // because test database is empty and the util method set id in 9999
        expected.setId(id);

        // act
        PropertyDTO received = propertyRepository.saveProperty(property);

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void savePropertyWithException() {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");

        TestUtilsGenerator.appendNewProperty(property);
        this.propertyRepository = new PropertyRepository();

        // assert
        assertThrows(PropertyAlreadyExistException.class,() -> propertyRepository.saveProperty(property));
    }

    @Test
    public void saveNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        int id = 1; // because test database is empty and the util method set id in 9999
        expected.setId(id);

        // act
        NeighborhoodDTO received = propertyRepository.saveNeighborhood(neighborhood);

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void saveNeighborhoodWithException() {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");

        TestUtilsGenerator.appendNewNeighborhood(neighborhood);
        this.propertyRepository = new PropertyRepository();

        // assert
        assertThrows(NeighborhoodAlreadyExistException.class,() -> propertyRepository.saveNeighborhood(neighborhood));
    }

    @Test
    public void getPropertyByIdOk() throws PropertyNotFoundException {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        PropertyDTO expected = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        TestUtilsGenerator.appendNewProperty(property);
        this.propertyRepository = new PropertyRepository();

        // act
        PropertyDTO received = propertyRepository.getPropertyById(property.getId());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getPropertyByIdWithException() {
        // arrange
        PropertyDTO property = TestUtilsGenerator.getPropertyWith305SquareMeters("Casa de Madera");
        this.propertyRepository = new PropertyRepository();

        // assert
        assertThrows(PropertyNotFoundException.class,() -> propertyRepository.getPropertyById(property.getId()));
    }

    @Test
    public void getNeighborhoodByNameOk() throws NeighborhoodNotFoundException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        TestUtilsGenerator.appendNewNeighborhood(neighborhood);
        this.propertyRepository = new PropertyRepository();

        // act
        NeighborhoodDTO received = propertyRepository.getNeighborhoodByName(neighborhood.getName());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getNeighborhoodByNameWithException() {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");
        this.propertyRepository = new PropertyRepository();

        // assert
        assertThrows(NeighborhoodNotFoundException.class,() ->
                propertyRepository.getNeighborhoodByName(neighborhood.getName()));
    }
}
