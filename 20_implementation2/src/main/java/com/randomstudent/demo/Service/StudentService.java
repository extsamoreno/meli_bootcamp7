package com.randomstudent.demo.Service;

import com.randomstudent.demo.Model.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class StudentService implements IStudentService{

    @Override
    public List<StudentDTO> getTenExhibitors() {
        return null;
    }
}
