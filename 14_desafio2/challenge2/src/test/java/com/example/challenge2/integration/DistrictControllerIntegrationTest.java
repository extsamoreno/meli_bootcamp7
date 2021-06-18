package com.example.challenge2.integration;


import com.example.challenge2.models.District;
import com.example.challenge2.repositories.IDistrictDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDistrictDAO districtDAO;

    @MockBean
    ModelMapper mapper;

    @Test
    public void createDistrict() throws Exception {
        District district = new District("Carrasco", 400.0);


        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(district);

        Mockito.when(districtDAO.save(district)).thenReturn(district);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/district/record")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().json(payloadJson))
                .andExpect(status().isCreated());
    }



}
