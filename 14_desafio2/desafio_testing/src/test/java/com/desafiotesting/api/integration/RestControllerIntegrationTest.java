package com.desafiotesting.api.integration;

import com.desafiotesting.api.dto.EnvironmentDTO;
import com.desafiotesting.api.dto.ErrorDTO;
import com.desafiotesting.api.dto.PropertyDTO;
import com.desafiotesting.api.dto.TotalAreaDTO;
import com.desafiotesting.api.repository.DistrictsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import java.util.ArrayList;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DistrictsRepository repository;

    //////////////////////////////////////////////////////////////////////////////////
    // Tests for totalArea US 0001
    /////////////////////////////////////////////////////////////////////////////////

    @Test
    public void totalAreaHappyPath() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa1", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        TotalAreaDTO responseDTO = new TotalAreaDTO("Casa1",18.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaPropertyNameEmpty() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO(null, "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The name of the property it cant be empty.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaPropertyNameNoCapitalLetter() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The name of the property should start with capital letter.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaPropertyLargeName() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casaconmasdetreintacaracterescasaconmasdetreintacaracteres", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The length of the name no can exceed 30 characters.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaDistrictNameEmpty() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", null, new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The name of the district it cant be empty.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaDistrictLargeName() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "nombrededistrictoconmasde45caracteresnombrededistrictoconmasde45caracteres", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The length of the district name no can exceed 45 characters.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentNameEmpty() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO(null, 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The name of the environment it cant be empty.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentNameNoCapitalLetter() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The name of the environment should start with capital letter.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentLargeName() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Enviromentnamesizemore30enviromentnamesizemore30", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The length of the name no can exceed 30 characters.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentWidthEmpty() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", null, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The width of the environment it cant be empty.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentLargeWidth() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 26.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The maximum width allowed per property is 25 meters.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentWidthLowerThanZero() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", -1.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The width of the environment should not be negative");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentLengthEmpty() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 4.0, null));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The length of the environment it cant be empty.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentLargeLength() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 9.0, 33.1));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The maximum length allowed per property is 33 meters.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void totalAreaEnvironmentLengthLowerThanZero() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 6.0, -1.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The length of the environment should not be negative");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/totalArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }





}

