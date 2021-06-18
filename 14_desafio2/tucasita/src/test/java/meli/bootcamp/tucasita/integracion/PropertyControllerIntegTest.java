package meli.bootcamp.tucasita.integracion;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.tucasita.model.Property;
import meli.bootcamp.tucasita.service.dto.ErrorDTO;
import meli.bootcamp.tucasita.service.dto.PropertyDTO;
import meli.bootcamp.tucasita.service.dto.PropertyResponseDTO;
import meli.bootcamp.tucasita.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testMetersAndCreatePropertyOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWith3Environments("Property Test");

        String payloadJson = writer.writeValueAsString(propertyDTO);
        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        PropertyResponseDTO expect= new PropertyResponseDTO(897.5D,null,propertyDTO);
        String expectJson = writer.writeValueAsString(expect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testPropertyNameNonCapitalLetterOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWith3Environments("property Test");

        String payloadJson = writer.writeValueAsString(propertyDTO);
        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ErrorDTO errorExpect= new ErrorDTO("MethodArgumentNotValidException","El nombre de la propiedad debe comenzar con mayúscula.");
        String expectJson = writer.writeValueAsString(errorExpect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testPropertyNameNullOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWith3Environments(null);

        String payloadJson = writer.writeValueAsString(propertyDTO);
        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ErrorDTO errorExpect= new ErrorDTO("MethodArgumentNotValidException","El nombre de la propiedad no puede estar vacío.");
        String expectJson = writer.writeValueAsString(errorExpect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void testPropertyNameOverMaxOutput() throws Exception {

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWith3Environments("Nombre de la propidad es demasiado largo");

        String payloadJson = writer.writeValueAsString(propertyDTO);
        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ErrorDTO errorExpect= new ErrorDTO("MethodArgumentNotValidException","La longitud del nombre no puede superar los 30 caracteres.");
        String expectJson = writer.writeValueAsString(errorExpect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
