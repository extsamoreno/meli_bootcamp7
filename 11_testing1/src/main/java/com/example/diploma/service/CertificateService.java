package com.example.diploma.service;

import com.example.diploma.dto.CertificateDTO;
import com.example.diploma.dto.StudentDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

