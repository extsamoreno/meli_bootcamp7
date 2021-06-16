package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.unit.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class StudentRepositoryTest {
    StudentRepository studentRepository;
    StudentDAO studentDAO;
    private static String SCOPE;

    @BeforeEach
    @AfterEach
    private void setUp() {
        emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void listAllStudentsHappyPath() {
        //Arrange
        StudentDTO studentDTO1 = Utils.getStudentDTO();
        StudentDTO studentDTO2 = Utils.getStudentDTO();
        Set<StudentDTO> students = new HashSet<>();
        students.add(studentDTO1);
        students.add(studentDTO2);

        students.forEach(stu -> studentDAO.save(stu));

        //Act
        Set<StudentDTO> recieved = studentRepository.findAll();

        //Assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students,recieved));
    }

    private void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }
}
