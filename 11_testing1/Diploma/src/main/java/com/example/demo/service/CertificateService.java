package com.example.demo.service;


import com.example.demo.dto.CertificateDTO;
import com.example.demo.dto.StudentDTO;

public interface CertificateService {
  CertificateDTO analyzeNotes(StudentDTO house);
}

