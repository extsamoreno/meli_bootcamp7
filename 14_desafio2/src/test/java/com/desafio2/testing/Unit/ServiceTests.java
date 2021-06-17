package com.desafio2.testing.Unit;

import com.desafio2.testing.Dto.AmbienteDTO;
import com.desafio2.testing.Dto.PropiedadListaAmbientesM2DTO;
import com.desafio2.testing.Dto.PropiedadM2DTO;
import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Model.PropiedadModel;
import com.desafio2.testing.Repository.IUtilDB;
import com.desafio2.testing.Repository.IPropiedadRepository;
import com.desafio2.testing.Repository.UtilDB;
import com.desafio2.testing.Service.Mapper.IPropiedadMapper;
import com.desafio2.testing.Service.PropiedadService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    IPropiedadRepository iPropiedadRepository;

    @Mock
    IPropiedadMapper iPropiedadMapper;

    @InjectMocks
    PropiedadService propiedadService;

    //crear un metodo de init, con @BeforeEach/ Before all

   /* @BeforeAll
    public static void init (){
        System.out.println("aaa");
        IUtilDB utilDB = new UtilDB();
        utilDB.crearDataBase();
    }

    @Test
    public void impr(){
        System.out.println("Luz");
    }
*/


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






}
