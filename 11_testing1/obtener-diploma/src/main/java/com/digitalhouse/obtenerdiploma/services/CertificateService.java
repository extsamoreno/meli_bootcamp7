package com.digitalhouse.obtenerdiploma.services;

import com.digitalhouse.obtenerdiploma.dtos.StudentDTO;
import com.digitalhouse.obtenerdiploma.dtos.CertificateDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

