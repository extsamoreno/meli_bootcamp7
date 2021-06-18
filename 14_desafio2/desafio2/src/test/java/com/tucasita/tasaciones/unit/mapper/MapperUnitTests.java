package com.tucasita.tasaciones.unit.mapper;

import com.tucasita.tasaciones.TestUtils.TestUtils;
import com.tucasita.tasaciones.project.models.Property;
import com.tucasita.tasaciones.project.services.Dto.PropertyDto;
import com.tucasita.tasaciones.project.services.mapper.mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MapperUnitTests {

    @Test
    public void mapperPropertyToDtoHappyPath(){
        //Arrange
        Property property = TestUtils.getNewProperty("Casa1");
        PropertyDto expected = TestUtils.getNewPropertyDto("Casa1");

        //Act
        PropertyDto response = mapper.propertyToDto(property);

        //Asserts
        Assertions.assertEquals(response,expected);
    }

    @Test
    public void mapperPropertyDtoToPropertyHappyPath(){
        //Arrange
        PropertyDto propertyDto = TestUtils.getNewPropertyDto("Casa1");
        Property expected = TestUtils.getNewProperty("Casa1");

        //Act
        Property response = mapper.propertyDtoToProperty(propertyDto);

        //Asserts
        Assertions.assertEquals(response,expected);
    }
}
