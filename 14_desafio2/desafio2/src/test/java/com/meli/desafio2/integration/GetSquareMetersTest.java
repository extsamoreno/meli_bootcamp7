package com.meli.desafio2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.PropertyFullDTO;
import com.meli.desafio2.dto.PropertySquareDTO;
import com.meli.desafio2.repository.IPropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetSquareMetersTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyRepository propertyRepository;

    @Test
    public void HappyPath() throws Exception {
        PropertySquareDTO property = UtilGenerator.propertySquareHappy("Departamento1");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String expected = writer.writeValueAsString(property);

        when(propertyRepository.getFullById(1)).thenReturn(UtilGenerator.propertyFullHappy("Departamento1"));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/squaremeters/{id}",1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json;charset=UTF-8"))
                        .andReturn();

        verify(propertyRepository,atLeastOnce()).getFullById(1);
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }
}