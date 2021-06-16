package com.meli.obtenerdiploma.units;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlumnoIngresadoTest {

    //En el item 0 no hace falta mockear
    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    //¿Si no devuelve nada hace falta testear?
    //¿Como chequeo que el comportamiento esperado sea una excepcion catcheada que imprime por pantalla
    @Test
    public void read_NoStudentInRepository_throwStudentNotFoundException(){
        //arrange
        Long id = 1L;
        when(iStudentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));
        //assert
        assertThrows(StudentNotFoundException.class,() ->studentService.read(id));
    }
/*
    @Test
    public void getAll_NoStudentInRepository_assertFalse() {
        //arange
            boolean receipt;
            long id = 3L;
        //act
            receipt = studentService.delete(id);
        //assert
            assertTrue(receipt);
    }*/
    @Test
    public void alumnoIngresadoEncontradoTest(){
        //arrange
        Long studentId = null;//1000L;
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO(studentId, null,null,null, null);
        //act
        boolean studentExist = studentDAO.exists(studentDTO);
        //assert
        assertTrue(studentExist);
    }

    @Test
    public void alumnoIngresadoNoEncontradoTest(){
        //arrange
        Long studentId = 1000L;
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO studentDTO = new StudentDTO(studentId, null,null,null, null);
        //act
        boolean studentExist = studentDAO.exists(studentDTO);
        //assert
        assertTrue(!studentExist);
    }

}


