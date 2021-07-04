package com.randomstudent.demo.Service;
import com.randomstudent.demo.Model.StudentDTO;
import java.util.Set;

public interface IStudentService {

    Set<StudentDTO> getExhibitors(int count);
}
