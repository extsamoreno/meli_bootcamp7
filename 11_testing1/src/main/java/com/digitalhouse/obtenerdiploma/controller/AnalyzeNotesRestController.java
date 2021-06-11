package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dto.StudentNotesResponseDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateService;
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
  public CertificateDTO analyzeNotes(@RequestBody StudentDTO studentDTO){
    return certificateService.analyzeNotes(studentDTO);
  }

  @PostMapping("/obtainNotes")
  public StudentNotesResponseDTO obtainNotes (@Valid @RequestBody StudentDTO studentDTO){
    return certificateService.obtainAverageNotes(studentDTO);
  }

}
