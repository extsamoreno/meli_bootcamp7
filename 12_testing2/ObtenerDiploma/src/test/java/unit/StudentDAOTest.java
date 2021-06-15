package unit;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    @InjectMocks
    StudentDAO studentDAO;

    @Test
    public void saveWithNullStudentDTO(){

        //arrange

        //act

        //assert
        Assertions.assertThrows(NullPointerException.class, ()-> studentDAO.save(null));
    }

    @Test
    public void saveWithVoidStudentDTO(){

        //arrange
        StudentDTO student= new StudentDTO();
        //act

        //assert
        Assertions.assertDoesNotThrow(()-> studentDAO.save(student));
    }

    @Test
    public void saveWithValidStudentDTO(){
        //arrange
        StudentDTO student= new StudentDTO(1000L,"Holamundo",null,null,null);
        //act

        //assert
        Assertions.assertDoesNotThrow(()-> studentDAO.save(student));
        Assertions.assertDoesNotThrow(()-> studentDAO.findById(1000L));
        StudentDTO expected=studentDAO.findById(1000L);
        Assertions.assertEquals(expected,student);
    }

    @Test
    public void saveExistentStudentDTO(){
        //arrange
        StudentDTO student= new StudentDTO(1L,"Holamundo",null,null,null);
        //act

        //assert
        Assertions.assertDoesNotThrow(()-> studentDAO.save(student));
    }

    @Test
    public void findByNullId(){
        // arrange

        // act

        // assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
    }

    @Test
    public void findByValidId(){
        long id= 1L;
        // arrange
        StudentDTO expected= new StudentDTO(id,null,null,null,null);
        studentDAO.save(expected);
        // act
        StudentDTO received= studentDAO.findById(id);
        // assert
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void deleteANullStudentDTO(){
        // arrange
        // act
        boolean received= studentDAO.delete(null);
        // assert
        Assertions.assertEquals(false,received);
    }

    @Test
    public void deleteANonSavedStudentDTO(){
        // arrange
        long id= 3000L;
        // act
        boolean received= studentDAO.delete(id);
        // assert
        Assertions.assertEquals(false,received);
    }

    @Test
    public void deleteAnExistentStudentDTO(){
        // arrange
        StudentDTO student= new StudentDTO(1L,null,null,null,null);
        studentDAO.save(student); // Almacenando el mismo usuario siempre para que
                                  // la prueba no rompa al no existir el usuario
                                  // despues de la primera ejecucion
        // act
        boolean received= studentDAO.delete(1L);
        // assert
        Assertions.assertEquals(true,received);
    }
}
