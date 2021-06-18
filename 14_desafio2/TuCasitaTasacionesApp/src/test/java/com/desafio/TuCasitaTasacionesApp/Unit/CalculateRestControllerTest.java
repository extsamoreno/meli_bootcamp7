package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.RequestTestCase;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTOResponseTotalMeters;
import com.desafio.TuCasitaTasacionesApp.model.service.ICalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculateRestControllerTest extends RequestTestCase {

    @MockBean
    ICalculateService iCalculateService;

    //@InjectMocks
    //CalculateRestController calculateRestController;

    @Test
    void getSquareMeterForPropietyHappyPath() throws Exception {
/*
        Double expected = 2D;
        RoomDTO roomDTO1 = new RoomDTO("hab1", 1D, 1D);
        RoomDTO roomDTO2 = new RoomDTO("hab1", 1D, 1D);
        List<RoomDTO> roomDTOList = new ArrayList<>();
        roomDTOList.add(roomDTO1);
        roomDTOList.add(roomDTO2);

        PropietyDTO propietyDTOAux = new PropietyDTO();
        propietyDTOAux.setName("Ownership Dummy");
        propietyDTOAux.setNeighborhood("Adrogue");
        propietyDTOAux.setRoomList(roomDTOList);

        PropietyDTOResponseTotalMeters propietyDTOResponseTotalMeters = new PropietyDTOResponseTotalMeters(2);
        when(iCalculateService.getSquareMeterForPropiety(propietyDTOAux.getName())).thenReturn(propietyDTOResponseTotalMeters);

        PropietyDTOResponseTotalMeters receive;
        receive = iCalculateService.getSquareMeterForPropiety(propietyDTOAux.getName());

        verify(iCalculateService, Mockito.atLeast(1)).getSquareMeterForPropiety(propietyDTOAux.getName());
        assertEquals(expected, receive.getTotalMeters());
    */

        when(iCalculateService.getSquareMeterForPropiety(any(String.class))).thenReturn(new PropietyDTOResponseTotalMeters(2));

        assertRequest("GET", "/propiety/calculate/squearemeter?name=PropUno", 200);
    }

/*
    @Test
    void getValueForPropietyHappyPath(){

    }
/*
    @Test
    void getBiggestRoomHappyPath{

    }

    @Test
    void getSquareMeterForRoomHappyPath{

    }*/
}
