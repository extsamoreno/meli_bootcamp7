package unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @InjectMocks
    StudentRepository studentRepository;

    @Test
    public void findAll(){
        // arrange

        // act
        // assert
        Assertions.assertDoesNotThrow(()->studentRepository.findAll());

    }
}
