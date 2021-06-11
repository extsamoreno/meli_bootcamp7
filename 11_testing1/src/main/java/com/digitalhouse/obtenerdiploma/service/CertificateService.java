package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentNotesResponseDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);

  StudentNotesResponseDTO obtainAverageNotes(StudentDTO studentDTO);

}

