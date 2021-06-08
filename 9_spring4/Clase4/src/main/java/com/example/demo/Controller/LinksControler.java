package com.example.demo.Controller;


import com.example.demo.Exception.BadPasswordExpection;
import com.example.demo.Exception.DuplicatedLinkException;
import com.example.demo.Exception.InvaidLinkException;
import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOMetric;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
@RequestMapping("/api")
public class LinksControler {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/create/")
    public ResponseEntity<LinkDTOResponse> createLink(@RequestBody LinkDTOResquest link) throws DuplicatedLinkException {
        return  new ResponseEntity<>(iLinkService.creatLink(link), HttpStatus.CREATED);
    }

        @GetMapping("/link/{id}")
    public ResponseEntity<HttpHeaders> redirectLink(@PathVariable int id,
                                                    @RequestParam(required = false) String pass)
                                                    throws LinkIdNotFoundException, URISyntaxException,
                                                    InvaidLinkException, BadPasswordExpection {
        return new ResponseEntity<>(iLinkService.redirectLink(id, pass), HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDTOMetric> metricLink(@PathVariable int id) throws LinkIdNotFoundException, InvaidLinkException {
        return new ResponseEntity<>(iLinkService.metricsLink(id), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{id}")
    public ResponseEntity invalidateLink(@PathVariable int id) throws LinkIdNotFoundException, InvaidLinkException {
        iLinkService.invalidateLink(id);
        return new ResponseEntity(HttpStatus.GONE);
    }
}
