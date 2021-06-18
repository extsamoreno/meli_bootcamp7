package com.meli.tu_casita.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.tu_casita.exception.DistrictAlreadyExistsException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.repository.IDistrictRepository;
import com.meli.tu_casita.service.IDistrictService;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDistrictRepository districtRepository;

    @MockBean
    IDistrictService districtService;

    @MockBean
    ModelMapper modelMapper;

    @Test
    public void getDistrictListTest() throws Exception {
        List<DistrictDTO> expected = TestUtilGenerator.getDistrictDTOListTest();
        Mockito.when(districtService.getDistrictList()).thenReturn(expected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/district/districtList"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void newDistrictTestOK() throws Exception {
        DistrictDTO districtDTOExpected = TestUtilGenerator.getDistrictDTO();
        Mockito.when(districtRepository.findByName(districtDTOExpected.getName())).thenReturn(Optional.empty());

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payLoadJson = writer.writeValueAsString(districtDTOExpected);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/district/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void newDistrictTestDistrictAlreadyExistsException() throws Exception {
        DistrictDTO districtDTOExpected = TestUtilGenerator.getDistrictDTO();
        District district = TestUtilGenerator.getDistrict();
        Mockito.when(districtRepository.findByName(districtDTOExpected.getName())).thenReturn(Optional.of(district));
        Mockito.doThrow(new DistrictAlreadyExistsException(districtDTOExpected.getName())).when(districtService).saveDistrict(districtDTOExpected);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payLoadJson = writer.writeValueAsString(districtDTOExpected);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/district/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

}
