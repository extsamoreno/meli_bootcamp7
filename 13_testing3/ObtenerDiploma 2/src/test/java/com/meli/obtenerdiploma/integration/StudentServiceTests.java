package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
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
        StudentDTO expected = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(expected);
        // Act
        StudentDTO received = iStudentService.read(expected.getId());

        //Assert
        System.out.println(received.getStudentName());
        assertEquals(expected, received);
    }
}
