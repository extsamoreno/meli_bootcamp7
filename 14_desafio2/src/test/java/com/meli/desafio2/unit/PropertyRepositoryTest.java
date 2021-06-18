package com.meli.desafio2.unit;

import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.PropertyRepositoryImpl;
import com.meli.desafio2.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropertyRepositoryTest {
    PropertyRepositoryImpl propertyRepository;

    @BeforeEach
    public void setUp(){ this.propertyRepository = new PropertyRepositoryImpl(); }

    @Test
    public void save_success(){
        //Arrange
        Property property = TestUtilGenerator.getProperty();

        //Act
        propertyRepository.save(property);

        //Assert
        Assertions.assertEquals(propertyRepository.getProperty(),property);

    }
}