package com.validacionesyexcepciones.validacionesyexcepciones.service;
import com.validacionesyexcepciones.validacionesyexcepciones.dto.CertificateDTO;
import com.validacionesyexcepciones.validacionesyexcepciones.dto.StudentDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

