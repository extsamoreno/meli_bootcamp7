package com.example.tucasita.unit.service;

import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.ResponseDTO;
import com.example.tucasita.model.District;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.service.DistrictServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTests {

    @Mock
    DistrictDAO districtDAO;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    DistrictServiceImple districtService;

    @Test
    public void testAddOneDistrictNewDistrict() {
        //ARRANGE
        District newDistrict = new District("Villa Crespo", 250.00);
        DistrictDTO newDistrictDTO = new DistrictDTO("Villa Crespo", 250.0);
        ResponseDTO responseExpected = new ResponseDTO(201, "El barrio se ha agregado con éxito al repositorio local");

        Mockito.when(modelMapper.map(newDistrictDTO, District.class)).thenReturn(newDistrict);
        Mockito.doNothing().when(districtDAO).create(newDistrict);

        //ACT
        ResponseDTO responseReceived = districtService.addOneDistrict(newDistrictDTO);

        //ASSERT
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).create(newDistrict);
        Assertions.assertEquals(responseExpected, responseReceived);
    }

}
