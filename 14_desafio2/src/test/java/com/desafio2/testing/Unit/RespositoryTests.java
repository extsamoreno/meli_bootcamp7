package com.desafio2.testing.Unit;

import com.desafio2.testing.Exception.PropiedadInexistenteException;
import com.desafio2.testing.Repository.IMiCasitaRespositoryInit;
import com.desafio2.testing.Repository.MiCasitaRepositoryInit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class RespositoryTests {


    /*
    @Test
    public void getPropiedadByNameOk() throws PropiedadInexistenteException {
        // arrange
        IMiCasitaRespositoryInit.crearDataBase();

        String nombre= "Vidal 1221";
        Mockito.when(iPropiedadRepository.getPropiedadByName(nombre)).thenReturn(null);

        // assert
        assertThrows(PropiedadInexistenteException.class, () -> propiedadService.calcularM2PropiedadDTO(nombre));
    }

*/
}
