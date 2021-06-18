package com.example.challenge_2.repository;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.PropertyNotFoundException;
import com.example.challenge_2.models.Property;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryTest {

    @InjectMocks
    PropertyRepository propertyRepository;

    @Test
    public void addTest() {
        //assert
        Property property = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();
        //act
        boolean result = propertyRepository.add(property);
        //arrange
        assertTrue(result);
    }

    @Test
    public void getByIdTest() throws PropertyNotFoundException {
        //assert

        //act
        Property result = propertyRepository.getById(1);

        //assert
        assertNotNull(result);
    }

    @Test
    public void getByIdPropertyNotFoundTest() {
        //assert

        //act

        //assert
        assertThrows(PropertyNotFoundException.class, () -> propertyRepository.getById(99));
    }
}
