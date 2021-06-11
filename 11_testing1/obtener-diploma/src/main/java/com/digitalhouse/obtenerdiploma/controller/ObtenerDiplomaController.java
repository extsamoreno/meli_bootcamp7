package com.digitalhouse.obtenerdiploma.controller;

import com.digitalhouse.obtenerdiploma.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.dto.CertificateDTO;
import com.digitalhouse.obtenerdiploma.service.CertificateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {
  private final CertificateService certificateService;

  public ObtenerDiplomaController(CertificateService certificateService) {
    this.certificateService = certificateService;
  }

  @PostMapping("/getDiploma")
  public CertificateDTO analyzeNotes(@Valid @RequestBody StudentDTO notes){
    return certificateService.analyzeNotes(notes);
  }
}
