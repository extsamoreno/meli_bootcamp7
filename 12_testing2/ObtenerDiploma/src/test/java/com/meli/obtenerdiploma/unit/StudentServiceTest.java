package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createNewStudentHappyPath() {
        //arr
        StudentDTO studentDTO = estudiante(1L, "Jorge");
        // act
        studentService.create(studentDTO);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void updateStudentHappyPath() {
        //arr
        StudentDTO studentDTO = estudiante(1L, "Jorge");
        // act
        studentService.update(studentDTO);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }

    @Test
    public void deleteStudentHappyPath() {
        //arr
        Long id = 2L;
        // act
        studentService.delete(id);
        //assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).delete(id);
    }






    private StudentDTO estudiante(long id, String name){
        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 9.01));
        subj2.add(new SubjectDTO("Física", 9.00));
        subj2.add(new SubjectDTO("Química", 9.00));
        double average = (subj2.get(0).getScore() + subj2.get(1).getScore() +
                subj2.get(2).getScore()) / subj2.size();

        StudentDTO expected = new StudentDTO(id, name, null, average, subj2);

        return expected;

    }

}
