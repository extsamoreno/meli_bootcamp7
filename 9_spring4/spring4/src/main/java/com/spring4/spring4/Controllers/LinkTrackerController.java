package com.spring4.spring4.Controllers;

import com.spring4.spring4.DTOs.LinkMetricDTO;
import com.spring4.spring4.DTOs.LinkRequestDTO;
import com.spring4.spring4.DTOs.LinkResponseDTO;
import com.spring4.spring4.Exceptions.InvalidLinkPassException;
import com.spring4.spring4.Exceptions.LinkInactiveException;
import com.spring4.spring4.Exceptions.LinkNotFoundException;
import com.spring4.spring4.Services.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkTrackerController {

    @Autowired
    ILinkTrackerService iLinkTrackerService;

    @PostMapping("/create")
    public ResponseEntity<LinkResponseDTO> create(@RequestBody LinkRequestDTO linkDTOreq){
        return new ResponseEntity<>(iLinkTrackerService.create(linkDTOreq), HttpStatus.CREATED);
    }

    @GetMapping("/link")
    public void create(HttpServletResponse response, @RequestParam int id, @RequestParam String pass)
            throws IOException, LinkNotFoundException, LinkInactiveException, InvalidLinkPassException {
        iLinkTrackerService.redirect(response, id, pass);
    }

    @GetMapping("/metricByLink")
    public ResponseEntity<LinkMetricDTO> metricByLink(@RequestParam int id, @RequestParam String pass) throws LinkNotFoundException, InvalidLinkPassException {
        return new ResponseEntity<>(iLinkTrackerService.getMetricByLink(id, pass), HttpStatus.OK);
    }

    @PostMapping("/invalidate")
    public void invalidate(@RequestParam int id, @RequestParam String pass) throws LinkNotFoundException, InvalidLinkPassException {
       iLinkTrackerService.invalidate(id, pass);
    }

}


