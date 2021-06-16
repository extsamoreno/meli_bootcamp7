package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentDaoTest {

    StudentDAO studentDAO;

    //@Test
    public void addStudentHappyPath(){
        //Arrange
        SubjectDTO subjectOne = new SubjectDTO("Matemática", 10d);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 10d);
        SubjectDTO subjectThree = new SubjectDTO("Química", 10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectOne);
        listSubjects.add(subjectTwo);
        listSubjects.add(subjectThree);

        StudentDTO student = new StudentDTO(1L,"Juan","Asd",10d,listSubjects);

        //Act
        studentDAO.save(student);

        //Assert
        //Assertions.assertEquals();
    }

}
