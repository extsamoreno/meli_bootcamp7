package com.example.demo.integration;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IHouseRepository;
import com.example.demo.service.dto.HouseDTO;
import com.example.demo.service.dto.ResponseHouseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IHouseRepository iHouseRepository;
    @MockBean
    IDistrictRepository iDistrictRepository;
    @Test
    public void calculateAllRequirements() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Cañiza",environments);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cocina 12.0");
        arrayList.add("Sala 20.0");
        arrayList.add("Habitacion 16.0");
        District district = new District("Cañiza",200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(house.getDistric_name())).thenReturn(district);
        JSONParser jsonParser= new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray listJson = (JSONArray) jsonParser.parse(objectMapper.writeValueAsString(arrayList));
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/calculate/{name}","Casa 1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casa 1"))
                .andExpect(jsonPath("$.squareMeter").value(48))
                .andExpect(jsonPath("$.price").value(9600))
                .andExpect(jsonPath("$.biggestEnvironment").value("El ambiente más grande es Sala con un área de 20.0"))
                .andExpect(jsonPath("$.listEnvironment").value(Matchers.containsInAnyOrder(listJson.toArray())))
                .andReturn();
    }
    @Test
    public void getM2() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Cañiza",environments);
        District district = new District("Cañiza",200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(house.getDistric_name())).thenReturn(district);
        JSONParser jsonParser= new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        ObjectMapper objectMapper = new ObjectMapper();


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/calculate/{name}","Casa 1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casa 1"))
                .andExpect(jsonPath("$.squareMeter").value(48))
                .andReturn();
    }
    @Test
    public void getPrice() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Cañiza",environments);
        District district = new District("Cañiza",200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(house.getDistric_name())).thenReturn(district);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/price/{name}","Casa 1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casa 1"))
                .andExpect(jsonPath("$.price").value(9600))
                .andReturn();
    }
    @Test
    public void getBiggestEnvironment() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Cañiza",environments);
        District district = new District("Cañiza",200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(house.getDistric_name())).thenReturn(district);


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/biggestEnvironment/{name}","Casa 1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casa 1"))
                .andExpect(jsonPath("$.biggestEnvironment").value("El ambiente más grande es Sala con un área de 20.0"))
                .andReturn();
    }
    @Test
    public void getListEnvironment() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Cañiza",environments);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Cocina 12.0");
        arrayList.add("Sala 20.0");
        arrayList.add("Habitacion 16.0");
        District district = new District("Cañiza",200);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(house.getDistric_name())).thenReturn(district);
        JSONParser jsonParser= new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray listJson = (JSONArray) jsonParser.parse(objectMapper.writeValueAsString(arrayList));


        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/listenvironment/{name}","Casa 1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("Casa 1"))
                .andExpect(jsonPath("$.listEnvironment").value(Matchers.containsInAnyOrder(listJson.toArray())))
                .andReturn();
    }
    @Test
    public void calculateAllRequirementsHouseNotFoundException() throws Exception {
        String name = "Casa 9";
        Mockito.when(iHouseRepository.findHouseByName(name)).thenThrow(new HouseNotFoundException(name));
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/calculate/{name}","Casa 9"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("La casa con nombre " + name + " no ha sido encontrada por favor agregarla"))
                .andExpect(jsonPath("$.name").value(HouseNotFoundException.class.getSimpleName()))
                .andReturn();
    }
    @Test
    public void calculateAllRequirementsDistrictNotFoundException() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"No existe",environments);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        Mockito.when(iDistrictRepository.findDistrictByName(house.getDistric_name())).thenThrow(new DistrictNotFoundException(house.getDistric_name()));
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/house/calculate/{name}","Casa 1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El barrio " + house.getDistric_name() + " no existe"))
                .andExpect(jsonPath("$.name").value(DistrictNotFoundException.class.getSimpleName()))
                .andReturn();
    }


}
