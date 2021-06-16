package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService iStudentService;
    @InjectMocks
    StudentController studentController;
    @Test
    public void getRegisterStudentTest () {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Camilo");
        ArrayList<SubjectDTO> arrayList1 = new ArrayList<>();
        arrayList1.add(new SubjectDTO("Matematica",10.0));
        arrayList1.add(new SubjectDTO("Fisica",10.0));
        arrayList1.add(new SubjectDTO("Quimica",10.0));
        studentDTO.setSubjects(arrayList1);

        //act
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        //assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).create(studentDTO);
        assert (response.getStatusCode()==HttpStatus.OK);
    }
    @Test
    public void getStudentTest (){
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        long id = 1L;
        studentDTO.setStudentName("Camilo");
        ArrayList<SubjectDTO> arrayList1 = new ArrayList<>();
        arrayList1.add(new SubjectDTO("Matematica",10.0));
        arrayList1.add(new SubjectDTO("Fisica",10.0));
        arrayList1.add(new SubjectDTO("Quimica",10.0));
        studentDTO.setSubjects(arrayList1);
        when(iStudentService.read(id)).thenReturn(studentDTO);

        //act
        StudentDTO received = studentController.getStudent(id);

        //assert
        assertEquals(received,studentDTO);
    }
    @Test
    public void getModifyStudentTest() {
        //arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Camilo");
        ArrayList<SubjectDTO> arrayList1 = new ArrayList<>();
        arrayList1.add(new SubjectDTO("Matematica",10.0));
        arrayList1.add(new SubjectDTO("Fisica",10.0));
        arrayList1.add(new SubjectDTO("Quimica",10.0));
        studentDTO.setSubjects(arrayList1);

        //act
        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);

        //assert
        Mockito.verify(iStudentService,Mockito.atLeastOnce()).update(studentDTO);
        assert (response.getStatusCode()==HttpStatus.OK);
    }
    @Test
    public void getListStudentsTest() {
        //arrange
        Set<StudentDTO> studentDTOS = new HashSet<>();
        StudentDTO studentDTO = new StudentDTO();
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO1);
        when(iStudentService.getAll()).thenReturn(studentDTOS);
        //act
        Set<StudentDTO> received = studentController.listStudents();
        //assert
        assertEquals(studentDTOS, received);
    }
}
