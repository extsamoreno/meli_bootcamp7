package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTests {

    @Autowired
    IStudentService iStudentService;

    @Test
    public void read_student_successfully(){
        //Arrange
        long studentId = 10L;
        SubjectDTO subject = new SubjectDTO( "Matematica", 9.0);
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(subject);
        StudentDTO expected =  new StudentDTO(studentId,"Juan", "hola", 9.9, subjects);

        // Act
        StudentDTO received = iStudentService.read(studentId);

        //Assert
        assertEquals(expected, received);
    }
}
