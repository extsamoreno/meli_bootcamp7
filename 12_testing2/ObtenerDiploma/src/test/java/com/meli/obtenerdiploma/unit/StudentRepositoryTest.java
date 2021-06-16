package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @Test
    public void studentSaveHappyPath(){
        // Arrange
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.00);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        StudentDTO stu =  new StudentDTO(1L,"Juan", "hola", 9.9, subjects);
        StudentDAO stuDAO = new StudentDAO();
        stuDAO.save(stu);

        // act
        boolean receive = stuDAO.exists(stu);

        // Assert
        Assertions.assertTrue(receive);
    }

    @Test
    public void studentDeleteStudentHappyPath(){
        // Arrange
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.00);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        long studentId = 1L;
        StudentDTO stu =  new StudentDTO(studentId,"Juan", "hola", 9.9, subjects);
        StudentDAO stuDAO = new StudentDAO();
        stuDAO.save(stu);

        // act
        boolean receive = stuDAO.delete(stu.getId());

        // Assert
        Assertions.assertTrue(receive);
    }

    @Test
    public void studentDeleteStudentStudentDoNotExit(){
        // Arrange
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.00);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        long studentId = 1L;
        StudentDTO stu =  new StudentDTO(studentId,"Juan", "hola", 9.9, subjects);
//        StudentDTO stu2 =  new StudentDTO(2L,"Juan", "hola", 9.9, subjects);
        StudentDAO stuDAO = new StudentDAO();
        stuDAO.save(stu);

        // act
        boolean receive = stuDAO.delete(5L);

        // Assert
        Assertions.assertFalse(receive);
    }
}

