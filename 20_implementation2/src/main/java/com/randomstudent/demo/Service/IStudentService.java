package com.randomstudent.demo.Service;

import com.randomstudent.demo.Model.StudentDTO;

import java.util.List;

public interface IStudentService {

    List<StudentDTO> getExhibitors(int count);
}
