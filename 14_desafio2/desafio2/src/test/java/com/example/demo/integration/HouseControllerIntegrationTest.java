package com.example.demo.integration;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.ExistingHouseException;
import com.example.demo.exception.HouseNotFoundException;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IHouseRepository;
import com.example.demo.service.dto.DistrictDTO;
import com.example.demo.service.dto.HouseDTO;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HouseControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IHouseRepository iHouseRepository;
    @Test
    public void addNewHouse() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        HouseDTO houseDTO = new HouseDTO(name,"Cañiza",environments);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenThrow(new HouseNotFoundException(name));
        mockMvc.perform(MockMvcRequestBuilders.post("/house/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(houseDTO)))
                .andExpect(status().isOk());
    }
    @Test
    public void addNewHouseExistingHouseException() throws Exception {
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        environments.add(new Environment("Cocina",3,4));
        environments.add(new Environment("Sala",5,4));
        environments.add(new Environment("Habitacion",4,4));
        House house = new House(name,"Cañiza",environments);
        Mockito.when(iHouseRepository.findHouseByName(name)).thenReturn(house);
        mockMvc.perform(MockMvcRequestBuilders.post("/house/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(house)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("La casa con nombre "+name+" ya existe, no puede existir dos casas con el mismo nombre"))
                .andExpect(jsonPath("$.name").value(ExistingHouseException.class.getSimpleName()));
    }
    @Test
    public void addNewHouseValidLongName() throws Exception {
        //asserrt
        String name= "Nombre1234567890123456789012345678901234567890";
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setProp_name(name);
        mockMvc.perform(MockMvcRequestBuilders.post("/house/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(houseDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.prop_name").value("La longitud del nombre no puede superar los 30 caracteres"));
    }
    @Test
    public void addNewHouseValidPatternName() throws Exception {
        //asserrt
        String name= "nombre";
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setProp_name(name);
        mockMvc.perform(MockMvcRequestBuilders.post("/house/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(houseDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.prop_name").value("El nombre de la propiedad debe comenzar con mayúscula y el resto en minúscula"));
    }
    @Test
    public void addNewHouseValidEmpyName() throws Exception {
        //asserrt
        HouseDTO houseDTO = new HouseDTO();
        mockMvc.perform(MockMvcRequestBuilders.post("/house/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(houseDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.prop_name").value("El nombre de la propiedad no puede estar vacío"));
    }
    @Test
    public void addNewHouseValidEmptyEnvironment() throws Exception {
        //asserrt
        String name = "Casa 1";
        ArrayList<Environment> environments = new ArrayList<>();
        HouseDTO houseDTO = new HouseDTO(name,"Cañiza",environments);
        mockMvc.perform(MockMvcRequestBuilders.post("/house/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(houseDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.environmentArrayList").value("La lista de ambientes no puede estar vacía"));
    }
}
