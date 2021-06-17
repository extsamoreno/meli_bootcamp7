package desafio2.demo.unit;

import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;
import desafio2.demo.model.EnvironmentAreaDTO;
import desafio2.demo.model.EnvironmentDTO;
import desafio2.demo.model.PropertyDTO;
import desafio2.demo.repository.IPropertyRepository;
import desafio2.demo.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {
    PropertyDTO propertyDTO;
    EnvironmentDTO smallEnvironment;
    EnvironmentDTO bigEnvironment;
    @Mock
    IPropertyRepository iPropertyRepository;
    @InjectMocks
    PropertyService propertyService;

    @BeforeEach
    void arrangeEach(){
        smallEnvironment = new EnvironmentDTO("env1",3,3);
        bigEnvironment = new EnvironmentDTO("env2",30,3);
        propertyDTO = new PropertyDTO("Propiedad 1",new DistrictDTO("district1", 400),new ArrayList<>(){{
            add(smallEnvironment);
            add(bigEnvironment);
        }});
    }

    @Test
    void getPropertyM2() throws DistrictNotFoundException {
        //arrange
        Mockito.doNothing().when(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        //act
        var result = propertyService.getPropertyM2(propertyDTO);
        //assert
        Mockito.verify(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        assertEquals(result,99);
    }

    @Test
    void getPropertyPrice() throws DistrictNotFoundException {
        //arrange
        Mockito.doNothing().when(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        //act
        var result = propertyService.getPropertyPrice(propertyDTO);
        //assert
        Mockito.verify(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        assertEquals(result,39600);
    }

    @Test
    void getBiggestEnvironment() throws DistrictNotFoundException {
        //arrange
        Mockito.doNothing().when(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        //act
        var result = propertyService.getBiggestEnvironment(propertyDTO);
        //assert
        Mockito.verify(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        assertEquals(result,bigEnvironment);
    }

    @Test
    void getEnvironmentsArea() throws DistrictNotFoundException {
        //arrange
        Mockito.doNothing().when(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        var envList = new ArrayList<EnvironmentAreaDTO>(){{
            add(new EnvironmentAreaDTO(smallEnvironment,9));
            add(new EnvironmentAreaDTO(bigEnvironment,90));
        }};
        //act
        var result = propertyService.getEnvironmentsArea(propertyDTO);
        //assert
        Mockito.verify(iPropertyRepository).validateDistrict(any(DistrictDTO.class));
        for (int i = 0; i < envList.size(); i++) {
            assertEquals(result.get(i),envList.get(i));
        }
    }
}