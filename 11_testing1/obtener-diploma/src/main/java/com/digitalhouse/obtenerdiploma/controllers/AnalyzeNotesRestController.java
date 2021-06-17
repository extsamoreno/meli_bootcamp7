package com.digitalhouse.obtenerdiploma.controllers;

import com.digitalhouse.obtenerdiploma.dtos.CertificateDTO;
import com.digitalhouse.obtenerdiploma.dtos.StudentDTO;
import com.digitalhouse.obtenerdiploma.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AnalyzeNotesRestController {
  @Autowired
  CertificateService certificateService;

  @PostMapping("/analyzeNotes")
  public CertificateDTO analyzeNotes(@Valid @RequestBody StudentDTO notes ){
    return certificateService.analyzeNotes(notes);
  }

}
