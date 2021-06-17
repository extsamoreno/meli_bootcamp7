package com.example.Challenge2.Services.Mappers;

import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.DistrictDTO;
import com.example.Challenge2.Services.DTOs.PropertyDTO;
import com.example.Challenge2.Services.Mapper.DistrictMapper;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PropertyMapperTest {

    @Test
    public void toDTOTest(){
        Long id = 1L;
        Property property = TestUtilsGenerator.get50MtProperty(id);
        PropertyDTO expectedPropertyDTO = new PropertyDTO(property.getName(), RoomMapper.toDTOs(property.getRooms()), property.getDistrictId());

        PropertyDTO propertyDTO = PropertyMapper.toDTO(property);

        assertEquals(propertyDTO,expectedPropertyDTO);
    }

    @Test
    public void toPropertyTest(){

        Property expectedProperty = TestUtilsGenerator.get50MtProperty(null);

        PropertyDTO propertyDTO = new PropertyDTO(expectedProperty.getName(), RoomMapper.toDTOs(expectedProperty.getRooms()), expectedProperty.getDistrictId());


        Property property = PropertyMapper.toProperty(propertyDTO);

        assertEquals(expectedProperty,property);
    }
}
