package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.DistrictNonExistentException;
import com.desafio2.testing.Exception.PropertyNonExistentException;
import com.desafio2.testing.Exception.ExistenPropertyException;
import com.desafio2.testing.Model.DistrictModel;
import com.desafio2.testing.Model.PropertyModel;
import com.desafio2.testing.Repository.IDistrictRepository;
import com.desafio2.testing.Repository.IPropertyRepository;
import com.desafio2.testing.Service.Mapper.PropertyMapper;
import com.desafio2.testing.Service.PropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    IPropertyRepository iPropertyRepository;

    @Mock
    IDistrictRepository iDistrictRepository;

    @InjectMocks
    PropertyService propiedadService;


    @Test  //Test CU0001
    public void calcularM2PropiedadDTOok() throws PropertyNonExistentException {
        // arrange
        PropertyModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        PropertyM2DTO expected = UtilTest.createPropiedadM2DTO(); //trae el dto de la propiedad "propiedad"
        Mockito.when(iPropertyRepository.getPropertyByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropertyM2DTO received= propiedadService.calcM2PropDTO("Libertador 5");

        // assert
        verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }

    @Test  //Test CU0001
    public void noExistePropiedadEnCalcularM2Propiedad() throws PropertyNonExistentException {
        // arrange
        String nombre= "NoExiste";
        Mockito.when(iPropertyRepository.getPropertyByName(nombre)).thenReturn(null);

        // assert
        assertThrows(PropertyNonExistentException.class, () -> propiedadService.calcM2PropDTO(nombre));
    }

    @Test  //Test CU0002
    public void calcularValorPropiedadOk() throws PropertyNonExistentException {
        // arrange
        PropertyModel propiedad = UtilTest.createPropiedadModel();
        PropertyValueDTO expected = UtilTest.crearPropiedadValorDto();
        Mockito.when(iPropertyRepository.getPropertyByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropertyValueDTO received= propiedadService.calcPropValueDTO(propiedad.getProp_name());

        // assert
        verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }


    @Test  //Test CU0002
    public void calcularValorPropiedadNotFound() throws PropertyNonExistentException {
        // arrange
        String nombre="No exist";
        Mockito.when(iPropertyRepository.getPropertyByName(nombre)).thenReturn(null);

        // assert
        assertThrows(PropertyNonExistentException.class, () -> propiedadService.calcPropValueDTO(nombre));
    }



    @Test//Test CU0003
    public void calcularAmbienteMasGrandeOk() throws PropertyNonExistentException {
        // arrange
        String nombre= "Libertador 5";
        PropertyModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        RoomDTO expected= UtilTest.createAmbienteMayorDTO();
        Mockito.when(iPropertyRepository.getPropertyByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        RoomDTO received= propiedadService.calcBiggestRoom(nombre);

        // assert
        verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }

    @Test//Test CU0003
    public void calcularAmbienteMasGrandeNotFound() throws PropertyNonExistentException {
        // arrange
        String nombre= "Libertador 5";
        PropertyModel propiedad = UtilTest.createPropiedadModel();
        Mockito.when(iPropertyRepository.getPropertyByName(propiedad.getProp_name())).thenReturn(null);

        // assert
        assertThrows(PropertyNonExistentException.class, () -> propiedadService.calcBiggestRoom(nombre));
    }

    @Test //Test CU0004
    public void calcularListaAmbientesM2ok() throws PropertyNonExistentException {
        // arrange
        String nombre= "Libertador 5";
        PropertyModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        PropertyRoomListM2DTO expected= UtilTest.createPropiedadListaAmbientesM2DTO();
        Mockito.when(iPropertyRepository.getPropertyByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropertyRoomListM2DTO received= propiedadService.calcRoomListM2(nombre);

        // assert
        verify(iPropertyRepository,Mockito.atLeastOnce()).getPropertyByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }

    @Test //Test CU0004
    public void calcularListaAmbientesM2NotFound() throws PropertyNonExistentException {
        // arrange
        String nombre= "Libertador 5";
        PropertyModel propiedad = UtilTest.createPropiedadModel();
        Mockito.when(iPropertyRepository.getPropertyByName(propiedad.getProp_name())).thenReturn(null);

        // assert
        assertThrows(PropertyNonExistentException.class, () -> propiedadService.calcRoomListM2(nombre));

    }

    @Test
    public void crearPropiedadOk() throws DistrictNonExistentException, ExistenPropertyException {
            // Arrange
            PropiedadRequestDTO propiedadRequestDTO = UtilTest.crearPropiedadRequestDTO();
            DistrictModel barrio = new DistrictModel("Almagro", 1200.3);
            PropertyModel propiedadM= PropertyMapper.toPropiedadModel(propiedadRequestDTO,barrio);

            Mockito.when(iPropertyRepository.getPropertyByName(propiedadRequestDTO.getProp_name())).thenReturn(null); //Que no exista la propiedad
            Mockito.when(propiedadService.getDistrictByName(propiedadRequestDTO.getDistrict_name())).thenReturn(barrio);
            Mockito.when(iPropertyRepository.addProperty(propiedadM)).thenReturn(true);

            // Act
            boolean bool= propiedadService.createNewProperty(propiedadRequestDTO);

            // Assert
            verify(iPropertyRepository,atLeastOnce()).addProperty(propiedadM);  //Verifica que se agregue la propiedad correcta
        }

    @Test
    public void crearPropiedadBarrioNoExist() throws DistrictNonExistentException, ExistenPropertyException {
        // Arrange
        PropiedadRequestDTO propiedadRequestDTO = UtilTest.crearPropiedadRequestDTO();
        Mockito.when(iPropertyRepository.getPropertyByName(propiedadRequestDTO.getProp_name())).thenReturn(null);
        Mockito.when(propiedadService.getDistrictByName(propiedadRequestDTO.getDistrict_name())).thenReturn(null);

        // Assert
        assertThrows(DistrictNonExistentException.class, () -> propiedadService.createNewProperty(propiedadRequestDTO));
    }

    @Test
    public void crearPropiedadPropiedadYaRegistrada() throws DistrictNonExistentException, ExistenPropertyException {
        // Arrange
        PropiedadRequestDTO propiedadRequestDTO = UtilTest.crearPropiedadRequestDTO();
        DistrictModel barrio = new DistrictModel("Almagro", 1200.3);
        PropertyModel propiedadM= PropertyMapper.toPropiedadModel(propiedadRequestDTO,barrio);
        Mockito.when(iPropertyRepository.getPropertyByName(propiedadRequestDTO.getProp_name())).thenReturn(propiedadM);

        // Assert
        assertThrows(ExistenPropertyException.class, () -> propiedadService.createNewProperty(propiedadRequestDTO));
    }

    @Test
    public void  obtenerBarrioPorNombreOk(){
        // Arrange
            DistrictModel expected = new DistrictModel("Lugano", 1200.3);
            String name= "Lugano";
            Mockito.when(iDistrictRepository.getDistrictByName("Lugano")).thenReturn(expected);

        // Act
            DistrictModel received= propiedadService.getDistrictByName(name);

        // Assert
            assertEquals(expected, received);
        }

    @Test
    public void  obtenerBarrioPorNombreNoExist(){
        // Arrange
        String name= "Lugano";
        Mockito.when(iDistrictRepository.getDistrictByName("Lugano")).thenReturn(null);

        // Assert
        assertNull(propiedadService.getDistrictByName(name));
    }




}
