package com.meli.persistence.services;

import com.meli.persistence.dtos.StudentDTO;
import com.meli.persistence.dtos.StudentsDTO;
import org.springframework.stereotype.Service;

public interface IStudentService {
    public String add(StudentDTO student);

    StudentsDTO getAll(int page, int perPage);
}
