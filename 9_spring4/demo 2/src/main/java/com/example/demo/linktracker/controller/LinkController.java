package com.example.demo.linktracker.controller;

import com.example.demo.linktracker.service.ILinkService;
import com.example.demo.linktracker.service.dto.LinkDTO;
import com.example.demo.linktracker.service.dto.MetricsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    ILinkService iLinkService;
    @PostMapping("/{url}")
    public ResponseEntity<LinkDTO> createLink (@PathVariable String url) {
       return new  ResponseEntity<LinkDTO> (iLinkService.getCreateLink(url), HttpStatus.OK);
    }
    @GetMapping("/{linkId}")
    public RedirectView redirectLink (@PathVariable int linkId) {
        String url = iLinkService.getUrl(linkId);
        return new RedirectView(url);
    }
    @GetMapping("/metric/{linkId}")
    public ResponseEntity<MetricsDTO> createLink (@PathVariable int linkId) {
        return new  ResponseEntity<MetricsDTO> (iLinkService.getMetric(linkId), HttpStatus.OK);
    }
}
