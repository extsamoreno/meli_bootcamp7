package com.meli.demo.unit;

import com.meli.demo.controller.TuCasitaController;
import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import com.meli.demo.dto.response.EnvironmentSquareTotalDTO;
import com.meli.demo.dto.response.EnvironmentsTotalDTO;
import com.meli.demo.dto.response.PriceMetersResponseDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.service.ITuCasitaService;
import com.meli.demo.service.mapper.HouseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TuCasitaControlleTest {

    @Mock
    ITuCasitaService iTuCasitaService;

    @InjectMocks
    TuCasitaController tuCasitaController;


    @Test
    public void createCasita() throws PriceIncorrectException, HouseExistException, NeighborhoodNotFounException {
        //arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Test",neighborhoodDTO,arrayEnvironmentDTOS);
        Mockito.when(iTuCasitaService.newCasita(House)).thenReturn(true);

        //act
        ResponseEntity<Boolean> received = tuCasitaController.newCasita(House);

        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).newCasita(House);
        Assertions.assertTrue(received.getBody());

    }


    @Test
    public void totalMeters() throws HouseNotFoundException {
        //arrange
        TotalMetersResponseDTO TotalMetersResponseDTO = new TotalMetersResponseDTO("Casa Linda",121.44000000000001);

        Mockito.when(iTuCasitaService.totalMeters("Casa Linda")).thenReturn(TotalMetersResponseDTO);

        //act
        ResponseEntity<TotalMetersResponseDTO> received = tuCasitaController.totalMeters("Casa Linda");

        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).totalMeters("Casa Linda");
        Assertions.assertEquals( new ResponseEntity<>(TotalMetersResponseDTO, HttpStatus.OK),received);


    }

    @Test
    public void priceMeters() throws HouseNotFoundException {
        //arrange
        PriceMetersResponseDTO priceMetersResponseDTO = new PriceMetersResponseDTO("Casa Linda",242880.00000000003);

        Mockito.when(iTuCasitaService.priceMeters("Casa Linda")).thenReturn(priceMetersResponseDTO);

        //act
        ResponseEntity<PriceMetersResponseDTO> received = tuCasitaController.priceMeters("Casa Linda");

        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).priceMeters("Casa Linda");
        Assertions.assertEquals( new ResponseEntity<>(priceMetersResponseDTO, HttpStatus.OK),received);

    }

    @Test
    public void biggerEnvironment() throws HouseNotFoundException {
        //arrange
        EnvironmentDTO environmentDTO = new EnvironmentDTO(3,"Cocina",9.4,5.7);

        Mockito.when(iTuCasitaService.biggerEnvironment("Casa Fea")).thenReturn(environmentDTO);

        //act
        ResponseEntity<EnvironmentDTO> received = tuCasitaController.biggerEnvironment("Casa Fea");

        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).biggerEnvironment("Casa Fea");
        Assertions.assertEquals( new ResponseEntity<>(environmentDTO, HttpStatus.OK),received);

    }


    @Test
    public void totalMetersByEnvironment() throws HouseNotFoundException {
        //arrange

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

        Mockito.when(iTuCasitaService.totalMetersByEnvironment("Casa Fea")).thenReturn(environmentsTotalDTO);

        //act
        ResponseEntity<EnvironmentsTotalDTO> received = tuCasitaController.totalMetersByEnvironment("Casa Fea");

        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).totalMetersByEnvironment("Casa Fea");
        Assertions.assertEquals( new ResponseEntity<>(environmentsTotalDTO, HttpStatus.OK),received);

    }

    @Test
    public void viewHouse() throws HouseNotFoundException {
        //arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO House = new HouseDTO("Casa Test",neighborhoodDTO,arrayEnvironmentDTOS);
        Mockito.when(iTuCasitaService.viewHouse("Casa Test")).thenReturn(House);

        //act
        ResponseEntity<HouseDTO> received = tuCasitaController.viewHouse("Casa Test");

        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).viewHouse("Casa Test");
        Assertions.assertEquals( new ResponseEntity<>(House, HttpStatus.OK),received);

    }

    @Test
    public void viewNeighborhoods() throws HouseNotFoundException {
        //arrange
        HashMap<String, Double> neighborhoods = new HashMap<>();
            neighborhoods.put("Paraiso", 2000.0);
            neighborhoods.put("Amsterdam", 4500.0);
            neighborhoods.put("Munich", 1900.0);
            neighborhoods.put("Madrid", 2340.0);
            neighborhoods.put("Funza", 1700.0);
            neighborhoods.put("Paraiso", 1908.0);
        Mockito.when(iTuCasitaService.viewNeighborhoods()).thenReturn(neighborhoods);
        //act
        ResponseEntity<HashMap<String, Double> > received = tuCasitaController.viewNeighborhoods();
        //assert
        Mockito.verify(iTuCasitaService,Mockito.atLeastOnce()).viewNeighborhoods();
        Assertions.assertEquals( new ResponseEntity<>(neighborhoods, HttpStatus.OK),received);

    }


}
