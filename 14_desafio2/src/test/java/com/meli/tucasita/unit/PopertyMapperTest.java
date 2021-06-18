package com.meli.tucasita.unit;

import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.mapper.PropertyMapper;
import com.meli.tucasita.models.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meli.tucasita.util.TestUtils.createProperty;
import static com.meli.tucasita.util.TestUtils.createPropertyDTO;

@ExtendWith(MockitoExtension.class)
public class PopertyMapperTest {

    @Test
    void mapPropertyFromDtoOk(){

        // Arrange
        PropertyDTO propertyDTO = createPropertyDTO();
        Property expected = createProperty();

        // Act
        Property actual = PropertyMapper.mapPropertyFromDTO(propertyDTO);

        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
