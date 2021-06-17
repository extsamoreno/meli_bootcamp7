package com.example.demo.unit.integration;

import com.example.demo.Utils;
import com.example.demo.services.dtos.PropertyRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addPropertyBadNameTest() throws Exception {


        PropertyRequestDTO payloadDTO = Utils.getPropertyRequestDTO();

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"));
               // .andExpect(MockMvcResultMatchers.jsonPath("$.prop_name").value("El nombre de la propiedad debe empezar con una mayuscula."));


        /*this.mockMvc.perform(MockMvcRequestBuilders.("/properties/property/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
        //.andExpect(content().contentType("application/json"));
        //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
                .andExpect(jsonPath("$.prop_name").value("El nombre de la propiedad debe empezar con una mayuscula."));
*/
    }

}
