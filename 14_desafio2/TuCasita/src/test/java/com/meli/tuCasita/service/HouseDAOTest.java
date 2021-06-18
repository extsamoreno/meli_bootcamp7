package com.meli.tuCasita.service;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.model.DistrictDTO;
import com.meli.tuCasita.model.HouseDTO;
import com.meli.tuCasita.repository.HouseDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class HouseDAOTest {

    @Mock
    HouseDAO houseDAO;

    @InjectMocks
    HouseService houseService;

    @Test
    public void HouseCreateOK() {
        //Arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"Agustin",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.save(houseDTO)).thenReturn(true);

        //Act
        boolean received = houseService.create(houseDTO);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).save(houseDTO);
        Assertions.assertEquals(true, received);
    }
    @Test
    public void HouseCreatFais() {
        //Arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"agu",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.save(houseDTO)).thenReturn(false);

        //Act
        boolean received = houseService.create(houseDTO);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).save(houseDTO);
        Assertions.assertEquals(false, received);
    }

    @Test
    public void HouseReadOk() {
        //Arrange
        Long houseID = 1L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"agu",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenReturn(houseDTO);

        //Act
        HouseDTO received = houseService.read(houseID);

        //Assert

        Mockito.verify(houseDAO,Mockito.atLeastOnce()).findById(houseID);
        Assertions.assertEquals(houseDTO, received);
    }
    @Test
    public void HouseReadFails() {
        //Arrange
        Long houseID = 10L;
        ArrayList<AmbientDTO> ambientDTOS = new  ArrayList<AmbientDTO>();
        AmbientDTO ambientDTO1 = new  AmbientDTO("Cosina",5.0,3.0);//15
        AmbientDTO ambientDTO2 = new  AmbientDTO("Pieza",4.0,3.0);//12
        ambientDTOS.add(ambientDTO1);
        ambientDTOS.add(ambientDTO2);
        DistrictDTO districtDTO = new DistrictDTO("Banda Nrte",200.0);
        HouseDTO houseDTO = new HouseDTO(houseID,"agu",districtDTO,ambientDTOS);

        Mockito.when(houseDAO.findById(houseID)).thenThrow(new HouseNotFoundException(houseID));

        //Assert
        Assertions.assertThrows(HouseNotFoundException.class, () -> houseService.read(houseID));
    }
}
