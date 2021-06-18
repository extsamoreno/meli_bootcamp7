package com.meli.desafio2.unit;

import com.meli.desafio2.exception.PropertyException;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.PropertyRepository;
import com.meli.desafio2.repository.PropertyRepositoryImpl;
import com.meli.desafio2.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyRepositoryTest {
    PropertyRepository propertyRepository;

    @BeforeEach
    public void setUp(){ this.propertyRepository = new PropertyRepositoryImpl(); }

    @Test
    public void save_success() throws PropertyException {
        //Arrange
        Property property = TestUtilGenerator.getProperty();

        //Act
        propertyRepository.save(property);

        //Assert
        Assertions.assertEquals(propertyRepository.getProperty(),property);
    }

    @Test
    public void getProperty_Success() throws PropertyException {
        save_success();
        Property expected = TestUtilGenerator.getProperty();

        //Act
        Property received = propertyRepository.getProperty();

        //Assert
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void getProperty_Exception() throws PropertyException {
        //Assert
        Assertions.assertThrows(PropertyException.class, () -> propertyRepository.getProperty());
    }


}