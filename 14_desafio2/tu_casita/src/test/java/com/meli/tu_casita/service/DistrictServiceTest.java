package com.meli.tu_casita.service;

import com.meli.tu_casita.exception.DistrictAlreadyExistsException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.repository.IDistrictRepository;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest {

    @Mock
    IDistrictRepository districtDAO;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    DistrictServiceImpl districtService;

    @Test
    public void getDistrictListTest() {
        //Arrange
        List<District> districtList = TestUtilGenerator.getDistrictListTest();
        List<DistrictDTO> districtDTOList = TestUtilGenerator.getDistrictDTOListTest();
        Mockito.when(districtDAO.getDistrictList()).thenReturn(districtList);
        //Act
        List<DistrictDTO> received = districtService.getDistrictList();
        //Assert
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).getDistrictList();
    }

    @Test
    public void newDistrictTestOK() {
        //Arrange
        DistrictDTO districtDTO = TestUtilGenerator.getDistrictDTO();
        District district = TestUtilGenerator.getDistrict();
        Mockito.when(modelMapper.map(districtDTO, District.class)).thenReturn(district);
        //Act
        districtService.saveDistrict(districtDTO);
        //Assert
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).save(district);
    }

    @Test
    public void newDistrictTestDistrictExistsException() {
        //Arrange
        DistrictDTO districtDTO = TestUtilGenerator.getDistrictDTO();
        Mockito.when(districtDAO.findByName(districtDTO.getName())).thenReturn(TestUtilGenerator.getOptionalDistrict());
        //Act
        //Assert
        Assertions.assertThrows(DistrictAlreadyExistsException.class, () -> districtService.saveDistrict(districtDTO));
    }


}
