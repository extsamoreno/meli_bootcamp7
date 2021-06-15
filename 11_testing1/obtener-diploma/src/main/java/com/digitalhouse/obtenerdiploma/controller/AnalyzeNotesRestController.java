package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<CertificateDTO> analyzeNotes(@Valid @RequestBody StudentDTO notes) {
    return new ResponseEntity<>(certificateService.analyzeNotes(notes), HttpStatus.OK);
  }
}
