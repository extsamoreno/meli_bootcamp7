package com.meli.desafio2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio2.UtilGenerator;
import com.meli.desafio2.dto.PropertyDTO;
import com.meli.desafio2.dto.PropertyInputDTO;
import com.meli.desafio2.repository.IPropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewPropertyTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IPropertyRepository propertyRepository;

    @Test
    public void succesfulNewProperty() throws Exception {
        String expected = "La propiedad Departamento1 ha sido registrada correctamente con el ID: 1.";
        PropertyInputDTO propertyInput = UtilGenerator.propertyInputHappy("Departamento1");
        PropertyDTO propertySave = UtilGenerator.propertyHappy("Departamento1");
        propertySave.setProp_id(-1);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String json = writer.writeValueAsString(propertyInput);

        when(propertyRepository.getDistrictByName("Amber")).thenReturn(UtilGenerator.districtHappy("Amber"));
        when(propertyRepository.newProperty(propertySave)).thenReturn(1);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/newproperty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        verify(propertyRepository,atLeastOnce()).newProperty(propertySave);
        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }
}
