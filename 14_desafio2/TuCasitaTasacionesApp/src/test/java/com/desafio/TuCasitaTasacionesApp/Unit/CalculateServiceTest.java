package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.models.Room;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseCost;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseTotalMeters;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    //@Mock Mapper
    /*
    Tuve un problema que me hizo atrasar muchisimo, el mock en el service no lo habia inyectado y eso generaba que no
    pudiera mockear el repositorio. Lo que termine haciendo fue inyectando el moc
     */
    @Mock
    IPropietyRepository iPropietyRepository;

    @InjectMocks
    CalculateService calculateService;

    public Propiety createRepoWith1House(String name, String neighborhood){

        Room roomDTO1 = new Room("hab1", 1D, 1D);
        Room roomDTO2 = new Room("hab1", 1D, 1D);
        List<Room> roomList = new ArrayList<>();
        roomList.add(roomDTO1);
        roomList.add(roomDTO2);

        Propiety propietyAux = new Propiety();
        propietyAux.setName(name);
        propietyAux.setNeighborhood(neighborhood);
        propietyAux.setRoomList(roomList);

        return propietyAux;
    }


    @Test
    void getSquareMeterForPropiety_propietyNotFound_propietyNotFoundException(){
        when(iPropietyRepository.get("Dummy")).thenReturn(null);
        assertThrows(PropietyNotFoundException.class,() ->calculateService.getSquareMeterForPropiety("Dummy"));
        verify(iPropietyRepository, Mockito.atLeast(1)).get("Dummy");
    }

    @Test
    void getSquareMeterForPropiety_propietyFound_true() throws PropietyNotFoundException {

        String value = "Dummy";
        Propiety propiety = createRepoWith1House(value, "Adrogue");

        when(iPropietyRepository.get(value)).thenReturn(propiety);

        PropietyDTOResponseTotalMeters receive = calculateService.getSquareMeterForPropiety(value);

        verify(iPropietyRepository, Mockito.atLeast(1)).get(value);
        assertEquals(2, receive.getTotalMeters());
    }


    @Test
    void getValueForPropiety_propietyFound_true() throws PropietyNotFoundException, NeighborhoodNotFoundException {

        String neighborhood = "Constitucion";
        String name = "Dummy";
        Propiety propiety = createRepoWith1House("Dummy", neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);

        PropietyDTOResponseCost receive = calculateService.getValueForPropiety(name);

        verify(iPropietyRepository, Mockito.atLeast(1)).get(name);
        assertEquals(1000, receive.getCost());
    }


}