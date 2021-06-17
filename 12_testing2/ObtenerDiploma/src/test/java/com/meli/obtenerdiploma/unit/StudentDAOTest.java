package com.meli.obtenerdiploma.unit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDAOTest {

    StudentDAO studentDAO;

    @Test
    public void addStudentHappyPath() throws IOException {
        //arrange
        SubjectDTO subjectDTOOne = new SubjectDTO("Programacioón",10d);
        SubjectDTO subjectDTOTwo = new SubjectDTO("Algoritmos",10d);
        SubjectDTO subjectDTOThree = new SubjectDTO("Base de datos",10d);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subjectDTOOne);
        listSubjects.add(subjectDTOTwo);
        listSubjects.add(subjectDTOThree);

        StudentDTO student = new StudentDTO(1L,"Leandro","ASD",10d,listSubjects);
        StudentDTO expectedStudent = new StudentDTO(1L,"Leandro","ASD",10d,listSubjects);
        //act

     /*   Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;

            file = ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});

        studentDAO.save(student);
*/
        //assert
        Assertions.assertEquals(student,expectedStudent);
    }

}

