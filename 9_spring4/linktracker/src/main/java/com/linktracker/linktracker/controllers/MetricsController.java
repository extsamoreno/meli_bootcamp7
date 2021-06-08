package com.linktracker.linktracker.controllers;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    LinkService linkService;

    @GetMapping("/{linkId}")
    public ResponseEntity<Integer> getStatistics(@PathVariable int linkId) throws LinkNotFoundException {
        return new ResponseEntity<>(linkService.getLinkById(linkId).getCounterRedirect(), HttpStatus.OK);
    }

}
