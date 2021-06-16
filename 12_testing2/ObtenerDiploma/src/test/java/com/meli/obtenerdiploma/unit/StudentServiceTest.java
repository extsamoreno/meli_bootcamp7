package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;
    @InjectMocks
    StudentService studentService;
    @Test
    public void getCreateHappyPath() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Student");
        ArrayList<SubjectDTO> arrayList = new ArrayList<>();
        arrayList.add(new SubjectDTO("Matematica",5.0));
        arrayList.add(new SubjectDTO("Fisica",7.0));
        studentDTO.setSubjects(arrayList);
        //act
        studentService.create(studentDTO);
        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }
    @Test
    public void getReadHappyPath() {
        //arrange
        long id =1L;
        //act
        studentService.read(id);
        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).findById(id);
    }
    @Test
    public void getUpdateHappyPath() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Student");
        ArrayList<SubjectDTO> arrayList = new ArrayList<>();
        arrayList.add(new SubjectDTO("Matematica",5.0));
        arrayList.add(new SubjectDTO("Fisica",7.0));
        studentDTO.setSubjects(arrayList);
        //act
        studentService.update(studentDTO);
        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).save(studentDTO);
    }
    @Test
    public void getDeleteHappyPath() {

        //arrange
        long id =1L;
        //act
        studentService.delete(id);
        //assert
        Mockito.verify(iStudentDAO, Mockito.atLeastOnce()).delete(id);
    }
    @Test
    public void getAllHappyPath () {
        //arrange
        Set<StudentDTO> studentDTOS = new HashSet<>();
        StudentDTO studentDTO = new StudentDTO();
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO1);
        when(iStudentRepository.findAll()).thenReturn(studentDTOS);
        //act
        Set<StudentDTO> received = studentService.getAll();
        //assert
        assertEquals(studentDTOS, received);


    }

}
