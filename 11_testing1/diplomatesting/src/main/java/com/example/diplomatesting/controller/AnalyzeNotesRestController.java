package com.example.diplomatesting.controller;


import com.example.diplomatesting.dto.CertificateDTO;
import com.example.diplomatesting.dto.StudentDTO;
import com.example.diplomatesting.service.CertificateService;
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
  public CertificateDTO analyzeNotes(@Valid @RequestBody StudentDTO notes){
    return certificateService.analyzeNotes(notes);
  }
}