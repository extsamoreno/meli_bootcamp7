package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyAlreadyExistException;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import com.desafio.TuCasitaTasacionesApp.model.service.CrudService;
import com.desafio.TuCasitaTasacionesApp.model.service.helpers.CreateProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest {
    @Mock
    IPropietyRepository iPropietyRepository;

    @Mock
    PropertyMapper propertyMapper;

    @InjectMocks
    CrudService crudService;


    @Test
    void createPropiety_newPropiety_returnStringOk() throws PropietyAlreadyExistException {
        String expected = "La propiedad fue creada exitosamente";
        String value = "Dummy";

        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(value, "Constitucion");
        Propiety propiety1 = CreateProperties.create1HouseWith2Rooms1x1(value, "Constitucion");

        when(propertyMapper.mapToModel(propietyDTO)).thenReturn(propiety1);
        when(iPropietyRepository.create(propiety1)).thenReturn(true);

        String received = crudService.createPropiety(propietyDTO);

        verify(propertyMapper, Mockito.atLeast(1)).mapToModel(propietyDTO);
        verify(iPropietyRepository, Mockito.atLeast(1)).create(propiety1);
        assertEquals(expected,received);
    }


    @Test
    void createPropiety_newPropiety_propietyAlreadyExistException(){
        String value = "Dummy";
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(value, "Constitucion");
        Propiety propiety1 = CreateProperties.create1HouseWith2Rooms1x1(value, "Constitucion");

        when(propertyMapper.mapToModel(propietyDTO)).thenReturn(propiety1);
        when(iPropietyRepository.create(propiety1)).thenReturn(false);

        assertThrows(PropietyAlreadyExistException.class,() ->crudService.createPropiety(propietyDTO));
        verify(iPropietyRepository, Mockito.atLeast(1)).create(propiety1);
    }
}
