package com.meli.obtenerdiploma.units;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryTest {

    @Test
    public void findAllTest(){
        IStudentRepository studentRepository = new StudentRepository();
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
        //act
        Set<StudentDTO> received = studentRepository.findAll();
        //assert
        Assertions.assertEquals(expected,received);
    }

}
