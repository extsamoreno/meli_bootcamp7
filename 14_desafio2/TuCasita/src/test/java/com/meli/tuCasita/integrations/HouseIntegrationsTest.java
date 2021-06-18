package com.meli.tuCasita.integrations;

import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.District;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.repository.IHouseDAO;
import com.meli.tuCasita.service.IHouseService;
import com.meli.tuCasita.service.dto.ResponseGetPriceDTO;
import com.meli.tuCasita.service.dto.ResponseMeter2DTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HouseIntegrationsTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IHouseService iHouseService;

    @MockBean
    IHouseDAO iHouseDAO;

    @Test
    public void getMeter2HappyPath() throws Exception{
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);
        ResponseMeter2DTO responseMeter2DTO = new ResponseMeter2DTO();
        responseMeter2DTO.setMeter2(27.0D);
        responseMeter2DTO.setHouse(house);
        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(house);
        Mockito.when((iHouseService.getMeter2(houseID))).thenReturn(responseMeter2DTO);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/getmeter2/{id}",houseID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.meter2").value("27.0"));


    }

    @Test
    public void getPriceHappyPath() throws Exception{
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);
        ResponseGetPriceDTO responseGetPriceDTO = new ResponseGetPriceDTO();
        responseGetPriceDTO.setHouse(house);
        responseGetPriceDTO.setPrice(5400.0D);
        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(house);
        Mockito.when((iHouseService.getPrice(houseID))).thenReturn(responseGetPriceDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/getprice/{id}",houseID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(responseGetPriceDTO.getPrice()));


    }

    @Test
    public void getmaxambientHappyPath() throws Exception{
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);

        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(house);
        Mockito.when((iHouseService.getMaxAmbient(houseID))).thenReturn(ambient1);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/getmaxambient/{id}",houseID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Cosina"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.longAmbient").value("5.0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.widthAmbient").value("3.0"));

    }
    @Test
    public void getmaxambientforambientHappyPath() throws Exception{
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new  ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina",5.0,3.0);//15
        Ambient ambient2 = new Ambient("Pieza",4.0,3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte",200.0);
        House house = new House(houseID,"Agustin", district, ambients);
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put(ambient1.getName(), 15.0D);
        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(house);
        Mockito.when((iHouseService.getmaxambientforambient(houseID, ambient1.getName()))).thenReturn(expect);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/{idHouse}/ambient/{nameAmbient}/getmaxambient",houseID, ambient1.getName()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Cosina").value("15.0"));

    }


}
