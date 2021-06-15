package unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createNewUser(){
        // arrange
        StudentDTO student=null;

        // act
        studentService.create(student);
        // assert
        Mockito.verify(iStudentDAO, times(1)).save(student);
    }

    @Test
    public void updateUser(){
        // arrange
        StudentDTO student=null;

        // act
        studentService.update(student);
        // assert
        Mockito.verify(iStudentDAO, times(1)).save(student);
    }

    @Test
    public void deleteUser(){
        // arrange
        Long id= 1L;

        // act
        studentService.delete(id);
        // assert
        Mockito.verify(iStudentDAO, times(1)).delete(id);
    }

    @Test
    public void readUser(){
        long id=1L;
        // arrange
        StudentDTO student= new StudentDTO(id,
                "Juan",
                null,
                null,
                new ArrayList<SubjectDTO>(Arrays.asList(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química",6.0)
                )));
        Mockito.when(studentService.read(id)).thenReturn(student);
        // act
        StudentDTO received=studentService.read(id);
        // assert
        Mockito.verify(iStudentDAO, times(1)).findById(id);
        Assertions.assertEquals(student,received);
    }

}
