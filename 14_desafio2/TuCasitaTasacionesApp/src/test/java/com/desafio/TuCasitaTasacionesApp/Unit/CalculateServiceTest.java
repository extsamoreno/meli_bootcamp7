package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.*;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.NeighborhoodNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.exceptions.PropietyNotFoundException;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import com.desafio.TuCasitaTasacionesApp.model.service.CalculateService;
import com.desafio.TuCasitaTasacionesApp.model.service.helpers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @Mock
    IPropietyRepository iPropietyRepository;

    @Mock
    PropertyMapper propertyMapper;

    @InjectMocks
    CalculateService calculateService;

    //hacer el tet para getPropiety

    @Test
    void getSquareMeterForPropiety_propietyNotFound_propietyNotFoundException(){
        when(iPropietyRepository.get("Dummy")).thenReturn(null);
        assertThrows(PropietyNotFoundException.class,() ->calculateService.getSquareMeterForPropiety("Dummy"));
        verify(iPropietyRepository, Mockito.atLeast(1)).get("Dummy");
    }

    @Test
    void getSquareMeterForPropiety_propietyFound_true() throws PropietyNotFoundException {

        String value = "Dummy";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(value, "Adrogue");
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(value, "Constitucion");

        when(iPropietyRepository.get(value)).thenReturn(propiety);
        when(propertyMapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        PropietyDTOResponseTotalMeters receive = calculateService.getSquareMeterForPropiety(value);

        verify(iPropietyRepository, Mockito.atLeast(1)).get(value);
        assertEquals(2, receive.getTotalMeters());
    }


    @Test
    void getValueForPropiety_propietyFound_true() throws PropietyNotFoundException, NeighborhoodNotFoundException {

        String neighborhood = "Constitucion";
        String name = "Dummy";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(propertyMapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        PropietyDTOResponseCost receive = calculateService.getValueForPropiety(name);

        verify(iPropietyRepository, Mockito.atLeast(1)).get(name);
        assertEquals(1000, receive.getCost());
    }

    @Test
    void getValueForPropiety_neighborhoodNotFound_NeighborhoodNotFoundException(){
        String neighborhood = "Adrogue";
        String name = "Dummy";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(propertyMapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        assertThrows(NeighborhoodNotFoundException.class,() ->calculateService.getValueForPropiety(name));
        verify(iPropietyRepository, Mockito.atLeast(1)).get(name);
    }

    @Test
    void getBiggestRoom_nameOfPropietyFound_bigRoomDTO() throws PropietyNotFoundException {
        String neighborhood = "Adrogue";
        String name = "Dummy";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1_1x2(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1_1x2(name, neighborhood);

        RoomDTO expected = new RoomDTO("room2", 1D, 2D);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(propertyMapper.mapToDTO(propiety)).thenReturn(propietyDTO);
        RoomDTO receive = calculateService.getBiggestRoom(name);

        verify(iPropietyRepository, Mockito.atLeast(1)).get(name);
        assertEquals(expected, receive);
    }

    @Test
    void getSquareMeterForRoom_nameOfPropietyFound_RoomMetersListResponseDTO() throws PropietyNotFoundException {
        String neighborhood = "Adrogue";
        String name = "Dummy";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1_1x2(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1_1x2(name, neighborhood);

        ArrayList<RoomMetersResponseDTO> roomList = new ArrayList<>();
        roomList.add(new RoomMetersResponseDTO("room1", 1D));
        roomList.add(new RoomMetersResponseDTO("room2", 2D));

        RoomMetersListResponseDTO expected = new RoomMetersListResponseDTO();
        expected.setRoomMetersResponseDTOList(roomList);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(propertyMapper.mapToDTO(propiety)).thenReturn(propietyDTO);
        RoomMetersListResponseDTO receive = calculateService.getSquareMeterForRoom(name);

        verify(iPropietyRepository, Mockito.atLeast(1)).get(name);
        assertEquals(expected.getList(), receive.getList());
    }

}