package com.meli.tu_casita.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.tu_casita.model.dto.RealStateOutDTO;
import com.meli.tu_casita.repository.IDistrictRepository;
import com.meli.tu_casita.repository.IEnvironmentRepository;
import com.meli.tu_casita.repository.IRealStateRepository;
import com.meli.tu_casita.service.IRealStateService;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RealStateControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IRealStateRepository realStateRepository;

    @MockBean
    IRealStateService realStateService;

    @MockBean
    IDistrictRepository districtRepository;

    @MockBean
    IEnvironmentRepository environmentRepository;

    @MockBean
    ModelMapper modelMapper;

    @Test
    public void getRealStateByNameTest() throws Exception {
        RealStateOutDTO expected = TestUtilGenerator.getRealStateOutDTO();
        Mockito.when(realStateService.getRealStateOutDTOByRealStateName(expected.getName())).thenReturn(expected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/realState/realStateByName/" + expected.getName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getRealStateByIdTest() throws Exception {
        RealStateOutDTO expected = TestUtilGenerator.getRealStateOutDTO();
        Mockito.when(realStateService.getRealStateOutDTOByRealStateId(expected.getId())).thenReturn(expected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/realState/realStateById/" + expected.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }
}
