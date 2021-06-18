package desafio2.testing.integration;

import desafio2.testing.domian.House;
import desafio2.testing.repository.IHouseRepository;
import desafio2.testing.service.dto.*;
import desafio2.testing.util.Generator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IHouseRepository iHouseRepository;

    @MockBean
    ModelMapper mapper;

    @Test
    public void newHouseHappyPath() throws Exception {
        HouseDTO houseDTO = Generator.houseDTOIntegration();
        String payloadJson = Generator.toJson(houseDTO);

        doNothing().when(iHouseRepository).addHouse(houseDTO);

        this.mockMvc.perform(post("/house/newHouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

        verify(iHouseRepository , Mockito.atLeastOnce()).addHouse(houseDTO);
    }

    @Test
    public void meterPropertyHappyPath() throws Exception {
        int id =1;
        HouseMeterPropertyDTO houseArea = Generator.getArea();
        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/house/meterProperty/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareMeter").value(houseArea.getSquareMeter()));

    }

    @Test
    public void pricePropertyHappyPath() throws Exception {
        int id =1;
        HousePriceDTO housePriceDTO = Generator.housePriceDTO();
        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/house/priceProperty/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(housePriceDTO.getPrice()));

    }

    @Test
    public void largestEnvironmentHappyPath() throws Exception {
        int id =1;
        HouseLargestEnvironmentDTO houseLargestEnvironmentDTO = Generator.houseLargestEnvironmentDTO();
        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/house/largestEnvironment/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareMeter").value(houseLargestEnvironmentDTO.getSquareMeter()));

    }

    @Test
    public void meterPerEnvironmentHappyPath() throws Exception {
        int id =1;
        HouseMeterPerEnvironmentDTO houseLargestEnvironmentDTO = Generator.houseMeterPerEnvironmentDTO();
        House house = Generator.house();
        when(iHouseRepository.findHouseById(id)).thenReturn(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/house/meterPerEnvironment/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.meterPerEnvironment").value(houseLargestEnvironmentDTO.getMeterPerEnvironment()));

    }
}
