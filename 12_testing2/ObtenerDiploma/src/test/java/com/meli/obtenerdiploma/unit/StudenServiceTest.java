package com.meli.obtenerdiploma.unit;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudenServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentDTOProcessCorrect() {

    }

}
