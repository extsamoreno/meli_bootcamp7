package com.example.tuCasita.integration;

import com.example.tuCasita.dtos.DistrictDTO;
import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.models.District;
import com.example.tuCasita.models.Enviroment;
import com.example.tuCasita.models.Home;
import com.example.tuCasita.repositories.IHomeRepository;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerIntegTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IHomeRepository repository;

    @Test
    public void getSquareMeterByHomeHappyPath() throws Exception {
        //arrange
        District district = new District(1,"District Test",500.00);

        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1",10.00,10.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2",5.00,5.00);

        enviromentList.add(env1);
        enviromentList.add(env2);

        Home home = new Home(1,"Home test",district,enviromentList);

        String expected = "125.0";

        Mockito.when(repository.getHomeById(1)).thenReturn(home);

        this .mockMvc.perform(MockMvcRequestBuilders
            .get("/getSquare/{homeId}",1 ))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(content().string(expected))
            .andReturn();
    }

    @Test
    public void getPriceHappyPath() throws Exception {
        //arrange
        District district = new District(1,"District Test",500.00);

        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1",10.00,10.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2",5.00,5.00);

        enviromentList.add(env1);
        enviromentList.add(env2);

        Home home = new Home(1,"Home test",district,enviromentList);

        // price: 500 * area: 125
        String expected = "62500.0";

        Mockito.when(repository.getHomeById(1)).thenReturn(home);

        this .mockMvc.perform(MockMvcRequestBuilders
                .get("/getPrice/{homeId}",1 ))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(expected))
                .andReturn();
    }

    @Test
    public void getBiggestHappyPath() throws Exception {
        //arrange
        District district = new District(1,"District Test",500.00);

        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1",10.00,10.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2",5.00,5.00);

        enviromentList.add(env1);
        enviromentList.add(env2);

        Home home = new Home(1,"Home test",district,enviromentList);

        String expected = "{\"id\":1,\"name\":\"Enviroment 1\",\"width\":10.0,\"length\":10.0}";

        Mockito.when(repository.getHomeById(1)).thenReturn(home);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/getBiggest/{homeId}",1 ))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String recived = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertEquals(expected, recived);

    }

    @Test
    public void getMeterCountHappyPath() throws Exception {
        //arrange
        District district = new District(1,"District Test",500.00);

        List<Enviroment> enviromentList = new ArrayList<>();
        Enviroment env1 = new Enviroment(1,"Enviroment 1",10.00,10.00);
        Enviroment env2 = new Enviroment(2,"Enviroment 2",5.00,5.00);

        enviromentList.add(env1);
        enviromentList.add(env2);

        Home home = new Home(1,"Home test",district,enviromentList);

        Mockito.when(repository.getHomeById(1)).thenReturn(home);
        Mockito.when(repository.findEnviromentsById(1)).thenReturn(enviromentList);

        String expected = "[{\"name\":\"Enviroment 1\",\"area\":100.0},{\"name\":\"Enviroment 2\",\"area\":25.0}]";

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders
                .get("/getMeter/{homeId}",1 ))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        String recived = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertEquals(expected, recived);
    }

    @Test
    public void insertDistrictHappyPath() throws Exception {
        DistrictDTO payloadDTO = new DistrictDTO(1,"District Test",500.00);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/insertDistrict")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("The district was added correctly"));
    }

    @Test
    public void insertHomeHappyPath() throws Exception {
        List<EnviromentDTO> enviromentList = new ArrayList<>();
        EnviromentDTO env1 = new EnviromentDTO(1,"Envorment 1",10.00,10.00);
        EnviromentDTO env2 = new EnviromentDTO(2,"Envorment 2",5.00,5.00);
        enviromentList.add(env1);
        enviromentList.add(env2);

        List<Enviroment> enviList = new ArrayList<>();
        EnviromentDTO envi1 = new EnviromentDTO(1,"Envorment 1",10.00,10.00);
        EnviromentDTO envi2 = new EnviromentDTO(2,"Envorment 2",5.00,5.00);
        enviromentList.add(envi1);
        enviromentList.add(envi2);

        District district = new District(1,"District Test",500.00);
        Home home = new Home(1,"Home test",district,enviList);

        Mockito.when(repository.findDistrictById(1)).thenReturn(district);
        Mockito.when(repository.getHomeById(1)).thenReturn(home);

        HomeDTO payloadDTO = new HomeDTO(1,"Home test",1,enviromentList);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/insertHome")
            .contentType(MediaType.APPLICATION_JSON) .content(payloadJson))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Home test"));
    }
}
