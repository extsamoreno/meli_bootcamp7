package com.example.ChallengeTwo.Integration;

import com.example.ChallengeTwo.Util.TestUtilsGenerator;
import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.mapper.MapperHouse;
import com.example.ChallengeTwo.model.House;
import com.example.ChallengeTwo.repository.HouseRepositoryImple;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HouseControllerIntegrationTest{
    @Autowired
    MockMvc mockMvc;
    @MockBean
    HouseRepositoryImple houseRepositoryImple;

    @Test
    public void createHouseSuccesfull() throws Exception {
        String houseName = "House";
        House house = TestUtilsGenerator.getHouseWith4Environments(houseName);
        when(houseRepositoryImple.getHouseByName(houseName)).thenReturn(house);
        when(houseRepositoryImple.addNewHouse(house)).thenReturn(true);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(house);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/house/createHouse")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

        verify(houseRepositoryImple, atLeast(1)).addNewHouse(house);
    }
}
