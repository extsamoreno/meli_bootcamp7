package com.example.diploma.unit.service;

import com.example.diploma.model.StudentDTO;
import com.example.diploma.repository.IStudentDAO;
import com.example.diploma.repository.IStudentRepository;
import com.example.diploma.service.StudentService;
import com.example.diploma.unit.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService service;

    @Test
    public void createStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        service.create(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    public void readStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = service.read(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void updateStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        service.update(stu);

        // assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    public void deleteStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        service.delete(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void getAllStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(studentRepo.findAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = service.getAll();

        // assert
        verify(studentRepo, atLeastOnce()).findAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}
