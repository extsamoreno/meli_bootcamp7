package com.example.desafio2.unit;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.models.Property;
import com.example.desafio2.models.Room;
import com.example.desafio2.services.mappers.PropertyMapper;
import com.example.desafio2.services.mappers.RoomMapper;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyMapperTest {

    @Test
    public void toModelHappyPath() {
        Property prop = TestUtilsGenerator.getPropertyWith3Rooms("Property");
        PropertyDTO propDTO = TestUtilsGenerator.getPropertyDTOWith3Rooms("Property");

        Assertions.assertEquals(prop, PropertyMapper.toModel(propDTO));
    }
}
