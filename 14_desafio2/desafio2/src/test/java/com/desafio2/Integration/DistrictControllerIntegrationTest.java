package com.desafio2.Integration;

import com.desafio2.Model.District;
import com.desafio2.Repository.IDistrctRepository;
import com.desafio2.Utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDistrctRepository iDistrctRepository;

    @Test
    public void createDistrict() throws Exception {
        District district = TestUtils.createWestDistrict100USD();
        Mockito.doNothing().when(iDistrctRepository).save(district);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(district);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/district/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk());
    }
}
