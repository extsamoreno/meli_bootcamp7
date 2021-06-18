package com.meli.tu_casita.service;

import com.meli.tu_casita.exception.DistrictNotFoundException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.Environment;
import com.meli.tu_casita.model.RealState;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.model.dto.EnvironmentDTO;
import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;
import com.meli.tu_casita.repository.IDistrictDAO;
import com.meli.tu_casita.repository.IEnvironmentDAO;
import com.meli.tu_casita.repository.IRealStateDAO;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RealStateServiceTest {

    @Mock
    IRealStateDAO realStateDAO;
    @Mock
    IDistrictDAO districtDAO;
    @Mock
    IEnvironmentDAO environmentDAO;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    RealStateServiceImpl realStateService;

    @Test
    public void getRealStateTotalMetersTest() {
        //Arrange
        int realStateId = 1;
        List<Environment> environmentList = TestUtilGenerator.getEnvironmentListTest();
        float metersTotalExpected = 50f;
        Mockito.when(environmentDAO.getEnvironmentsListByRealStateId(realStateId)).thenReturn(environmentList);
        //Act
        float metersTotalReceived = realStateService.getRealStateTotalMeters(realStateId);
        //Assert
        Mockito.verify(environmentDAO, Mockito.atLeastOnce()).getEnvironmentsListByRealStateId(realStateId);
        Assertions.assertEquals(metersTotalExpected, metersTotalReceived);
    }

    @Test
    public void addNewRealStateOK() {
        //Arrange
        RealStateInDTO realStateInDTO = TestUtilGenerator.getRealStateInDTO();
        District district = TestUtilGenerator.getDistrict();
        List<EnvironmentDTO> environmentDTOList = TestUtilGenerator.getEnvironmentDTOListTest();
        List<Environment> environmentList = TestUtilGenerator.getEnvironmentListTest();
        Mockito.when(districtDAO.findById(realStateInDTO.getDistrictId())).thenReturn(Optional.of(district));
        Mockito.when(modelMapper.map(realStateInDTO, RealState.class)).thenReturn(TestUtilGenerator.getRealState());
        Type listType = new TypeToken<List<Environment>>() {
        }.getType();
        Mockito.when(modelMapper.map(environmentDTOList, listType)).thenReturn(environmentList);

        //Act
        realStateService.addNewRealState(realStateInDTO);
        //Assert
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).findById(realStateInDTO.getDistrictId());
    }

    @Test
    public void addNewRealStateWithNonExistingDistrict() {
        //Arrange
        RealStateInDTO realStateInDTO = TestUtilGenerator.getRealStateInDTO();
        Mockito.when(districtDAO.findById(realStateInDTO.getDistrictId())).thenReturn(Optional.empty());
        //Act
        //Assert
        Assertions.assertThrows(DistrictNotFoundException.class, () -> realStateService.addNewRealState(realStateInDTO));
    }

    @Test
    public void getRealStateOutDTOByRealStateIdVerifyBiggestRoom() {
        //Arrange
        int realStateId = 1;
        int biggestEnvironmentId = 3;
        float biggestEnvironmentMeters = 25f;

        RealState realState = TestUtilGenerator.getRealState();
        District district = TestUtilGenerator.getDistrict();
        DistrictDTO districtDTO = TestUtilGenerator.getDistrictDTO();
        List<Environment> environmentList = TestUtilGenerator.getEnvironmentListTest();
        List<EnvironmentDTO> environmentDTOList = TestUtilGenerator.getEnvironmentDTOListTest();

        Mockito.when(realStateDAO.findById(realStateId)).thenReturn(realState);
        Mockito.when(districtDAO.findById(realState.getDistrictId())).thenReturn(Optional.of(district));
        Mockito.when(modelMapper.map(district, DistrictDTO.class)).thenReturn(districtDTO);
        Mockito.when(environmentDAO.getEnvironmentsListByRealStateId(realStateId)).thenReturn(environmentList);
        Type listType = new TypeToken<List<EnvironmentDTO>>() {
        }.getType();
        Mockito.when(modelMapper.map(environmentList, listType)).thenReturn(environmentDTOList);

        //Act
        RealStateOutDTO realStateOutDTOByRealStateId = realStateService.getRealStateOutDTOByRealStateId(realStateId);
        //Assert
        Mockito.verify(realStateDAO, Mockito.atLeastOnce()).findById(realStateId);
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).findById(realState.getDistrictId());
        Mockito.verify(environmentDAO, Mockito.atLeastOnce()).getEnvironmentsListByRealStateId(realStateId);
        Assertions.assertEquals(biggestEnvironmentId, realStateOutDTOByRealStateId.getEnvironments().stream().filter(EnvironmentDTO::isTheBiggest).findFirst().get().getId());
        Assertions.assertEquals(biggestEnvironmentMeters, realStateOutDTOByRealStateId.getEnvironments().stream().filter(EnvironmentDTO::isTheBiggest).findFirst().get().getMetersTotal());
    }

    @Test
    public void getRealStateOutDTOByRealStateIdVerifyMetersByEnvironment() {
        //Arrange
        int realStateId = 1;

        int environmentOneId = 1;
        int environmentTwoId = 2;
        int environmentThreeId = 3;
        float environmentOneMeters = 9f;
        float environmentTwoMeters = 16f;
        float environmentThreeMeters = 25f;

        RealState realState = TestUtilGenerator.getRealState();
        District district = TestUtilGenerator.getDistrict();
        DistrictDTO districtDTO = TestUtilGenerator.getDistrictDTO();
        List<Environment> environmentList = TestUtilGenerator.getEnvironmentListTest();
        List<EnvironmentDTO> environmentDTOList = TestUtilGenerator.getEnvironmentDTOListTest();

        Mockito.when(realStateDAO.findById(realStateId)).thenReturn(realState);
        Mockito.when(districtDAO.findById(realState.getDistrictId())).thenReturn(Optional.of(district));
        Mockito.when(modelMapper.map(district, DistrictDTO.class)).thenReturn(districtDTO);
        Mockito.when(environmentDAO.getEnvironmentsListByRealStateId(realStateId)).thenReturn(environmentList);
        Type listType = new TypeToken<List<EnvironmentDTO>>() {
        }.getType();
        Mockito.when(modelMapper.map(environmentList, listType)).thenReturn(environmentDTOList);

        //Act
        RealStateOutDTO realStateOutDTOByRealStateId = realStateService.getRealStateOutDTOByRealStateId(realStateId);
        //Assert
        Mockito.verify(realStateDAO, Mockito.atLeastOnce()).findById(realStateId);
        Mockito.verify(districtDAO, Mockito.atLeastOnce()).findById(realState.getDistrictId());
        Mockito.verify(environmentDAO, Mockito.atLeastOnce()).getEnvironmentsListByRealStateId(realStateId);
        Assertions.assertEquals(environmentOneMeters, realStateOutDTOByRealStateId.getEnvironments().stream().filter(environmentDTO -> environmentDTO.getId().equals(environmentOneId)).findFirst().get().getMetersTotal());
        Assertions.assertEquals(environmentTwoMeters, realStateOutDTOByRealStateId.getEnvironments().stream().filter(environmentDTO -> environmentDTO.getId().equals(environmentTwoId)).findFirst().get().getMetersTotal());
        Assertions.assertEquals(environmentThreeMeters, realStateOutDTOByRealStateId.getEnvironments().stream().filter(environmentDTO -> environmentDTO.getId().equals(environmentThreeId)).findFirst().get().getMetersTotal());
    }

}
