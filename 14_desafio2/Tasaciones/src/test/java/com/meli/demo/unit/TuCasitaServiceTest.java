package com.meli.demo.unit;

import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.repository.ITuCasitaRepository;
import com.meli.demo.service.TuCasitaService;
import com.meli.demo.service.mapper.HouseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TuCasitaServiceTest {

    @Mock
    ITuCasitaRepository iTuCasitaRepository;

    @InjectMocks
    TuCasitaService tuCasitaService;

    @Test
    public void createCasita() throws PriceIncorrectException, NeighborhoodNotFounException, HouseExistException {
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
        Mockito.when(iTuCasitaRepository.newCasita(HouseMapper.toHouse(House))).thenReturn(true);

        //act
        Boolean received = tuCasitaService.newCasita(House);

        //assert
        Mockito.verify(iTuCasitaRepository, Mockito.atLeast(1)).newCasita(HouseMapper.toHouse(House));
        Assertions.assertTrue(received);

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
        HouseDTO expected = new HouseDTO("Casa Test",neighborhoodDTO,arrayEnvironmentDTOS);

        Mockito.when(iTuCasitaRepository.getHouseByname("Casa Test")).thenReturn(HouseMapper.toHouse(expected));

        //act
        HouseDTO received = tuCasitaService.viewHouse("Casa Test");

        //assert
        Mockito.verify(iTuCasitaRepository, Mockito.atLeastOnce()).getHouseByname("Casa Test");
        assertEquals(expected, received);

    }

    @Test
    public void viewNeighborhood()  {
        //arrange
        HashMap<String, Double> neighborhoods = new HashMap<>();
        neighborhoods.put("Paraiso", 2000.0);
        neighborhoods.put("Amsterdam", 4500.0);
        neighborhoods.put("Munich", 1900.0);
        neighborhoods.put("Madrid", 2340.0);
        neighborhoods.put("Funza", 1700.0);
        neighborhoods.put("Paraiso", 1908.0);
        Mockito.when(iTuCasitaRepository.viewNeighborhoods()).thenReturn(neighborhoods);
        //act
        HashMap<String, Double>  received = tuCasitaService.viewNeighborhoods();
        //assert
        Mockito.verify(iTuCasitaRepository,Mockito.atLeastOnce()).viewNeighborhoods();
        Assertions.assertEquals(neighborhoods,received);

    }






}
