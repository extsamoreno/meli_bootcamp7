package desafio2.demo.unit;

import desafio2.demo.controller.PropertyController;
import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;
import desafio2.demo.model.EnvironmentAreaDTO;
import desafio2.demo.model.EnvironmentDTO;
import desafio2.demo.model.PropertyDTO;
import desafio2.demo.service.IPropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PropertyControllerTest {
    PropertyDTO propertyDTO;

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;

    @BeforeEach
    void arrangeEach(){
        propertyDTO = new PropertyDTO("Propiedad 1",new DistrictDTO("district1", 400),new ArrayList<>(){{
            add(new EnvironmentDTO("env1",3,3));
        }});
    }

    @Test
    void getTotalM2() throws DistrictNotFoundException {
        //arrange
        Mockito.when(iPropertyService.getPropertyM2(this.propertyDTO)).thenReturn(40.2);
        //act
        var result = propertyController.getTotalM2(this.propertyDTO);
        //assert
        Mockito.verify(iPropertyService).getPropertyM2(this.propertyDTO);
        assertEquals(result.getBody(), 40.2);
        assertSame(result.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getTotalPrice() throws DistrictNotFoundException {
        //arrange
        Mockito.when(iPropertyService.getPropertyPrice(this.propertyDTO)).thenReturn(40.2);
        //act
        var result = propertyController.getTotalPrice(this.propertyDTO);
        //assert
        Mockito.verify(iPropertyService).getPropertyPrice(this.propertyDTO);
        assertEquals(result.getBody(), 40.2);
        assertSame(result.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getBiggestEnvironment() throws DistrictNotFoundException {
        //arrange
        var env = new EnvironmentDTO("env1",3,3);
        Mockito.when(iPropertyService.getBiggestEnvironment(this.propertyDTO)).thenReturn(env);
        //act
        var result = propertyController.getBiggestEnvironment(this.propertyDTO);
        //assert
        Mockito.verify(iPropertyService).getBiggestEnvironment(this.propertyDTO);
        assertEquals(result.getBody(), env);
        assertSame(result.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getEnvironmentsArea() throws DistrictNotFoundException {
        //arrange
        var env = new EnvironmentDTO("env1",3,3);
        var environmentAreaDTOs = new ArrayList<EnvironmentAreaDTO>(){{add(new EnvironmentAreaDTO(env,3));}};
        Mockito.when(iPropertyService.getEnvironmentsArea(this.propertyDTO)).thenReturn(environmentAreaDTOs);
        //act
        var result = propertyController.getEnvironmentsArea(this.propertyDTO);
        //assert
        Mockito.verify(iPropertyService).getEnvironmentsArea(this.propertyDTO);
        assertEquals(result.getBody(), environmentAreaDTOs);
        assertSame(result.getStatusCode(), HttpStatus.OK);
    }
}