package com.meli.tuCasita.service;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.Ambient;
import com.meli.tuCasita.model.District;
import com.meli.tuCasita.model.House;
import com.meli.tuCasita.repository.HouseDAO;
import com.meli.tuCasita.service.dto.ResponseGetPriceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class HouseServiceTest {

    @Mock
    HouseDAO houseDAO;

    @InjectMocks
    HouseService houseService;

    @Test
    public void HouseCreateOK() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);

        Mockito.when(houseDAO.save(house)).thenReturn(true);

        //Act
        boolean received = houseService.create(house);

        //Assert

        Mockito.verify(houseDAO, Mockito.atLeastOnce()).save(house);
        Assertions.assertEquals(true, received);
    }

    @Test
    public void GetPriceOk() {
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "Agustin", district, ambients);
        ResponseGetPriceDTO responseGetPriceDTO = new ResponseGetPriceDTO();
        responseGetPriceDTO.setHouse(house);
        responseGetPriceDTO.setPrice(5400D);
        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        ResponseGetPriceDTO received = houseService.getPrice(houseID);

        //Assert

        Mockito.verify(houseDAO, Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(5400D, received.getPrice());
    }

    @Test
    public void HouseCreatFais() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "agu", district, ambients);

        Mockito.when(houseDAO.save(house)).thenReturn(false);

        //Act
        boolean received = houseService.create(house);

        //Assert

        Mockito.verify(houseDAO, Mockito.atLeastOnce()).save(house);
        Assertions.assertEquals(false, received);
    }

    @Test
    public void HouseReadOk() {
        //Arrange
        Long houseID = 1L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "agu", district, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(house);

        //Act
        House received = houseService.read(houseID);

        //Assert

        Mockito.verify(houseDAO, Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(house, received);
    }

    @Test
    public void HouseReadFails() {
        //Arrange
        Long houseID = 10L;
        ArrayList<Ambient> ambients = new ArrayList<Ambient>();
        Ambient ambient1 = new Ambient("Cosina", 5.0, 3.0);//15
        Ambient ambient2 = new Ambient("Pieza", 4.0, 3.0);//12
        ambients.add(ambient1);
        ambients.add(ambient2);
        District district = new District("Banda Nrte", 200.0);
        House house = new House(houseID, "agu", district, ambients);

        Mockito.when(houseDAO.findById(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.read(houseID));
    }


    @Test
    public void GetMeter2FailsService() {
        //Arrange
        Long houseID = 10L;

        Mockito.when(houseDAO.findById(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.getMeter2(houseID));
    }

    @Test
    public void GetDistrictFailsService() {
        //Arrange
        Long houseID = 10L;
        House house = new House();


        Mockito.when(houseDAO.findByDistrict(house.getDistrict())).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.getDistricto(house));
    }

    @Test
    public void GetPriceFailsService() {
        //Arrange
        Long houseID = 10L;
        House house = new House();


        Mockito.when(houseDAO.findById(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.getPrice(houseID));
    }

    @Test
    public void GetMaxAmbientFailsService() {
        //Arrange
        Long houseID = 10L;
        House house = new House();


        Mockito.when(houseDAO.findById(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.getMaxAmbient(houseID));
    }
    @Test
    public void GetmaxambientforambientFailsService() {
        //Arrange
        Long houseID = 10L;
        House house = new House();


        Mockito.when(houseDAO.findById(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.getmaxambientforambient(houseID,""));
    }
}
