package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

