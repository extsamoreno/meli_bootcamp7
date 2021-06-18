package com.meli.demo.unit;

import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.NeighborhoodDTO;
import com.meli.demo.exepciones.*;
import com.meli.demo.model.House;
import com.meli.demo.repository.ITuCasitaRepository;
import com.meli.demo.repository.TuCasitaRepository;
import com.meli.demo.service.TuCasitaService;
import com.meli.demo.service.mapper.HouseMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;


public class TuCasitaRepositoryTest {

    TuCasitaRepository TuCasitaRepository;
    @BeforeEach
    @AfterEach
    private void setUp() {
        this.TuCasitaRepository = new TuCasitaRepository() ;
    }

    @Test
    public void CreateCasita() throws HouseExistException, PriceIncorrectException, NeighborhoodNotFounException {
        // arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Madrid",  2340.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,19.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Dormitorio",11.1,22.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Sala",2.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        House house2 = new House("Casa Prueba Ingreso ",neighborhoodDTO,arrayEnvironmentDTOS);
        //act
        Boolean received =TuCasitaRepository.newCasita(house2);

        //assert
        Assertions.assertTrue(received);

    }
    @Test
    public void CreateCasitaprecioerr() throws HouseExistException, PriceIncorrectException, NeighborhoodNotFounException {
        // arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Madrid",  11.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,19.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Dormitorio",11.1,22.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Sala",2.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        House house2 = new House("Casa Prueba Ingreso2 ",neighborhoodDTO,arrayEnvironmentDTOS);

        //assert
        Assertions.assertThrows(PriceIncorrectException.class,() -> TuCasitaRepository.newCasita(house2));

    }





    @Test
    public void existHouseCreateCasita() throws PriceIncorrectException, HouseExistException, NeighborhoodNotFounException {
        // arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        House house = new House("Casa Linda",neighborhoodDTO,arrayEnvironmentDTOS);

        // act & assert
        Assertions.assertThrows(HouseExistException.class,() -> TuCasitaRepository.newCasita(house));
    }

    @Test
    public void neighborhoodNotFoundCreateCasita() throws PriceIncorrectException, HouseExistException, NeighborhoodNotFounException {
        // arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("test", 1900.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        House house = new House("Casa urbana",neighborhoodDTO,arrayEnvironmentDTOS);

        // act & assert
        Assertions.assertThrows(NeighborhoodNotFounException.class,() -> TuCasitaRepository.newCasita(house));
    }

    @Test
    public void priceNeighborhoodNotFoundCreateCasita() throws PriceIncorrectException, HouseExistException, NeighborhoodNotFounException {
        // arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Munich", 10.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Alcoba",12.7,11.2);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Cocina",11.1,9.2);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Baño",8.1,1.2);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        House house = new House("Casa urbana",neighborhoodDTO,arrayEnvironmentDTOS);

        // act & assert
        Assertions.assertThrows(PriceIncorrectException.class,() -> TuCasitaRepository.newCasita(house));
    }

    @Test
    public void getHouseByName() throws HouseNotFoundException {
        //arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Paraiso", 2000.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Dormitorio1",10.4,5.7);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Baño",5.4,3.7);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Cocina",11.4,3.7);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO expected = new HouseDTO("Casa Linda",neighborhoodDTO,arrayEnvironmentDTOS);

        HouseDTO received = new HouseDTO();

        //act

        received = HouseMapper.toDTO(TuCasitaRepository.getHouseByname("Casa Linda"));

        //assert
        Assertions.assertEquals(expected, received);

    }



    @Test
    public void getHouseByNameNotFound() throws HouseNotFoundException {
        //arrange
        NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO("Paraiso", 2000.0);
        ArrayList<EnvironmentDTO> arrayEnvironmentDTOS = new ArrayList<>();
        EnvironmentDTO environmentDTO1 = new EnvironmentDTO(1,"Dormitorio1",10.4,5.7);
        EnvironmentDTO environmentDTO2 = new EnvironmentDTO(2,"Baño",5.4,3.7);
        EnvironmentDTO environmentDTO3 = new EnvironmentDTO(3,"Cocina",11.4,3.7);
        arrayEnvironmentDTOS.add(environmentDTO1);
        arrayEnvironmentDTOS.add(environmentDTO2);
        arrayEnvironmentDTOS.add(environmentDTO3);
        HouseDTO expected = new HouseDTO("Casa",neighborhoodDTO,arrayEnvironmentDTOS);

        Assertions.assertThrows(HouseNotFoundException.class,() -> TuCasitaRepository.getHouseByname(expected.getName()));

    }

    @Test
    public void getNeighborhoodByName() throws HouseNotFoundException {
        //arrange
        HashMap<String, Double> neighborhoods = new HashMap<>();
        neighborhoods.put("Paraiso", 2000.0);
        neighborhoods.put("Amsterdam", 4500.0);
        neighborhoods.put("Munich", 1900.0);
        neighborhoods.put("Madrid", 2340.0);
        neighborhoods.put("Funza", 1700.0);
        neighborhoods.put("Paraiso", 1908.0);

        //act
        HashMap<String, Double> received =TuCasitaRepository.viewNeighborhoods();

        //assert
        Assertions.assertEquals(neighborhoods, received);

    }




}
