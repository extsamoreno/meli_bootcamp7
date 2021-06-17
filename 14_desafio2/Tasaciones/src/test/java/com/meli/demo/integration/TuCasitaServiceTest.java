package com.meli.demo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.response.EnvironmentSquareTotalDTO;
import com.meli.demo.dto.response.EnvironmentsTotalDTO;
import com.meli.demo.dto.response.PriceMetersResponseDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.repository.ITuCasitaRepository;
import com.meli.demo.service.ITuCasitaService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TuCasitaServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ITuCasitaService iTuCasitaService;


    @Test
    public void totalMeters() throws Exception {
        String nameHouse="Casa Linda";

        TotalMetersResponseDTO TotalMetersResponseDTO = new TotalMetersResponseDTO(nameHouse,121.44000000000001);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(TotalMetersResponseDTO);

        Mockito.when(iTuCasitaService.totalMeters(nameHouse)).thenReturn(TotalMetersResponseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/squareMeters/{nameHouse}",nameHouse)
                .contentType(MediaType.TEXT_PLAIN)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(payloadJson))
                .andReturn();

    }
    @Test
    public void NotFoundHousetotalMeters() throws Exception {
        String nameHouse="Casa test5";

        TotalMetersResponseDTO TotalMetersResponseDTO = new TotalMetersResponseDTO(nameHouse,121.44000000000001);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(TotalMetersResponseDTO);
        HouseNotFoundException house = new HouseNotFoundException(nameHouse);
        Mockito.when(iTuCasitaService.totalMeters(nameHouse)).thenThrow(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/squareMeters/{nameHouse}",nameHouse)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());

    }
    @Test
    public void priceMeters() throws Exception {
        String nameHouse="Casa Linda";
        PriceMetersResponseDTO priceMetersResponseDTO = new PriceMetersResponseDTO(nameHouse,242880.00000000003);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(priceMetersResponseDTO);

        Mockito.when(iTuCasitaService.priceMeters(nameHouse)).thenReturn(priceMetersResponseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/metersPrice/{nameHouse}",nameHouse)
                .contentType(MediaType.TEXT_PLAIN)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(payloadJson))
                .andReturn();
    }

    @Test
    public void NotFoundHousePriceMeters() throws Exception {
        String nameHouse="Casa test5";
        PriceMetersResponseDTO priceMetersResponseDTO = new PriceMetersResponseDTO(nameHouse,242880.00000000003);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(priceMetersResponseDTO);
        HouseNotFoundException house = new HouseNotFoundException(nameHouse);

        Mockito.when(iTuCasitaService.priceMeters(nameHouse)).thenThrow(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/metersPrice/{nameHouse}",nameHouse)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());
    }


    @Test
    public void biggerEnvironment() throws Exception {
        String nameHouse="Casa Fea";
        EnvironmentDTO environmentDTO = new EnvironmentDTO(3,"Cocina",9.4,5.7);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(environmentDTO);

        Mockito.when(iTuCasitaService.biggerEnvironment(nameHouse)).thenReturn(environmentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/biggerEnvironment/{nameHouse}",nameHouse)
                .contentType(MediaType.TEXT_PLAIN)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(payloadJson))
                .andReturn();
    }

    @Test
    public void HouseNotFoundBiggerEnvironment() throws Exception {
        String nameHouse="Casa test5";
        EnvironmentDTO environmentDTO = new EnvironmentDTO(3,"Cocina",9.4,5.7);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(environmentDTO);
        HouseNotFoundException house = new HouseNotFoundException(nameHouse);
        Mockito.when(iTuCasitaService.biggerEnvironment(nameHouse)).thenThrow(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/biggerEnvironment/{nameHouse}",nameHouse)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void squareMetersByEnvironment() throws Exception {
        String nameHouse="Casa Fea";
        EnvironmentsTotalDTO environmentsTotalDTO = new EnvironmentsTotalDTO();
        ArrayList<EnvironmentSquareTotalDTO> environmentSquareTotalDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Estudio",10.4,2.7);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Baño",3.4,3.7);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Cocina",9.4,5.7);
        EnvironmentSquareTotalDTO environmentTotalDTO1 = new EnvironmentSquareTotalDTO(environmentDTO1,28.080000000000002);
        EnvironmentSquareTotalDTO environmentTotalDTO2 = new EnvironmentSquareTotalDTO(environmentDTO2, 12.58);
        EnvironmentSquareTotalDTO environmentTotalDTO3 = new EnvironmentSquareTotalDTO(environmentDTO3,53.580000000000005);
        environmentSquareTotalDTOS.add(environmentTotalDTO1);
        environmentSquareTotalDTOS.add(environmentTotalDTO2);
        environmentSquareTotalDTOS.add(environmentTotalDTO3);
        environmentsTotalDTO.setEnvironments(environmentSquareTotalDTOS);
        environmentsTotalDTO.setNamneHouse("Casa Fea");

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(environmentsTotalDTO);

        Mockito.when(iTuCasitaService.totalMetersByEnvironment(nameHouse)).thenReturn(environmentsTotalDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/squareMetersByEnvironment/{nameHouse}",nameHouse)
                .contentType(MediaType.TEXT_PLAIN)
                .content(""))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(payloadJson))
                .andReturn();
    }

    @Test
    public void houseNotFoundSquareMetersByEnvironment() throws Exception {
        String nameHouse="Casa Fea";
        EnvironmentsTotalDTO environmentsTotalDTO = new EnvironmentsTotalDTO();
        ArrayList<EnvironmentSquareTotalDTO> environmentSquareTotalDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Estudio",10.4,2.7);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Baño",3.4,3.7);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Cocina",9.4,5.7);
        EnvironmentSquareTotalDTO environmentTotalDTO1 = new EnvironmentSquareTotalDTO(environmentDTO1,28.080000000000002);
        EnvironmentSquareTotalDTO environmentTotalDTO2 = new EnvironmentSquareTotalDTO(environmentDTO2, 12.58);
        EnvironmentSquareTotalDTO environmentTotalDTO3 = new EnvironmentSquareTotalDTO(environmentDTO3,53.580000000000005);
        environmentSquareTotalDTOS.add(environmentTotalDTO1);
        environmentSquareTotalDTOS.add(environmentTotalDTO2);
        environmentSquareTotalDTOS.add(environmentTotalDTO3);
        environmentsTotalDTO.setEnvironments(environmentSquareTotalDTOS);
        environmentsTotalDTO.setNamneHouse("Casa Fea");

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(environmentsTotalDTO);
        HouseNotFoundException house = new HouseNotFoundException(nameHouse);
        Mockito.when(iTuCasitaService.totalMetersByEnvironment(nameHouse)).thenThrow(house);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/tucasita/squareMetersByEnvironment/{nameHouse}",nameHouse)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isNotFound());
    }
}