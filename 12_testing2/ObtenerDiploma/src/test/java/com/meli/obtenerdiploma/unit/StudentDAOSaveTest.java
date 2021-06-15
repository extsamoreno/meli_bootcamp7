package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StudentDAOSaveTest {

    StudentDAO studentDAO = new StudentDAO();
    Long id;
    @Test
    public void saveHappyPath() {
        //arrange
        StudentDTO studentDTO = getStudentDTO();

        //act
        id=studentDAO.save(studentDTO);
        StudentDTO received=studentDAO.findById(id);
        //assert
        Assertions.assertEquals(studentDTO,received);
        studentDAO.delete(id);
    }

    private StudentDTO getStudentDTO() {
        SubjectDTO subject1= new SubjectDTO("mate1",9.5);
        SubjectDTO subject2= new SubjectDTO("mate2",8.0);
        SubjectDTO subject3= new SubjectDTO("mate3",6.5);

        List<SubjectDTO> list= (Arrays.asList(subject1,subject2,subject3));

        StudentDTO studentDTO= new StudentDTO();

        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(list);
        return studentDTO;
    }

    @Test
    public void updateHappyPath() {
        //arrange
        StudentDTO studentDTO = getStudentDTO();
        Long idLocal=studentDAO.save(studentDTO);
        String name="OTRO NOMBRE";

        studentDTO.setStudentName(name);

        //act
        studentDAO.save(studentDTO);
        StudentDTO received=studentDAO.findById(idLocal);
        //assert
        Assertions.assertEquals(name,received.getStudentName());
        studentDAO.delete(idLocal);
    }
    @Test
    public void deleteHappyPath() {
        //Arrange
        id=studentDAO.save(getStudentDTO());
        //arrange
        //act
        boolean result = studentDAO.delete(id);
        //assert
        Assertions.assertTrue(result);

    }
}
