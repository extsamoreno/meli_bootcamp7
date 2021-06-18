package meli.bootcamp.tucasita.integracion;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import meli.bootcamp.tucasita.service.dto.*;
import meli.bootcamp.tucasita.service.mapper.EnviromentMapper;
import meli.bootcamp.tucasita.service.mapper.PropertyDTOMapper;
import meli.bootcamp.tucasita.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegTest {

    @Autowired
    MockMvc mockMvc;


    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyPropertyFile();
        TestUtilsGenerator.emptyDistrictFile();
    }

    @Test
    public void testMetersAndCreatePropertyOutput() throws Exception {
        setUp();
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
        setUp();
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
        setUp();
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
        setUp();
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


    @Test
    public void testGetMeterPropertyByName() throws Exception {
        setUp();
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWith3Environments("Property Test");

        String payloadJson = writer.writeValueAsString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk());

        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/meters/{id}","Property Test")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        PropertyResponseDTO expect= new PropertyResponseDTO(897.5D,null,propertyDTO);
        String expectJson = writer.writeValueAsString(expect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testPropertyByNameNotFoundOutput() throws Exception {
        setUp();
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWith3Environments("property Not Found");

        String payloadJson = writer.writeValueAsString(propertyDTO);

        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/meters/{id}","property Not Found")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        ErrorDTO errorExpect= new ErrorDTO("PropertyNotFoundException",
                "La propiedad con nombre property Not Found no se encuentra registrada.");
        String expectJson = writer.writeValueAsString(errorExpect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testGetPricePropertyByName() throws Exception {
        setUp();
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = PropertyDTOMapper.toDTO(TestUtilsGenerator.getPropertyWith3EnvironmentsAndDistricName
                ("Property 1500 district","Other District"));

        String payloadJson = writer.writeValueAsString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk());

        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/price/{id}","Property 1500 district")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        PropertyResponseDTO expect= new PropertyResponseDTO(null,897.5D*1500,propertyDTO);
        String expectJson = writer.writeValueAsString(expect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void testGetLargerEnvironmentPropertyByName() throws Exception {
        setUp();
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = PropertyDTOMapper.toDTO(TestUtilsGenerator.getPropertyWith3EnvironmentsAndDistricName
                ("Property Test","District Test Over"));

        String payloadJson = writer.writeValueAsString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk());

        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/larger/{id}","Property Test")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        EnviromentResponseDTO expect= new EnviromentResponseDTO(propertyDTO.getProp_name(), EnviromentMapper.toDTOSquareMetersNull(propertyDTO.getEnvironments().get(1)));
        String expectJson = writer.writeValueAsString(expect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    public void testGetEnvironmentsWithSquareMetersPropertyByName() throws Exception {
        setUp();
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        PropertyDTO propertyDTO = PropertyDTOMapper.toDTO(TestUtilsGenerator.getPropertyWith3EnvironmentsAndDistricName
                ("Property Test","District Test Over"));
        propertyDTO.getEnvironments().remove(2);
        String payloadJson = writer.writeValueAsString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/meters")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk());

        MvcResult register = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/property/square-meters/{id}","Property Test")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        ArrayList<EnvironmentDTO> arrayExpected= new ArrayList<>();
        arrayExpected.add(new EnvironmentDTO("Sala",15.0,13.0,15.0*13));
        arrayExpected.add(new EnvironmentDTO("Comedor",25.0,20.3,20.3*25));
        EnviromentsMetersResponseDTO expect= new EnviromentsMetersResponseDTO(propertyDTO.getProp_name(), arrayExpected);
        String expectJson = writer.writeValueAsString(expect);
        Assertions.assertEquals(expectJson, register.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
