package com.meli.tuCasita.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;
import com.meli.tuCasita.repository.IHouseDAO;
import com.meli.tuCasita.service.IHouseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.containsString;
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
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(houseDTO);
        Mockito.when((iHouseService.getMeter2(houseID))).thenReturn(27.0D);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/getmeter2/{id}",houseID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("27.0"));


    }

    @Test
    public void getPriceHappyPath() throws Exception{
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(houseDTO);
        Mockito.when((iHouseService.getPrice(houseID))).thenReturn(5400.0D);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/getprice/{id}",houseID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("5400.0"));


    }

    @Test
    public void getmaxambientHappyPath() throws Exception{
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(houseDTO);
        Mockito.when((iHouseService.getMaxAmbient(houseID))).thenReturn(ambientDTO1);


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
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);
        HashMap<String, Double> expect = new HashMap<String, Double>();
        expect.put(ambientDTO1.getName(), 15.0D);
        Mockito.when(iHouseDAO.findById(houseID)).thenReturn(houseDTO);
        Mockito.when((iHouseService.getmaxambientforambient(houseID, ambientDTO1.getName()))).thenReturn(expect);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/houses/{idHouse}/ambient/{nameAmbient}/getmaxambient",houseID, ambientDTO1.getName()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.Cosina").value("15.0"));

    }


}
