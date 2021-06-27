package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.controllers.PropietyRestController;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyAlreadyExistException;
import com.desafio.TuCasitaTasacionesApp.model.service.ICrudService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropietyRestControllerIntegrationTest {
    @Mock
    ICrudService iCrudService;

    @InjectMocks
    PropietyRestController propietyRestController;

    @Test
    void addNewPropietyHappyPath() throws PropietyAlreadyExistException {
        //arrange
        String expected = "La propiedad fue creada exitosamente";

        PropietyDTO propietyDTOAux = new PropietyDTO();
        propietyDTOAux.setName("Ownership Dummy");
        propietyDTOAux.setNeighborhood("Adrogue");
        propietyDTOAux.setRoomList(new ArrayList<>());

        when(iCrudService.createPropiety(propietyDTOAux)).thenReturn("La propiedad fue creada exitosamente");

        //act
        ResponseEntity<String> receive = propietyRestController.addNewPropiety(propietyDTOAux);

        //assert
        verify(iCrudService, Mockito.atLeast(1)).createPropiety(propietyDTOAux);
        assertEquals(receive.getBody(), expected);

    }
}
