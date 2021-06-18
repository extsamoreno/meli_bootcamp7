package com.desafiotesting.api.integration;

import com.desafiotesting.api.dto.*;
import com.desafiotesting.api.model.District;
import com.desafiotesting.api.repository.DistrictsRepository;
import com.desafiotesting.api.service.mapper.DistrictMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    DistrictMapper mapper;

    @MockBean
    DistrictsRepository repository;

    //////////////////////////////////////////////////////////////////////////////////
    // Tests for totalArea US 0001
    //////////////////////////////////////////////////////////////////////////////////

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

    //////////////////////////////////////////////////////////////////////////////////
    // Tests for price US 0002
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    public void priceHappyPath() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa1", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        PriceDTO responseDTO = new PriceDTO("Casa1", 18.0*100.0);

        District district = new District("Centro", 100.0);
        Map<String, District> districts = new HashMap<>();
        districts.put("Centro", district);

        Mockito.when(repository.getDistricts()).thenReturn(districts);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceDistrictNotFound() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa1", "Barrio Sur", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ErrorDTO responseDTO = new ErrorDTO("NotFoundDistrictException", "District not found!");

        District district = new District("Centro", 100.0);
        Map<String, District> districts = new HashMap<>();
        districts.put("Centro", district);

        Mockito.when(repository.getDistricts()).thenReturn(districts);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void pricePropertyNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void pricePropertyNameNoCapitalLetter() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void pricePropertyLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceDistrictNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceDistrictLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentNameNoCapitalLetter() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentWidthEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentLargeWidth() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentWidthLowerThanZero() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentLengthEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentLargeLength() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void priceEnvironmentLengthLowerThanZero() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    //////////////////////////////////////////////////////////////////////////////////
    // Tests for biggerEnvironment US 0003
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    public void biggerEnvironmentHappyPath() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa1", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        BiggerEnvironmentDTO responseDTO = new BiggerEnvironmentDTO("Habitacion");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentPropertyNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentPropertyNameNoCapitalLetter() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentPropertyLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentDistrictNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentDistrictLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentNameNoCapitalLetter() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentWidthEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentLargeWidth() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentWidthLowerThanZero() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentLengthEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentLargeLength() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void biggerEnvironmentEnvironmentLengthLowerThanZero() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/biggerEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    //////////////////////////////////////////////////////////////////////////////////
    // Tests for environmentsArea US 0004
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    public void environmentsAreaHappyPath() throws Exception {

        PropertyDTO payloadDTO = new PropertyDTO("Casa1", "Centro", new ArrayList<>(){
            {
                add(new EnvironmentDTO("Cocina", 3.0, 2.0));
                add(new EnvironmentDTO("Habitacion", 3.0, 4.0));
            }
        });

        ArrayList<EnvironmentAreaDTO> responseDTO = new ArrayList<>(){
            {   add(new EnvironmentAreaDTO("Cocina",6.0));
                add(new EnvironmentAreaDTO("Habitacion",12.0));
            }
        };

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaPropertyNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaPropertyNameNoCapitalLetter() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaPropertyLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaDistrictNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaDistrictLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentNameEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentNameNoCapitalLetter() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentLargeName() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentWidthEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentLargeWidth() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentWidthLowerThanZero() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentLengthEmpty() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentLargeLength() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void environmentsAreaEnvironmentLengthLowerThanZero() throws Exception {

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
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    //////////////////////////////////////////////////////////////////////////////////
    // Tests for newDistrict
    //////////////////////////////////////////////////////////////////////////////////

    @Test
    public void newDistrictHappyPath() throws Exception {

        DistrictDTO payloadDTO = new DistrictDTO("Cañitas",40.0);

        District district = new District("Centro", 100.0);
        Map<String, District> districts = new HashMap<>();
        districts.put("Centro", district);

        Mockito.when(repository.getDistricts()).thenReturn(districts);

        String responseDTO = "District Added to repository.";

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();
        Assertions.assertEquals(responseDTO, response.getResponse().getContentAsString());
    }

    @Test
    public void newDistrictNameEmpty() throws Exception {

        DistrictDTO payloadDTO = new DistrictDTO(null,40.0);

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The name of the district cant be empty.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void newDistrictLargeName() throws Exception {

        DistrictDTO payloadDTO = new DistrictDTO("superlargenameofdistrictsuperlargenameofdistrictsuperlargenameofdistrict",40.0);

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The length of the district name no can exceed 45 characters.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void newDistrictHighPrice() throws Exception {

        DistrictDTO payloadDTO = new DistrictDTO("Barrio",4000.1);

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The maximum price allowed per square meter no can exceed 4000 U$S.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

    @Test
    public void newDistrictNegativePrice() throws Exception {

        DistrictDTO payloadDTO = new DistrictDTO("Barrio",-1.0);

        ErrorDTO responseDTO = new ErrorDTO("MethodArgumentNotValidException",
                "The price cant be negative.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/newDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
    }

}
