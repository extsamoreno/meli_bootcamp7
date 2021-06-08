package com.example.demo.controllers;

import com.example.demo.Exceptions.*;
import com.example.demo.repository.entities.Url;
import com.example.demo.service.IMaskUrlService;
import com.example.demo.service.dto.UrlDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/link")
public class LinkTackerController {

    //Cuando spring hace la compilacion, busca la clase que implementa esa interfaz y le hace un new.
    @Autowired
    IMaskUrlService iMaskUrlService;


    @PostMapping("/saveurl")
    public ResponseEntity<UrlDTO> save(@RequestBody Url url) throws UrlNotValidException {
        return new ResponseEntity<UrlDTO>(iMaskUrlService.getLink(url), HttpStatus.OK);
    }

    @RequestMapping(value = "/{linkId}/{pass}", method = RequestMethod.GET)
    public void redirect(@PathVariable Integer linkId, @PathVariable String pass, HttpServletResponse httpServletResponse) throws IOException, LinkNotFoundException, InvalidPassException, BloquedLinkException {
        httpServletResponse.sendRedirect(iMaskUrlService.getUrlNameByLink(linkId, pass));
    }


    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<UrlDTO> getMatchName(@PathVariable Integer linkId) throws LinkNotFoundException {
        return new ResponseEntity<UrlDTO>(iMaskUrlService.getLinkMetrics(linkId), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidate(@PathVariable Integer linkId) throws DisableException {
        return new ResponseEntity<String>((iMaskUrlService.setInvalidLink(linkId) ? "Link invalidado" : "No fue posible invalidar"), HttpStatus.OK);
    }

}



