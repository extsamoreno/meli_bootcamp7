package com.bootcamp.desafio2.integration;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.repository.district.IDistrictRepository;
import com.bootcamp.desafio2.repository.house.IHouseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ITControllerService {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IHouseRepository houseRepository;

    @MockBean
    IDistrictRepository districtRepository;

    @Mock
    ModelMapper mapper;


    @Test
    public void testGetFeaturesHouseTotalArea() throws Exception {

        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Double expectedTotalArea = 24.0;

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/features/{prop_name}", "Casa101"))
                .andDo(print()) .andExpect( status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("total_area").value(24.0));
    }

    @Test
    public void testGetFeaturesHousePrice() throws Exception {

        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Double expectedPrice = 12000.0;

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/features/{prop_name}", "Casa101"))
                .andDo(print()) .andExpect( status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(12000.0));
    }

    @Test
    public void testGetFeaturesHouseBiggestEnvironment() throws Exception {

        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        EnvironmentShortDTO expected_biggest_environment = new EnvironmentShortDTO("Room1", 15.0);

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/features/{prop_name}", "Casa101"))
                .andDo(print()) .andExpect( status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("biggest_environment").value(expected_biggest_environment));
    }

    @Test
    public void testGetFeaturesHouseProp_Name() throws Exception {

        String prop_name = "Casa101";
        String district_name = "Santa Fe";
        House modelHouse = UtilsGenerator.genererateHouse();

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);
        Mockito.when( districtRepository.existsDistrictInDB(district_name) ).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/features/{prop_name}", "Casa101"))
                .andDo(print()) .andExpect( status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers .jsonPath("prop_name").value(prop_name));
    }

    @Test
    public void testGetFEnvironmentList() throws Exception {

        String prop_name = "Casa101";
        House modelHouse = UtilsGenerator.genererateHouse();
        ArrayList<EnvironmentShortDTO> expectedList = UtilsGenerator.showEnvironmentListCasa101() ;

        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(expectedList);

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(true);
        Mockito.when(houseRepository.findHouseByPropName(prop_name)).thenReturn(modelHouse);

        MvcResult mvcResult =
        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/environments/{prop_name}", "Casa101"))
                .andDo(print()) .andExpect( status().isOk())
                .andExpect(content().contentType("application/json"))
                //.andExpect(content().string(String.valueOf(expectedList)))
                //.andExpect(MockMvcResultMatchers.jsonPath("").value(expected));
                //.andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedList)));
                .andReturn();

        Assertions.assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testRegisterPropertySuccessfully() throws Exception {

        String prop_name = "Apto101";
        String district_name = "Palermo";
        double district_price = 1000.0;
        HouseDTO newHouseDTO = UtilsGenerator.generateNewHouseDTO();
        House newHouse = UtilsGenerator.genererateNewModelHouse();

        ObjectWriter writer =
                new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer()
                        .withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(newHouseDTO);

        Mockito.when(houseRepository.existsPropertyName(prop_name)).thenReturn(false);
        Mockito.when(districtRepository.existsDistrictInDB(district_name)).thenReturn(true);
        Mockito.when(mapper.map(newHouseDTO, House.class)).thenReturn(newHouse);
        Mockito.when(districtRepository.getDistrictPrice(district_name)).thenReturn(district_price);
        Mockito.doNothing().when(houseRepository).saveNewProperty(newHouse);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/registerProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }


}
