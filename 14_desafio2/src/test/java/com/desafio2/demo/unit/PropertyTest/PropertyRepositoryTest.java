package com.desafio2.demo.unit.PropertyTest;

import com.desafio2.demo.exception.PropertyAlreadyExistException;
import com.desafio2.demo.exception.PropertyNotFoundException;
import com.desafio2.demo.model.Property;
import com.desafio2.demo.repository.PropertyRepository;
import com.desafio2.demo.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryTest {

    PropertyRepository propertyRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyFiles();

        this.propertyRepository = new PropertyRepository();
    }

    @Test
    public void savePropertyOk() throws PropertyAlreadyExistException {

        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Property expected = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        int id = 1;
        expected.setId(id);

        // act
        Property received = propertyRepository.saveProperty(property);

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void savePropertyWithException() {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");

        TestUtilGenerator.appendNewProperty(property);
        this.propertyRepository = new PropertyRepository();

        // assert
        assertThrows(PropertyAlreadyExistException.class,() -> propertyRepository.saveProperty(property));
    }

    @Test
    public void getPropertyByIdOk() throws PropertyNotFoundException {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        Property expected = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        TestUtilGenerator.appendNewProperty(property);
        this.propertyRepository = new PropertyRepository();

        // act
        Property received = propertyRepository.getPropertyById(property.getId());

        // assert
        assertEquals(expected, received);
    }

    @Test
    public void getPropertyByIdWithException() {
        // arrange
        Property property = TestUtilGenerator.getPropertyWith305SquareMeters("Casa1");
        this.propertyRepository = new PropertyRepository();

        // assert
        assertThrows(PropertyNotFoundException.class,() -> propertyRepository.getPropertyById(property.getId()));
    }
}
