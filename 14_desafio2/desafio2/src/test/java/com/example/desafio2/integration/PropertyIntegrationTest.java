package com.example.desafio2.integration;

import com.example.desafio2.dtos.*;
import com.example.desafio2.models.District;
import com.example.desafio2.models.Property;
import com.example.desafio2.repositories.IDistrictRepository;
import com.example.desafio2.repositories.IPropertyRepository;
import com.example.desafio2.services.mappers.PropertyMapper;
import com.example.desafio2.services.utils.PropertyUtil;
import com.example.desafio2.util.TestUtilsGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @MockBean
    IDistrictRepository iDistrictRepository;

    @Test
    public void addPropertyHappyPath() throws Exception {
        //arrange
        int expected = 1;
        PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith3Rooms("AddIntegrationTestHouse");
        Mockito.when(iPropertyRepository.add(PropertyMapper.toModel(prop))).thenReturn(expected);
        Mockito.when(iDistrictRepository.getById(prop.getDistrictId())).thenReturn(new District("districtName",500));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String propJson = writer.writeValueAsString(prop);
        //act

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/add")
                    .contentType("application/json")
                    .content(propJson))
                .andDo(print()).andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void addPropertyDistrictIdNotValidShouldThrowDistrictIdNotValidException() throws Exception {
        int propId = 1;
        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetBiggestRoomTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);
        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);
        Mockito.when(iDistrictRepository.getById(prop.getDistrictId())).thenReturn(null);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String propJson = writer.writeValueAsString(prop);
        //act

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/add")
                .contentType("application/json")
                .content(propJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("DistrictIdNotValidException"))
                .andReturn();
    }

    @Test
    public void getAreaHappyPath() throws Exception {
        int propId = 1;
        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetBiggestRoomTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);
        AreaDTO area = new AreaDTO(propId, PropertyUtil.getArea(prop));
        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(area);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/area",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }

    @Test
    public void getAreaInvalidIdShouldThrowPropertyIdNotValidException() throws Exception {
        int propId = 1;

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/area",propId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("PropertyIdNotValidException"))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }


    @Test
    public void getPriceHappyPath() throws Exception {
        int propId = 1;
        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetBiggestRoomTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);
        PriceDTO price = new PriceDTO(propId, 450);
        District district = new District("District", 10);
        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);
        Mockito.when(iDistrictRepository.getById(prop.getDistrictId())).thenReturn(district);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(price);

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/price",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).getById(prop.getDistrictId());
    }

    @Test
    public void getPriceInvalidIdShouldThrowPropertyIdNotValidException() throws Exception {
        int propId = 1;

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/price",propId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("PropertyIdNotValidException"))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }


    @Test
    public void getBiggestRoomHappyPath() throws Exception {
        int propId = 1;
        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetBiggestRoomTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);
        RoomDTO room = new RoomDTO("Living",5.0,6.0);
        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(room);

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/rooms/biggest",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }

    @Test
    public void getBiggestRoomInvalidIdShouldThrowPropertyIdNotValidException() throws Exception {
        int propId = 1;

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/rooms/biggest",propId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("PropertyIdNotValidException"))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }

    @Test
    public void getAreaPerRoomHappyPath() throws Exception {
        int propId = 1;
        Property prop = TestUtilsGenerator.getPropertyWith3RoomsDetailed("GetBiggestRoomTestingHouse",
                "Living",5.0,6.0,
                "Bedroom",2.0,3.0,
                "Kitchen",3.0,3.0);
        List<RoomAreaDTO> roomAreaDTOList = new ArrayList<>();
        roomAreaDTOList.add(new RoomAreaDTO("Living", 30));
        roomAreaDTOList.add(new RoomAreaDTO("Bedroom", 6));
        roomAreaDTOList.add(new RoomAreaDTO("Kitchen", 9));

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(roomAreaDTOList);

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(prop);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/rooms/area",propId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(responseJson)))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }

    @Test
    public void getAreaPerRoomInvalidIdShouldThrowPropertyIdNotValidException() throws Exception {
        int propId = 1;

        Mockito.when(iPropertyRepository.getPropertyById(propId)).thenReturn(null);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/{propertyId}/rooms/area",propId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("PropertyIdNotValidException"))
                .andReturn();

        Mockito.verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyById(propId);
    }
}
