package com.spring4.ejercicios.link.controller;

import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.service.ILinkService;
import com.spring4.ejercicios.link.service.dto.response.MetricsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    ILinkService linkServiceImpl;

    @GetMapping("/{linkId}")
    public ResponseEntity<MetricsDTO> showViewsLink(@PathVariable Integer linkId) throws IdNotFoundException {
        return new ResponseEntity<>( linkServiceImpl.getViews(linkId),  HttpStatus.OK);
    }
}
