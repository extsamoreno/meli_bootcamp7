package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.BarrioNoExistException;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Exception.PropiedadYaRegistradaException;
import com.desafio2.testing.Model.BarrioModel;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.IBarrioRepository;
import com.desafio2.testing.Repository.IPropiedadRepository;
import com.desafio2.testing.Service.Mapper.PropiedadMapper;
import com.desafio2.testing.Service.PropiedadService;
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
    IPropiedadRepository iPropiedadRepository;

    @Mock
    IBarrioRepository iBarrioRepository;

    @InjectMocks
    PropiedadService propiedadService;


    @Test  //Test CU0001
    public void calcularM2PropiedadDTOok() throws PropiedadInexistenteException {
        // arrange
        PropiedadModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        PropiedadM2DTO expected = UtilTest.createPropiedadM2DTO(); //trae el dto de la propiedad "propiedad"
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropiedadM2DTO received= propiedadService.calcularM2PropiedadDTO("Libertador 5");

        // assert
        verify(iPropiedadRepository,Mockito.atLeastOnce()).getPropiedadByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }

    @Test  //Test CU0001
    public void noExistePropiedadEnCalcularM2Propiedad() throws PropiedadInexistenteException {
        // arrange
        String nombre= "NoExiste";
        Mockito.when(iPropiedadRepository.getPropiedadByName(nombre)).thenReturn(null);

        // assert
        assertThrows(PropiedadInexistenteException.class, () -> propiedadService.calcularM2PropiedadDTO(nombre));
    }

    @Test  //Test CU0002
    public void calcularValorPropiedadOk() throws PropiedadInexistenteException {
        // arrange
        PropiedadModel propiedad = UtilTest.createPropiedadModel();
        PropiedadValorDTO expected = UtilTest.crearPropiedadValorDto();
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropiedadValorDTO received= propiedadService.calcularValorPropiedadDTO(propiedad.getProp_name());

        // assert
        verify(iPropiedadRepository,Mockito.atLeastOnce()).getPropiedadByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }




    @Test//Test CU0003
    public void calcularAmbienteMasGrandeOk() throws PropiedadInexistenteException {
        // arrange
        String nombre= "Libertador 5";
        PropiedadModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        AmbienteDTO expected= UtilTest.createAmbienteMayorDTO();
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        AmbienteDTO received= propiedadService.calcularAmbienteMasGrande(nombre);

        // assert
        verify(iPropiedadRepository,Mockito.atLeastOnce()).getPropiedadByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }

    @Test//Test CU0003
    public void calcularAmbienteMasGrandeNotFound() throws PropiedadInexistenteException {
        // arrange
        String nombre= "Libertador 5";
        PropiedadModel propiedad = UtilTest.createPropiedadModel();
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(null);

        // assert
        assertThrows(PropiedadInexistenteException.class, () -> propiedadService.calcularAmbienteMasGrande(nombre));
    }

    @Test //Test CU0004
    public void calcularListaAmbientesM2ok() throws PropiedadInexistenteException {
        // arrange
        String nombre= "Libertador 5";
        PropiedadModel propiedad = UtilTest.createPropiedadModel();// Se llama a Util que crea la propiedad
        PropiedadListaAmbientesM2DTO expected= UtilTest.createPropiedadListaAmbientesM2DTO();
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(propiedad);

        // act
        PropiedadListaAmbientesM2DTO received= propiedadService.calcularListaAmbientesM2(nombre);

        // assert
        verify(iPropiedadRepository,Mockito.atLeastOnce()).getPropiedadByName(propiedad.getProp_name());
        assertEquals(expected, received);
    }

    @Test //Test CU0004
    public void calcularListaAmbientesM2NotFound() throws PropiedadInexistenteException {
        // arrange
        String nombre= "Libertador 5";
        PropiedadModel propiedad = UtilTest.createPropiedadModel();
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedad.getProp_name())).thenReturn(null);

        // assert
        assertThrows(PropiedadInexistenteException.class, () -> propiedadService.calcularListaAmbientesM2(nombre));

    }

    @Test
    public void crearPropiedadOk() throws BarrioNoExistException, PropiedadYaRegistradaException {
            // Arrange
            PropiedadRequestDTO propiedadRequestDTO = UtilTest.crearPropiedadRequestDTO();
            BarrioModel barrio = new BarrioModel("Almagro", 1200.3);
            PropiedadModel propiedadM= PropiedadMapper.toPropiedadModel(propiedadRequestDTO,barrio);

            Mockito.when(iPropiedadRepository.getPropiedadByName(propiedadRequestDTO.getProp_name())).thenReturn(null); //Que no exista la propiedad
            Mockito.when(propiedadService.obtenerBarrioPorNombre(propiedadRequestDTO.getDistrict_name())).thenReturn(barrio);
            Mockito.when(iPropiedadRepository.agregarPropiedad(propiedadM)).thenReturn(true);

            // Act
            boolean bool= propiedadService.crearPropiedad(propiedadRequestDTO);

            // Assert
            verify(iPropiedadRepository,atLeastOnce()).agregarPropiedad(propiedadM);  //Verifica que se agregue la propiedad correcta
        }

    @Test
    public void crearPropiedadBarrioNoExist() throws BarrioNoExistException, PropiedadYaRegistradaException {
        // Arrange
        PropiedadRequestDTO propiedadRequestDTO = UtilTest.crearPropiedadRequestDTO();
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedadRequestDTO.getProp_name())).thenReturn(null);
        Mockito.when(propiedadService.obtenerBarrioPorNombre(propiedadRequestDTO.getDistrict_name())).thenReturn(null);

        // Assert
        assertThrows(BarrioNoExistException.class, () -> propiedadService.crearPropiedad(propiedadRequestDTO));
    }

    @Test
    public void crearPropiedadPropiedadYaRegistrada() throws BarrioNoExistException, PropiedadYaRegistradaException {
        // Arrange
        PropiedadRequestDTO propiedadRequestDTO = UtilTest.crearPropiedadRequestDTO();
        BarrioModel barrio = new BarrioModel("Almagro", 1200.3);
        PropiedadModel propiedadM= PropiedadMapper.toPropiedadModel(propiedadRequestDTO,barrio);
        Mockito.when(iPropiedadRepository.getPropiedadByName(propiedadRequestDTO.getProp_name())).thenReturn(propiedadM);

        // Assert
        assertThrows(PropiedadYaRegistradaException.class, () -> propiedadService.crearPropiedad(propiedadRequestDTO));
    }

    @Test
    public void  obtenerBarrioPorNombreOk(){
        // Arrange
            BarrioModel expected = new BarrioModel("Lugano", 1200.3);
            String name= "Lugano";
            Mockito.when(iBarrioRepository.getBarrioByName("Lugano")).thenReturn(expected);

        // Act
            BarrioModel received= propiedadService.obtenerBarrioPorNombre(name);

        // Assert
            assertEquals(expected, received);
        }

    @Test
    public void  obtenerBarrioPorNombreNoExist(){
        // Arrange
        String name= "Lugano";
        Mockito.when(iBarrioRepository.getBarrioByName("Lugano")).thenReturn(null);

        // Assert
        assertNull(propiedadService.obtenerBarrioPorNombre(name));
    }




}
