package com.example.diploma.controller;

import com.example.diploma.dto.CertificateDTO;
import com.example.diploma.dto.StudentDTO;
import com.example.diploma.service.CertificateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AnalyzeNotesRestController {
  private final CertificateService certificateService;

  public AnalyzeNotesRestController(CertificateService certificateService) {
    this.certificateService = certificateService;
  }

  @PostMapping("/analyzeNotes")
  public CertificateDTO analyzeNotes(@Valid @RequestBody StudentDTO notes ){
    return certificateService.analyzeNotes(notes);
  }
}
