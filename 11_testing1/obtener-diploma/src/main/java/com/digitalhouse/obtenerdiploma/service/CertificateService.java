package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house) throws Exception;
}

