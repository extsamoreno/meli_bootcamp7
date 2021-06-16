package com.meli.obtenerdiploma.units;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent() {

        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);

        ResponseEntity response = studentController.registerStudent(student);

        //asert
        Mockito.verify(iStudentService,Mockito.atLeast(1)).create(student);
    }



    @Test
    public void getStudent() {

        long id1 = 2;
        StudentDTO expected = new StudentDTO(2L, "Pedro", null, null, null);

        SubjectDTO m1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO m2 = new SubjectDTO("Física", 8.0);
        SubjectDTO m3 = new SubjectDTO("Química", 4.0);
        List<SubjectDTO> materias = new ArrayList<>();
        materias.add(m1);
        materias.add(m2);
        materias.add(m3);
        expected.setSubjects(materias);

        Mockito.when(iStudentService.read(id1)).thenReturn(expected);

        StudentDTO received = studentController.getStudent(2L);

        Mockito.verify(iStudentService,Mockito.atLeast(1)).read(id1);
        Assertions.assertEquals(expected,received);
    }

    @Test
    public void modifyStudent() {

        long id = 2;

        List<SubjectDTO> subj2 = new ArrayList<>();
        subj2.add(new SubjectDTO("Matemática", 10.00));
        subj2.add(new SubjectDTO("Física", 8.00));
        subj2.add(new SubjectDTO("Química", 4.00));
        StudentDTO student = new StudentDTO(2L, "Pedro", null, null, subj2);

        //act
        studentController.modifyStudent(student);

        //asert
        Mockito.verify(iStudentService,Mockito.atLeast(1)).update(student);
    }

    @Test
    public void removeStudent() {
        long id = 2;

        //act
        studentController.removeStudent(id);

        //assert
        Mockito.verify(iStudentService,Mockito.atLeast(1)).delete(id);
    }

    @Test
    public void listStudents() {
        Set<StudentDTO> expected = new HashSet<>();
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(new SubjectDTO("Matemática",9.0));
        subjects1.add(new SubjectDTO("Fisica",7.0));
        subjects1.add(new SubjectDTO("Quimica",6.0));
        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects2.add(new SubjectDTO("Matemática",10.0));
        subjects2.add(new SubjectDTO("Fisica",8.0));
        subjects2.add(new SubjectDTO("Quimica",4.0));

        //arange
        expected.add(
                new StudentDTO(1L,"Juan",null,null,subjects1)
        );
        expected.add(
                new StudentDTO(2L,"Pedro",null,null,subjects2)
        );

        Mockito.when(iStudentService.getAll()).thenReturn(expected);

        Set<StudentDTO> receive = studentController.listStudents();

        Mockito.verify(iStudentService,Mockito.atLeast(1)).getAll();

        Assertions.assertEquals(expected,receive);

    }



}
