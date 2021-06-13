package com.digitalhouse.obtenerdiploma.service;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.exception.ValidationOutputException;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house) throws ValidationOutputException;
}

