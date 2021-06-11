package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.service.dto.AverageNotesDTO;
import com.digitalhouse.obtenerdiploma.service.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.service.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.service.dto.StudentNameDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);

  AverageNotesDTO averageNotes(StudentNameDTO notes);
}

