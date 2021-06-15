package com.meli.obtenerdiploma.unit.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    //private StudentDAO studentDAO;

    private StudentRepository studentRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    void setUp() {
        //instanciar repository con data de prueba

        //studentRepository = new StudentRepository ("src/test/java/resource/usersTest.json");

        Set<StudentDTO> studentDTOList = new HashSet<>();
        studentDTOList = studentRepository.findAll();

    }

    @Test
    public void saveStudentHappyPath() throws IOException {
       //Load "database"
        setUp();

        List<StudentDTO> expectedDataBase = objectMapper.readValue(
                new File("src/test/java/resource/usersTest.json"),
                new TypeReference<>() {
                });

        //Arrange
/*        SubjectDTO subjectOne = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subjectTwo = new SubjectDTO("Física", 7.0);
        SubjectDTO subjectThree = new SubjectDTO("Química", 6.0);

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subjectOne);
        subjectDTOList.add(subjectTwo);
        subjectDTOList.add(subjectThree);

        StudentDTO student = new StudentDTO(1L,"Juan","message",7.33,subjectDTOList);

        //StudentDTO expectedStudent = new StudentDTO(1L,"Juan","message",7.33,subjectDTOList);*/

        //Act
        //studentDAO.save(student);

        //Assert
        Assertions.assertEquals(expectedDataBase, studentRepository.findAll());
    }

}

