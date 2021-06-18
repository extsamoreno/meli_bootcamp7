package com.example.desafio2.integration;

import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.repositories.INeighborhoodRepository;
import com.example.desafio2.utils.TestUtilsGenerator;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NeighborhoodControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    INeighborhoodRepository iNeighborhoodRepository;

    @Test
    public void shouldCreateNeighborhood() throws Exception {
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Liniers");

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(neighborhood);

        when(iNeighborhoodRepository.saveNeighborhood(neighborhood)).thenReturn(neighborhood);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/neighborhood/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().json(payloadJson))
                .andExpect(status().isCreated());
    }
}
