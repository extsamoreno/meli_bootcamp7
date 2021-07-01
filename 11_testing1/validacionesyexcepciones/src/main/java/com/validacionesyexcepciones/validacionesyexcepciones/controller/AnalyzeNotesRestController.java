package com.validacionesyexcepciones.validacionesyexcepciones.controller;
import com.validacionesyexcepciones.validacionesyexcepciones.dto.CertificateDTO;
import com.validacionesyexcepciones.validacionesyexcepciones.dto.StudentDTO;
import com.validacionesyexcepciones.validacionesyexcepciones.service.CertificateService;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
  public CertificateDTO analyzeNotes(@Valid @RequestBody StudentDTO notes) throws MethodArgumentNotValidException {
    return certificateService.analyzeNotes(notes);
  }
}