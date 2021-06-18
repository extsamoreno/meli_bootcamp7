package com.example.tucasita.integration;

import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.DistrictDAO;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DistrictDAO districtDAO;

    @Test
    public void testAddOneDistrict() throws Exception {
        //ARRANGE
        DistrictDTO district = new DistrictDTO("Almagro", 300.00);
        ResponseDTO response = new ResponseDTO(201, "El barrio se ha agregado con éxito al repositorio local");
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(district);
        String responseJson = writer.writeValueAsString(response);

        Mockito.doNothing().when(districtDAO).create(district);

        //ACT

        //ASSERT
        this.mockMvc.perform(MockMvcRequestBuilders.post("/districts/addOne")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().json(responseJson))
                .andExpect(status().isCreated());
    }

}
