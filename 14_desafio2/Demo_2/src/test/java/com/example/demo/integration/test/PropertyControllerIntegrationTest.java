package com.example.demo.integration.test;

import com.example.demo.DTO.DistrictDTO;
import com.example.demo.DTO.EnvironmentDTO;
import com.example.demo.DTO.PropertyDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateSquareMeterHappyPath() throws Exception{
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,159.0 ,111300.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getSquareMeter/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }

    @Test
    public void calculatePriceHappyPath() throws Exception{
// arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,159.0,111300.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getPrice/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }

    @Test
    public void calculateBigger() throws Exception{
        //arrage
        List<EnvironmentDTO> env3 = new ArrayList<>();
        env3.add(new EnvironmentDTO("First Room", 15,9,0));
        env3.add(new EnvironmentDTO("Secod Room", 10,8.5,0));
        env3.add(new EnvironmentDTO("Lobby", 5,7,0));
        env3.add(new EnvironmentDTO("Sala", 4,3,0));
        env3.add(new EnvironmentDTO("BathRoom", 3,2,0));
        env3.add(new EnvironmentDTO("Kitchen", 7,4,0));

        PropertyDTO prop = new PropertyDTO(3,"Casa familiar", new DistrictDTO("Colina",1000),env3,301.0,0.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getBigger"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }

    @Test
    public void calculateSquareMeterByEnvironmentHappyPath() throws Exception{
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("First Room", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Secod Room", 8,4,32.0));
        env1.add(new EnvironmentDTO("Thirt Room", 7,3,21.0));
        env1.add(new EnvironmentDTO("BathRoom", 3,2,6.0));
        env1.add(new EnvironmentDTO("Kitchen", 5,3,15.0));

        PropertyDTO prop = new PropertyDTO(1,"Casa Blanca", new DistrictDTO("ParkWay",700),env1,159.0,111300.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = writer.writeValueAsString(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getSquareMeterByEnvironment/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(responseJson))
                .andReturn();
    }

    @Test
    public void addPropertyHappyPath() throws Exception {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("Cuarto", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Baño", 3,2,6.0));
        env1.add(new EnvironmentDTO("Cocina", 5,1,5.0));

        PropertyDTO prop = new PropertyDTO(5,"Casa prueba", new DistrictDTO("ParkWay",700),env1,159.0,111300.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String entryJson = writer.writeValueAsString(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/addProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(entryJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public  void addPropertyDistrictNotFoundException() throws Exception {
        // arrange
        List<EnvironmentDTO> env1 = new ArrayList<>();
        env1.add(new EnvironmentDTO("Cuarto", 10,8.5,85.0));
        env1.add(new EnvironmentDTO("Baño", 3,2,6.0));
        env1.add(new EnvironmentDTO("Cocina", 5,1,5.0));

        PropertyDTO prop = new PropertyDTO(5,"Casa prueba", new DistrictDTO("ParkWa",700),env1,0.0,0.0);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String entryJson = writer.writeValueAsString(prop);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/addProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(entryJson))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(mvcResult -> assertTrue(mvcResult.getResolvedException() instanceof DistrictNotFoundException))
                .andReturn();

    }
}
