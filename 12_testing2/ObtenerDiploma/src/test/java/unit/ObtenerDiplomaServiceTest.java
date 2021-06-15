package unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresWithCorrectId(){
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
        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);
        // act
        StudentDTO received= obtenerDiplomaService.analyzeScores(id);
        // assert
        Assertions.assertEquals((9+7+6)/3.0,received.getAverageScore());
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", received.getMessage());

    }

    @Test
    public void analyzeScoresWithNullStudent(){
        // arrange
        StudentDTO student= null;
        Mockito.when(iStudentDAO.findById(null)).thenReturn(student);
        // act
        // assert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    public void analyzeScoresWithVoidStudent(){
        // arrange
        StudentDTO student= new StudentDTO();
        Mockito.when(iStudentDAO.findById(student.getId())).thenReturn(student);

        // act

        // assert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(student.getId()));
    }

    @Test
    public void analyzeScoresWithHigherAverage(){
        // arrange
        long id=1L;
        StudentDTO student= new StudentDTO(id,
                "Juan",
                null,
                null,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",9.0),
                        new SubjectDTO("Química",10.0)
                )));
        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);
        // act
        StudentDTO received= obtenerDiplomaService.analyzeScores(id);
        // assert
        Assertions.assertEquals((9+9+10)/3.0,received.getAverageScore());
        Assertions.assertEquals("El alumno Juan ha obtenido un promedio de 9.33. Felicitaciones!", received.getMessage());

    }
}
