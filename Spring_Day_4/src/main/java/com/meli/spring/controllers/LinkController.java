package com.meli.spring.controllers;

import com.meli.spring.exceptions.LinkIDNotFoundException;
import com.meli.spring.exceptions.LinkUnauthorizedException;
import com.meli.spring.services.LinkService;
import com.meli.spring.services.dto.LinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class LinkController {

    @Autowired
    LinkService linkService;

    //Endpoint para encriptar un sitio web, usando un password y un auto id generado para acceder
    @PostMapping("/site/save")
    public ResponseEntity<LinkDto> saveLink(@RequestBody String link, @RequestParam String pass){
        LinkDto linkDto = linkService.saveLink(link,pass);
        return new ResponseEntity<>(linkDto,HttpStatus.CREATED);
    }

    //Endpoint para redireccionarse a un sitio web con su linkID
    @GetMapping("/site/redirect/{linkID}")
    public RedirectView redirectToPage(@PathVariable String linkID) throws LinkIDNotFoundException {
        LinkDto result = linkService.findlink(linkID);
        return new RedirectView("https://"+result.getUrl());
    }

    //Endpoint para devolver las metricas de una pagina con su linkID
    @GetMapping("/site/metrics/{linkID}")
    public ResponseEntity<Integer> metricsSite(@PathVariable String linkID) throws LinkIDNotFoundException {
        Integer result = linkService.getMetrics(linkID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //Endpoint para inhabilitar una pagina  con su linkID y password
    @PutMapping("/site/invalidate/{linkID}")
    public ResponseEntity<String> invdaliteSite(@PathVariable String linkID, @RequestBody String pass) throws LinkUnauthorizedException {
        String result = linkService.invalidateLink(linkID, pass);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }



}
