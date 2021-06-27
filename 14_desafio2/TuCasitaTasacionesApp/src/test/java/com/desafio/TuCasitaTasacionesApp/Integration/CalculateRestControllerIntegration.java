package com.desafio.TuCasitaTasacionesApp.Integration;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import com.desafio.TuCasitaTasacionesApp.model.service.helpers.CreateProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PropertyMapper mapper;

    @MockBean
    IPropietyRepository iPropietyRepository;

    @Test
    public void getSquareMeterForPropietyHappyPath() throws Exception {
        String name = "Dummy";
        String neighborhood = "Constitucion";

        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(mapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiety/calculate/squearemeter?name=Dummy", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"totalMeters\":2.0}")))
                .andReturn();
    }

    @Test
    public void getValueForPropietyHappyPath() throws Exception {
        String name = "Dummy";
        String neighborhood = "Constitucion";

        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(mapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiety/calculate/value?name=Dummy", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"cost\":1000.0}")))
                .andReturn();
    }

    @Test
    public void getBiggestRoomHappyPath() throws Exception {
        String name = "Dummy";
        String neighborhood = "Constitucion";

        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(mapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiety/room/obtainbiggest?name=Dummy", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"name\":\"RoomUno\",\"width\":1.0,\"lenght\":1.0}")))
                .andReturn();
    }

    @Test
    public void getSquareMeterForRoomHappyPath() throws Exception {
        String name = "Dummy";
        String neighborhood = "Constitucion";

        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);

        when(iPropietyRepository.get(name)).thenReturn(propiety);
        when(mapper.mapToDTO(propiety)).thenReturn(propietyDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/propiety/room/calculate/squearemeter?name=Dummy", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"list\":[{\"name\":\"RoomUno\",\"meter\":1.0},{\"name\":\"RoomDos\",\"meter\":1.0}]}")))
                .andReturn();
    }


}




