package com.implementacion.hibernate2.controller;

import com.implementacion.hibernate2.controller.dto.DentistDTO;
import com.implementacion.hibernate2.model.service.dentists.IDentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    //@Autowired
    private final IDentistService dentistService;

    public DentistController(IDentistService dentistService){
        this.dentistService = dentistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> listDentists(@PathVariable Long id){
        return new ResponseEntity<>(dentistService.getDentist(id), HttpStatus.OK);
    }

}
