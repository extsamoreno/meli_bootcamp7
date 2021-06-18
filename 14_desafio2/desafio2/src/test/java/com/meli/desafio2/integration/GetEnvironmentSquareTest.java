package com.meli.desafio2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.PropertyAllSquareDTO;
import com.meli.desafio2.dto.PropertyBiggestEnvironmentDTO;
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
public class GetEnvironmentSquareTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyRepository propertyRepository;

    @Test
    public void HappyPath() throws Exception {
        PropertyAllSquareDTO property = UtilGenerator.propertyAllSquareHappy("Departamento1");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String expected = writer.writeValueAsString(property);

        when(propertyRepository.getById(1)).thenReturn(UtilGenerator.propertyHappy("Departamento1"));

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/environmentssquare/{id}",1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json;charset=UTF-8"))
                        .andReturn();

        verify(propertyRepository,atLeastOnce()).getById(1);
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }
}