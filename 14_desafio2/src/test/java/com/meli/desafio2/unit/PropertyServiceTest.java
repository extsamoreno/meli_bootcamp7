package com.meli.desafio2.unit;

import com.meli.desafio2.dto.environment.EnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Property;
import com.meli.desafio2.repository.IDistrictRepository;
import com.meli.desafio2.repository.IPropertyRepository;
import com.meli.desafio2.service.PropertyService;
import com.meli.desafio2.util.TestUtilsGen;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    IDistrictRepository districtRepository;

    @Mock
    ModelMapper mapper;

    @InjectMocks
    PropertyService propertyService;

    @Test
    public void calcTotalAreaWellCalculated() throws PropertyIdNotFoundException {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        ResponsePropTotalAreaDTO propDTO = TestUtilsGen.getResponsePropTotalAreaDTO(propId);

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);

        // Act
        ResponsePropTotalAreaDTO responseProp = propertyService.calcTotalArea(propId);

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        Assertions.assertEquals(propDTO, responseProp);
    }

    @Test
    public void CalcPropValueWellCalculated() throws PropertyIdNotFoundException, DistrictIdNotFoundException {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        District dist = TestUtilsGen.getDistWithId(prop.getDistrictId());
        ResponsePropValueDTO propDTO = TestUtilsGen.getResponsePropValueDTO(propId);

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);
        when(districtRepository.getDistrictbyId(prop.getDistrictId())).thenReturn(dist);

        // Act
        ResponsePropValueDTO responseProp = propertyService.calcPropValue(propId);

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        verify(districtRepository, atLeastOnce()).getDistrictbyId(dist.getId());
        Assertions.assertEquals(propDTO, responseProp);
    }

    @Test
    public void getBigEnvironmentWellCalculated() throws PropertyIdNotFoundException {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        ResponseBigEnvironmentDTO bigEnvDTO = TestUtilsGen.getResponseBigEnvironmentDTO();
        ResponseEnvironmentDTO envDTO = TestUtilsGen.getResponseEnvironmentDTO();

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);
        when(mapper.map(prop.getEnvironments().get(0), ResponseEnvironmentDTO.class)).thenReturn(envDTO);

        // Act
        ResponseBigEnvironmentDTO responseEnv = propertyService.getBigEnvironment(propId);

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        Assertions.assertEquals(bigEnvDTO, responseEnv);
    }

    @Test
    public void listEnvironmentsAreaWellCalculated() throws PropertyIdNotFoundException {

        // Arrange
        int propId = 0;
        Property prop = TestUtilsGen.getPropWithId(propId);
        ResponseEnvironmentDTO envDTO = TestUtilsGen.getResponseEnvironmentDTO();
        List<ResponseEnvironmentDTO> listEnvDTO = TestUtilsGen.getListResponseEnvironmentDTO();

        when(propertyRepository.getPropertybyId(propId)).thenReturn(prop);
        when(mapper.map(prop.getEnvironments().get(0), ResponseEnvironmentDTO.class)).thenReturn(envDTO);

        // Act
        List<ResponseEnvironmentDTO> responseListEnv = propertyService.listEnvironmentsArea(propId);

        // Assert
        verify(propertyRepository, atLeastOnce()).getPropertybyId(propId);
        Assertions.assertTrue(CollectionUtils.isEqualCollection(listEnvDTO, responseListEnv));
    }

    @Test
    public void createNewPropertyOk() throws PropertyIdAlreadyExistException, DistrictIdNotFoundException {

        // Arrange
        int propId = 0;
        PropertyDTO propDTO = TestUtilsGen.getPropDTOWithId(propId);
        Property prop = TestUtilsGen.getPropWithId(propId);
        String message = "Property successfully created";

        when(mapper.map(propDTO, Property.class)).thenReturn(prop);

        // Act
        String response = propertyService.createNewProperty(propDTO);

        // Assert
        verify(propertyRepository, atLeastOnce()).createProperty(prop);
        Assertions.assertEquals(message, response);

    }
}
