package com.example.tucasita.unit.service;

import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.service.DistrictServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTests {

    @Mock
    DistrictDAO districtDAO;

    //@Mock
    //DistrictRepository districtRepository;

    @InjectMocks
    DistrictServiceImple districtService;

    @Test
    public void testAddOneDistrictNewDistrict() {
        //ARRANGE
        DistrictDTO newDistrict = new DistrictDTO("Villa Crespo", 250.00);
        ResponseDTO responseExpected = new ResponseDTO(201, "El barrio se ha agregado con éxito al repositorio local");

        Mockito.doNothing().when(districtDAO).create(newDistrict);

        //ACT
        ResponseDTO responseReceived = districtService.addOneDistrict(newDistrict);

        //ASSERT
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).create(newDistrict);
        Assertions.assertEquals(responseExpected, responseReceived);
    }

}
