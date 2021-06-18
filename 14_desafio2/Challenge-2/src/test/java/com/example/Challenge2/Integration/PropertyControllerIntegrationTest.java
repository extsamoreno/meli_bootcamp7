package com.example.Challenge2.Integration;

import com.example.Challenge2.Controllers.PropertyController;
import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Repositories.IDataRepository;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IDataRepository iDataRepository;

    @Test
    public void getBiggestRoomHappyPath() throws Exception{
        Long id = 1L;
        Property property = TestUtilsGenerator.getPropertyWith100M2BiggestRoom(id);

        RoomDTO expectedRoom = RoomMapper.toDTO(property.getRooms().get(2));
        expectedRoom.setM2(100.0);
        Mockito.when(iDataRepository.getPropertyById(id)).thenReturn(property);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(expectedRoom);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/biggestRoom", id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getBiggestThrowsPropertyNotFoundExceptionTest() throws Exception {
        Long propertyId = 1L;

        ErrorDTO error = TestUtilsGenerator.getPropertyNotFoundError(propertyId);

        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(null);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(error);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/biggestRoom", propertyId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getValueHappyPath() throws Exception{
        Long propertyId = 1L;
        Long districtId = 1L;
        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        property.setDistrictId(districtId);

        District district = TestUtilsGenerator.get100USDollarsDistrict(districtId);

        ValueDTO expectedValue = new ValueDTO(5000.0);


        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);
        Mockito.when(iDataRepository.getDistrictById(districtId)).thenReturn(district);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(expectedValue);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/value", propertyId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getValueThrowsPropertyNotFoundExceptionTest() throws Exception {
        Long propertyId = 1L;

        ErrorDTO error = TestUtilsGenerator.getPropertyNotFoundError(propertyId);

        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(null);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(error);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/value", propertyId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getDimensionsHappyPath() throws Exception{
        Long propertyId = 1L;
        Property property = TestUtilsGenerator.get50MtProperty(propertyId);
        StructureDTO expectedStructure = new StructureDTO(50.0, property.getName());

        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(expectedStructure);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/dimensions", propertyId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getDimensionsThrowsPropertyNotFoundExceptionTest() throws Exception {
        Long propertyId = 1L;

        ErrorDTO error = TestUtilsGenerator.getPropertyNotFoundError(propertyId);

        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(null);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(error);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/dimensions", propertyId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getRoomsHappyPath() throws Exception{
        Long propertyId = 1L;
        Property property = TestUtilsGenerator.getPropertyWithTwo25MTsRooms(propertyId);

        StructureDTO structure1 = new StructureDTO(25.0, property.getRooms().get(0).getName());
        StructureDTO structure2 = new StructureDTO(25.0, property.getRooms().get(1).getName());

        List<StructureDTO> expectedStructures = Arrays.asList(structure1,structure2);

        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(property);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(expectedStructures);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/rooms", propertyId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getRoomsThrowsPropertyNotFoundExceptionTest() throws Exception {
        Long propertyId = 1L;

        PropertyNotFoundException e = new PropertyNotFoundException(propertyId);
        ErrorDTO error = TestUtilsGenerator.getPropertyNotFoundError(propertyId);

        Mockito.when(iDataRepository.getPropertyById(propertyId)).thenReturn(null);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(error);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/property/{propertyId}/rooms", propertyId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void storeHappyPath() throws Exception{
        Long propertyId = 1L;
        PropertyDTO property = PropertyMapper.toDTO(TestUtilsGenerator.getPropertyWithTwo25MTsRooms(propertyId));

        District district = TestUtilsGenerator.get100USDollarsDistrict(property.getDistrictId());

        Mockito.when(iDataRepository.getAllProperties()).thenReturn(new ArrayList<>());
        Mockito.when(iDataRepository.getDistrictById(district.getId())).thenReturn(district);



        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(true);

        String payLoadJson = writer.writeValueAsString(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/property")
                .contentType("application/json")
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void storeThrowsDistrictNotFoundExceptionTest() throws Exception{
        Long propertyId = 1L;
        PropertyDTO property = PropertyMapper.toDTO(TestUtilsGenerator.getPropertyWithTwo25MTsRooms(propertyId));

        Mockito.when(iDataRepository.getAllProperties()).thenReturn(new ArrayList<>());
        Mockito.when(iDataRepository.getDistrictById(property.getDistrictId())).thenReturn(null);

        ErrorDTO error = TestUtilsGenerator.getDistrictNotFoundError(property.getDistrictId());

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer();
        String responseJson = writer.writeValueAsString(error);

        String payLoadJson = writer.writeValueAsString(property);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/property")
                .contentType("application/json")
                .content(payLoadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());
    }
}