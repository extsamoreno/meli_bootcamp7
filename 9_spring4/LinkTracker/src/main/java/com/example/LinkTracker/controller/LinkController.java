package com.example.LinkTracker.controller;

import com.example.LinkTracker.exception.LinkIdNotFoundException;
import com.example.LinkTracker.exception.LinkInvalidPassException;
import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;
import com.example.LinkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;
    @PostMapping(value = "/createlink",consumes = "application/json",produces = "application/json")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkDTORequest linkRequest){
        return new ResponseEntity<>(linkService.createLink(linkRequest), HttpStatus.OK);
    }
    /*
    @GetMapping("/link/{linkID}")
    public ModelAndView createLink(@PathVariable String linkID) throws IOException, LinkIdNotFoundException {
        String url = linkService.getLink(linkID);
        return new ModelAndView("redirect:" + url);
    }*/
    @GetMapping("/link/{linkID}")
    public ModelAndView createLinkWithPass(@PathVariable String linkID, @RequestParam String pass) throws LinkInvalidPassException, LinkIdNotFoundException {
        return new ModelAndView("redirect:" + linkService.getLinkWithPass(linkID,pass));
    }
    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> getMetrics(@PathVariable String linkID)throws LinkIdNotFoundException {
        return new ResponseEntity<Integer>(linkService.getLinkCantVisitas(linkID), HttpStatus.OK);
    }
    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidateLink(@PathVariable String linkID) throws LinkIdNotFoundException {
        linkService.invalidateLink(linkID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
