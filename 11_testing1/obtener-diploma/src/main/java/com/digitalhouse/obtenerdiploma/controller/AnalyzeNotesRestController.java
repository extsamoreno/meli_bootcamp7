package com.digitalhouse.obtenerdiploma.controller;


import com.digitalhouse.obtenerdiploma.service.CertificateService;
import com.digitalhouse.obtenerdiploma.service.dto.AverageNotesDTO;
import com.digitalhouse.obtenerdiploma.service.dto.StudentNameDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhouse.obtenerdiploma.service.dto.StudentDTO;
import com.digitalhouse.obtenerdiploma.service.dto.CertificateDTO;

import javax.validation.Valid;

@RestController
public class AnalyzeNotesRestController {
  private final CertificateService certificateService;

  public AnalyzeNotesRestController(CertificateService certificateService) {
    this.certificateService = certificateService;
  }

  @PostMapping("/analyzeNotes")
  public CertificateDTO analyzeNotes(@RequestBody StudentDTO notes){
    return certificateService.analyzeNotes(notes);
  }


  @PostMapping("/average")
  public AverageNotesDTO averageNotes(@Valid @RequestBody StudentNameDTO notes){

    return certificateService.averageNotes(notes);
  }


}
