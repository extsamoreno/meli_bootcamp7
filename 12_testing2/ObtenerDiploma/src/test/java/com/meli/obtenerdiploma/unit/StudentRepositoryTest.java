package com.meli.obtenerdiploma.unit;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

  @Test
  public void studentSaveHappyPath(){
    // Arrange
    SubjectDTO subject = new SubjectDTO( "Matematica", 9.00);
    List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
    subjects.add(subject);
    StudentDTO stu = new StudentDTO(1L,"Juan", "hola", 9.9, subjects);
    StudentDAO stuDAO = new StudentDAO();
    stuDAO.save(stu);

    // Act
    boolean receive = stuDAO.exists(stu);

    // Assert
    Assertions.assertTrue(receive);


  }
}
