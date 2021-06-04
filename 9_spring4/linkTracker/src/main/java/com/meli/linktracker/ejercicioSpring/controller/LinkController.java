package com.meli.linktracker.ejercicioSpring.controller;

import com.meli.linktracker.ejercicioSpring.dto.LinkDTO;
import com.meli.linktracker.ejercicioSpring.model.Link;
import com.meli.linktracker.ejercicioSpring.response.LinkResponse;
import com.meli.linktracker.ejercicioSpring.response.ViewsResponse;
import com.meli.linktracker.ejercicioSpring.service.ILinkService;
import com.meli.linktracker.ejercicioSpring.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    ILinkService linkService;


    @PostMapping("/save")
    public ResponseEntity<LinkResponse> saveLink(@RequestBody LinkDTO linkDTO, @RequestParam String password){
        LinkResponse respuesta = linkService.crearLink(linkDTO,password);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Link>> showLink(){
        return new ResponseEntity<>(linkService.getLinkList(), HttpStatus.CREATED);
    }
    @GetMapping("/{linkid}")
    public RedirectView redirect(@PathVariable int linkid, @RequestParam String password){
        linkService.setView(linkid);
        return linkService.redirect(linkid);
    }
    @GetMapping("/metrics/{linkid}")
    public ResponseEntity<ViewsResponse> getMetrics(@PathVariable int linkid){
        ViewsResponse response = new ViewsResponse(linkid,linkService.getLinkById(linkid).getLink(),linkService.getView(linkid));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }



}
