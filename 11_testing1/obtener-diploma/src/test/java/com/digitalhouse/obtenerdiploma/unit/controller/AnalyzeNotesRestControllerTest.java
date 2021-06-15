package com.digitalhouse.obtenerdiploma.unit.controller;

import com.digitalhouse.obtenerdiploma.controller.AnalyzeNotesRestController;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.SubjectDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateService;
import com.digitalhouse.obtenerdiploma.service.CertificateServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
//import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnalyzeNotesRestControllerTest {

    @Mock
    private CertificateServiceImpl certificateService;

    @InjectMocks
    private AnalyzeNotesRestController analyzeNotes;

    @Test
    public void getNormalCertificade(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList();
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10);
        SubjectDTO subject2 = new SubjectDTO("Física", 7);
        SubjectDTO subject3 = new SubjectDTO("Química", 6);
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        StudentDTO student = new StudentDTO("Juan Gomez",subjects);
        CertificateDTO expected = new CertificateDTO("Juan Gomez",
                7.666666666666667,
                "Juan Gomez usted ha conseguido el promedio de 7.666666666666667",
                subjects);

        when(certificateService.analyzeNotes(student)).thenReturn(expected);

        //Act
        ResponseEntity<CertificateDTO> response = analyzeNotes.analyzeNotes(student);


        //Assert
        assertEquals(response, new ResponseEntity<CertificateDTO>(expected, HttpStatus.OK));

    }

    @Test
    public void getExcelentCertificade(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList();
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10);
        SubjectDTO subject2 = new SubjectDTO("Física", 10);
        SubjectDTO subject3 = new SubjectDTO("Química", 10);
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        StudentDTO student = new StudentDTO("Juan Gomez",subjects);
        CertificateDTO expected = new CertificateDTO("Juan Gomez",
                7.666666666666667,
                "¡Felicitaciones Juan Gomez! Usted tiene el gran promedio de 10.0",
                subjects);

        when(certificateService.analyzeNotes(student)).thenReturn(expected);

        //Act
        ResponseEntity<CertificateDTO> response = analyzeNotes.analyzeNotes(student);

        //Assert
        assertEquals(response, new ResponseEntity<CertificateDTO>(expected, HttpStatus.OK));


    }
}
