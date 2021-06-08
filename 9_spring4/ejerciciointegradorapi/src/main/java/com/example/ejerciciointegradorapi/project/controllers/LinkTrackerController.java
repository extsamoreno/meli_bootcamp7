package com.example.ejerciciointegradorapi.project.controllers;

import com.example.ejerciciointegradorapi.project.exceptions.InvalidUrlException;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerMetricsDTO;
import com.example.ejerciciointegradorapi.project.services.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerRequestDTO;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerResponseDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class LinkTrackerController {

    @Autowired
    ILinkTrackerService iLinkTrackerService;

    @PostMapping("/sendlink")
    public ResponseEntity<LinkTrackerResponseDTO> sendlink (@RequestBody LinkTrackerRequestDTO linkTrackerRequestDTO) throws InvalidUrlException {
        return new ResponseEntity<>(iLinkTrackerService.createLink(linkTrackerRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public void redirectUrl (@PathVariable Integer linkId,HttpServletResponse response) throws IOException, InvalidUrlException {
        response.sendRedirect(iLinkTrackerService.redirectUrl(linkId).getUrl());
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkTrackerMetricsDTO> getMetrics (@PathVariable Integer linkId) throws IOException, InvalidUrlException {
      return new ResponseEntity<>(iLinkTrackerService.getRedirectCounts(linkId),HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink (@PathVariable Integer linkId){
        ArrayList<String> response = new ArrayList<>();
        iLinkTrackerService.invalidateLink(linkId);
        response.add("Link id: "+linkId+" was invalidated succesfully");
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
