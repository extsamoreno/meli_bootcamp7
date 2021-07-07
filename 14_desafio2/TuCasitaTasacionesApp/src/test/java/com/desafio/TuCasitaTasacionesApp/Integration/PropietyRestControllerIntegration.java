package com.desafio.TuCasitaTasacionesApp.Integration;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.IPropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.dto.PropietyDTO;
import com.desafio.TuCasitaTasacionesApp.model.mapper.PropertyMapper;
import com.desafio.TuCasitaTasacionesApp.model.service.helpers.CreateProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropietyRestControllerIntegration {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PropertyMapper propertyMapper;

    @MockBean
    IPropietyRepository iPropietyRepository;

    static ObjectWriter createWriter() {
        return new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    public void addNewPropietyHappyPath() throws Exception {
        String name = "PropUno";
        String neighborhood = "Constitucion";

        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);
        String jsonRequestDTO = createWriter().writeValueAsString(propietyDTO);

        when(propertyMapper.mapToModel(propietyDTO)).thenReturn(propiety);
        when(iPropietyRepository.create(propiety)).thenReturn(Optional.of(propiety));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/propieties/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"))
                //.andExpect(content().string(containsString("La propiedad fue creada exitosamente")))
                .andReturn();
    }

    @Test
    public void addNewPropiety_PropertyNoAdmited_ThrowException() throws Exception {
        String name = "propUno";
        String neighborhood = "Constitucion";

        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyDTO propietyDTO = CreateProperties.create1HouseDTOWith2Rooms1x1(name, neighborhood);
        String jsonRequestDTO = createWriter().writeValueAsString(propietyDTO);

        when(propertyMapper.mapToModel(propietyDTO)).thenReturn(propiety);
        when(iPropietyRepository.create(propiety)).thenReturn(Optional.of(propiety));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/propieties/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(content().string(containsString("El nombre de la propiedad debe comenzar con mayuscula y no poseer numeros ni caracteres")))
                .andReturn();
    }
}
