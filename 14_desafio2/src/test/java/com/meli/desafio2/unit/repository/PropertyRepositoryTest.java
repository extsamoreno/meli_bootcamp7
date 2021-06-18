package com.meli.desafio2.unit.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.DistrictRepository;
import com.meli.desafio2.repository.IDistrictRepository;
import com.meli.desafio2.repository.IPropertyRepository;
import com.meli.desafio2.repository.PropertyRepository;
import com.meli.desafio2.util.TestUtilsGen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryTest {

    IPropertyRepository propertyRepository;
    IDistrictRepository districtRepository;

    @BeforeEach
    private void setUp(){
        this.propertyRepository = new PropertyRepository();
    }

    // Property exists
    @Test
    public void getPropertybyIdExists() throws PropertyIdNotFoundException {

        // Arrange
        int propId = 2;
        Property prop = TestUtilsGen.getPropWithId(propId);

        // Act
        Property responseProp = propertyRepository.getPropertybyId(propId);

        // Assert
        Assertions.assertEquals(prop, responseProp);
    }

    // Property not exists
    @Test
    public void getPropertyByIdNonExists() {

        // Arrange
        int propId = 100;
        Property prop = TestUtilsGen.getPropWithId(propId);

        // Act & Assert
        Assertions.assertThrows(PropertyIdNotFoundException.class,() -> propertyRepository.getPropertybyId(prop.getId()));
    }

    // Property id already exists
    @Test
    public void createAlreadyExistsProperty() {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);

        // Act & Assert
        Assertions.assertThrows(PropertyIdAlreadyExistException.class,() -> propertyRepository.createProperty(prop));
    }
}
