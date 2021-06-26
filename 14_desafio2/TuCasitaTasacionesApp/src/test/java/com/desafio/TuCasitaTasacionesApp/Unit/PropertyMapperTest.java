package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import com.desafio.TuCasitaTasacionesApp.model.service.helpers.CreateProperties;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PropertyMapperTest {

    PropertyMapper propertyMapper = new PropertyMapper();

    @Test
    public void mapToDTOHappyPath() {
        String value = "Dummy";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(value, "Constitucion");
        PropietyDTO expected = CreateProperties.create1HouseDTOWith2Rooms1x1(value, "Constitucion");
        PropietyDTO received = propertyMapper.mapToDTO(propiety);
        assertEquals(expected,received);
    }

    @Test
    public void mapToModelHappyPath() {
        String value = "Dummy";
        Propiety expected = CreateProperties.create1HouseWith2Rooms1x1(value, "Constitucion");
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(value, "Constitucion");
        Propiety received = propertyMapper.mapToModel(propietyDTO);
        // Esto sirve para testear el contenido del objeto, no la direccion de memoria
        Assert.assertTrue(new ReflectionEquals(expected, "roomList").matches(received));

    }

}
