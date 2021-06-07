package com.example.linktracker.controllers;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.EstadisticaResponseDTO;
import com.example.linktracker.dtos.response.InvalidateLinkResponseDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.exceptions.LinkException;
import com.example.linktracker.exceptions.UnexistentLinkException;
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

    /*@GetMapping("/redireccionAUrl/{linkId}")
    public ResponseEntity<LinkDTO> redireccionarLink (@PathVariable int linkId) throws LinkException {
        return new ResponseEntity<>(linkService.redireccionarLink(linkId), HttpStatus.OK);
    }*/

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<EstadisticaResponseDTO> obtenerEstadisticas (@PathVariable int linkId) throws UnexistentLinkException {
        return new ResponseEntity<>(linkService.obtenerEstadisticas(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidateLink/{linkId}")
    public ResponseEntity<InvalidateLinkResponseDTO> invalidarLink (@PathVariable int linkId) throws UnexistentLinkException{
        return new ResponseEntity<>(linkService.invalidarLink(linkId), HttpStatus.OK);
    }
}
