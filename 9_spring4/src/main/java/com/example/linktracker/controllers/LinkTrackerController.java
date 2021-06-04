package com.example.linktracker.controllers;

import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linkTracker")
public class LinkTrackerController {
    @Autowired
    LinkService linkService;

    @PostMapping("/crearLink")
    public ResponseEntity<LinkResponseDTO> crearLink (@RequestBody LinkRequestDTO linkUrl) throws ExistentLinkException, InvalidLinkException {
        return new ResponseEntity<>(linkService.crearLink(linkUrl), HttpStatus.OK);
    }

    //REDIRECCION

    /*@GetMapping("/metrics/{linkId}")
    public ResponseEntity<EstadisticaResponseDTO> obtenerEstadisticas (@PathVariable String linkId){
        return new ResponseEntity<>(linkService.obtenerEstadisticas(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidateLink/{linkId}")
    public ResponseEntity<UrlResponseDTO> invalidarLink (@PathVariable String linkId){
        return new ResponseEntity<>(linkService.invalidarLink(linkId), HttpStatus.OK);
    }*/
}
