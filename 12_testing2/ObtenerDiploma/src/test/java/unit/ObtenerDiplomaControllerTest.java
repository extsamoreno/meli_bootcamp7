package unit;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScores(){
        // arrange
        long id=1L;
        StudentDTO student= new StudentDTO(id,
                "Juan",
                null,
                null,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química",6.0)
                )));
        Mockito.when(iObtenerDiplomaService.analyzeScores(id)).thenReturn(student);
        // act
        StudentDTO received=obtenerDiplomaController.analyzeScores(id);
        // assert
        Assertions.assertEquals(student,received);
    }
}
