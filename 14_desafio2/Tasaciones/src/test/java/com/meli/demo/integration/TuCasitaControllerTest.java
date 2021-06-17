package com.meli.demo.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import com.meli.demo.dto.response.EnvironmentSquareTotalDTO;
import com.meli.demo.dto.response.EnvironmentsTotalDTO;
import com.meli.demo.dto.response.PriceMetersResponseDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.*;
import com.meli.demo.repository.ITuCasitaRepository;
import com.meli.demo.service.ITuCasitaService;
import com.meli.demo.service.mapper.HouseMapper;
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

import java.util.ArrayList;
import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TuCasitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ITuCasitaRepository iTuCasitaRepository;

    //@MockBean
    //ITuCasitaService iTuCasitaService;


    @Test
    public void newCasita() throws Exception {

        //student to add
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Integration",neighborhoodDTO,arrayEnvironmentDTOS);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(House);

        // Mockito.when(studentDAO.save(student)).thenReturn();

        Mockito.when(iTuCasitaRepository.newCasita(HouseMapper.toHouse(House))).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tucasita/insertCasita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());


    }

    @Test
    public void newCasitaExist() throws Exception {

        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Fea",neighborhoodDTO,arrayEnvironmentDTOS);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(House);
        HouseExistException casita = new HouseExistException("Casa Fea");

        Mockito.when(iTuCasitaRepository.newCasita(HouseMapper.toHouse(House))).thenThrow(casita);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tucasita/insertCasita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());

    }

    @Test
    public void NEighborhoodNotFoundnewCasitaExist() throws Exception {

        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("test", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Fea",neighborhoodDTO,arrayEnvironmentDTOS);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(House);
        NeighborhoodNotFounException neighborhoodNotFounException = new NeighborhoodNotFounException("test");

        Mockito.when(iTuCasitaRepository.newCasita(HouseMapper.toHouse(House))).thenThrow(neighborhoodNotFounException);
        //Mockito.when(iTuCasitaRepository.newCasita(HouseMapper.toHouse(House))).thenReturn(false);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tucasita/insertCasita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());

    }

    @Test
    public void priceNeighborhoodNotFoundCreateCasita() throws Exception {

        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Fea",neighborhoodDTO,arrayEnvironmentDTOS);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(House);
        PriceIncorrectException priceIncorrectException = new PriceIncorrectException("Munich",900.0);

        Mockito.when(iTuCasitaRepository.newCasita(HouseMapper.toHouse(House))).thenThrow(priceIncorrectException);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/tucasita/insertCasita")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());

    }


    @Test
    public void viewHouse() throws Exception {

        //student to add
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Integration",neighborhoodDTO,arrayEnvironmentDTOS);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(House);

        // Mockito.when(studentDAO.save(student)).thenReturn();

        Mockito.when(iTuCasitaRepository.getHouseByname(House.getName())).thenReturn(HouseMapper.toHouse(House));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/viewHouse/{nameHouse}",House.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

   @Test
    public void houseNotFoundviewHouse() throws Exception {

        //student to add
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Integration",neighborhoodDTO,arrayEnvironmentDTOS);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(House);
        HouseNotFoundException house = new HouseNotFoundException("Casa Integration");
        Mockito.when(iTuCasitaRepository.getHouseByname(House.getName())).thenThrow(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/viewHouse/{nameHouse}","Casa Integration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());

    }


    @Test
    public void viewNeighborhoods() throws Exception {

        //student to add
        HashMap<String, Double> neighborhoods = new HashMap<>();
        neighborhoods.put("Paraiso", 2000.0);
        neighborhoods.put("Amsterdam", 4500.0);
        neighborhoods.put("Munich", 1900.0);
        neighborhoods.put("Madrid", 2340.0);
        neighborhoods.put("Funza", 1700.0);
        neighborhoods.put("Paraiso", 1908.0);
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(neighborhoods);
        Mockito.when(iTuCasitaRepository.viewNeighborhoods()).thenReturn(neighborhoods);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/viewNeighborhoods")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }






}
