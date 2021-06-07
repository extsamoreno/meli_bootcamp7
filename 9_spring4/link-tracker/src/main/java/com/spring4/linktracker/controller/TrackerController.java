package com.spring4.linktracker.controller;

import com.spring4.linktracker.exception.TrackerIdNotFoundException;
import com.spring4.linktracker.service.dtos.LinkDTO;
import com.spring4.linktracker.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracker")
public class TrackerController {

    @Autowired
    TrackerService trackerService;

    @GetMapping()
    public ResponseEntity<List<LinkDTO>> getLinks() {
        return new ResponseEntity<>(trackerService.allLinks(), HttpStatus.OK) ;
    }

    @PostMapping()
    public ResponseEntity<LinkDTO> setLink(@RequestBody String url) {
        return new ResponseEntity<>(trackerService.generateLink(url), HttpStatus.OK) ;
    }

    @GetMapping("link/{id}")
    public ResponseEntity<Void> redirect (@PathVariable int id) throws TrackerIdNotFoundException {
        return trackerService.redirectLink(id);
    }

    @GetMapping("metrics/{id}")
    public ResponseEntity<LinkDTO> metrics (@PathVariable int id) throws TrackerIdNotFoundException {
        return new ResponseEntity<>(trackerService.getMetrics(id), HttpStatus.OK);
    }

    @PostMapping("invalidate/{id}")
    public void invalidate (@PathVariable int id) {
        trackerService.invalidateLink(id);
    }

}

