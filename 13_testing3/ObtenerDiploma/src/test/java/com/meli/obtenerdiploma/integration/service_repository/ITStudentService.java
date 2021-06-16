package com.meli.obtenerdiploma.integration.service_repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.GeneratingObjectsUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ITStudentService {


    @Autowired
    private IStudentService studentService;

    @Test
    public void itReadStudentByIdCompareData(){
        //arrange
        StudentDTO expectedStudent = GeneratingObjectsUtils.getGoodStudent();
        Long studentId = expectedStudent.getId();

        //act
        StudentDTO received = studentService.read(studentId);

        //assert
        assertEquals(expectedStudent, received);
    }
}
