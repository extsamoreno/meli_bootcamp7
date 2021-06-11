package com.example.diplomatesting.service;


import com.example.diplomatesting.dto.CertificateDTO;
import com.example.diplomatesting.dto.StudentDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

