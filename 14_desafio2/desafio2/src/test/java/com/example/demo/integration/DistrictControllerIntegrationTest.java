package com.example.demo.integration;

import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.ExistingDistrictException;
import com.example.demo.exception.ExistingHouseException;
import com.example.demo.models.District;
import com.example.demo.models.Environment;
import com.example.demo.models.House;
import com.example.demo.repository.IDistrictRepository;
import com.example.demo.repository.IHouseRepository;
import com.example.demo.service.dto.DistrictDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.hamcrest.Matchers;
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

import javax.print.attribute.standard.Media;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IDistrictRepository iDistrictRepository;
    @Test
    public void addNewDistrict() throws Exception {
        String name= "Cañiza";
        DistrictDTO districtDTO = new DistrictDTO(name,200);
        Mockito.when(iDistrictRepository.findDistrictByName(name)).thenThrow(new DistrictNotFoundException(name));
        mockMvc.perform(MockMvcRequestBuilders.post("/district/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(districtDTO)))
                .andExpect(status().isOk());
    }
    @Test
    public void addNewDistrictExistingDistrictException() throws Exception {
        String name= "Cañiza";
        District district = new District(name,200);
        Mockito.when(iDistrictRepository.findDistrictByName(name)).thenReturn(district);
        mockMvc.perform(MockMvcRequestBuilders.post("/district/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(district)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El barrio " + name + " ya existe"))
                .andExpect(jsonPath("$.name").value(ExistingDistrictException.class.getSimpleName()));
    }
    @Test
    public void addNewDistrictValidLongName() throws Exception {
        //asserrt
        String name= "cañiza1234567890123456789012345678901234567890";
        DistrictDTO districtDTO = new DistrictDTO(name,200);

        mockMvc.perform(MockMvcRequestBuilders.post("/district/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(districtDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.distric_name").value("La longitud del barrio no puede superar los 45 caracteres"));
    }
    @Test
    public void addNewDistrictValidNoEmpty() throws Exception {
        //asserrt
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistric_price(200);

        mockMvc.perform(MockMvcRequestBuilders.post("/district/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(districtDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.distric_name").value("El barrio no puede estar vacío"));
    }
    @Test
    public void addNewDistrictValidMinPrice() throws Exception {
        //asserrt
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistric_price(-100);
        districtDTO.setDistric_name("Barrio");
        mockMvc.perform(MockMvcRequestBuilders.post("/district/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(districtDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.distric_price").value("El precio no puede ser 0, o menor que 0"));
    }
    @Test
    public void addNewDistrictValidMaxPrice() throws Exception {
        //asserrt
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setDistric_price(50000);
        districtDTO.setDistric_name("Barrio");
        mockMvc.perform(MockMvcRequestBuilders.post("/district/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(districtDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.distric_price").value("El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S."));
    }

}
