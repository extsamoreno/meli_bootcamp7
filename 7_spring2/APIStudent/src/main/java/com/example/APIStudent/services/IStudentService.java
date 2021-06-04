package com.example.APIStudent.services;

import com.example.APIStudent.repository.Student;
import com.example.APIStudent.services.dto.StudentDTO;

public interface IStudentService {
    StudentDTO getCertificate(Student student);
}
