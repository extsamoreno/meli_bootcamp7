package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    /**

     void create(StudentDTO stu);
     StudentDTO read(Long id);
     void update(StudentDTO stu);
     void delete(Long id);
     Set<StudentDTO> getAll();

     */

    @Test
    public void createNewStudentHappyPath() {
        //arr
        StudentDTO studentDTO = Utils.getStudentDTO();
//        Mockito.when(studentDAO.save(studentDTO)).thenAnswer(null);
        // act
        studentService.create(studentDTO);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
//        assertEquals(expected, received.getAverageScore());
    }


}
