package com.ejerciciotm.clase2.controllers;

import com.ejerciciotm.clase2.models.Certificate;
import com.ejerciciotm.clase2.models.Student;
import com.ejerciciotm.clase2.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("certificates")
public class CertificateController{

    @Autowired
    private CertificateService certificateService;

    @PostMapping
    public ResponseEntity<Certificate> postCertificateByStudent(@RequestBody Student student){
        return new ResponseEntity<Certificate>(certificateService.createCertificate(student), HttpStatus.CREATED);
    }
}
