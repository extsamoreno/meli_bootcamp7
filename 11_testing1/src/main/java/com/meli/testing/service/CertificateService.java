package com.meli.testing.service;

import com.meli.testing.dto.StudentDTO;
import com.meli.testing.dto.CertificateDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

