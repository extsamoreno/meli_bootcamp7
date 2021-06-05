package com.example.demo.Controller;


import com.example.demo.Exception.LinkIdNotFoundException;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
@RequestMapping("/api")
public class LinksControler {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/create/")
    public ResponseEntity<LinkDTOResponse> createLink(@RequestBody LinkDTOResquest link){
        return  new ResponseEntity<>(iLinkService.creatLink(link), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<HttpHeaders> redirectLink(@PathVariable int id) throws LinkIdNotFoundException, URISyntaxException {
        return new ResponseEntity<>(iLinkService.redirectLink(id), HttpStatus.SEE_OTHER);
    }


}
