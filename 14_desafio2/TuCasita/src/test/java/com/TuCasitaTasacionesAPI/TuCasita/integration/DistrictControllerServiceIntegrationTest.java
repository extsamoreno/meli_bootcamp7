package com.TuCasitaTasacionesAPI.TuCasita.integration;

import com.TuCasitaTasacionesAPI.TuCasita.UtilsDataTests;
import com.TuCasitaTasacionesAPI.TuCasita.dtos.DistrictDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.models.District;
import com.TuCasitaTasacionesAPI.TuCasita.repositories.IDistrictRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerServiceIntegrationTest {

    @MockBean
    IDistrictRepository iDistrictRepository;

    @MockBean
    ModelMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createHappyPath() throws Exception {

        DistrictDTO districtDTO = UtilsDataTests.generateDistrictDTO();
        District district = UtilsDataTests.generateDistrict();
        int id = district.getDistrict_id();

        when(iDistrictRepository.checkDistrictExists(district)).thenReturn(false);
        when(mapper.map(districtDTO, District.class)).thenReturn(district);
        when(iDistrictRepository.create(district)).thenReturn(id);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseExpected = writer.writeValueAsString(id);
        String responseToSend = writer.writeValueAsString(districtDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/district/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseToSend))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string(responseExpected)).andReturn();

    }

    @Test
    public void createWithDistrictThatAlreadyExist() throws Exception {

        DistrictDTO districtDTO = UtilsDataTests.generateDistrictDTO();
        District district = UtilsDataTests.generateDistrict();
        int id = district.getDistrict_id();
        DistrictAlreadyExistsException ex = new DistrictAlreadyExistsException("Prueba District");

        when(iDistrictRepository.checkDistrictExists(district)).thenReturn(true);
        when(mapper.map(districtDTO, District.class)).thenReturn(district);
        when(iDistrictRepository.create(district)).thenReturn(id);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseExpected = writer.writeValueAsString(ex.getError());
        String responseToSend = writer.writeValueAsString(districtDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/district/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(responseToSend))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(result -> assertEquals(responseExpected, result.getResponse().getContentAsString()))
                .andReturn();
    }
}
