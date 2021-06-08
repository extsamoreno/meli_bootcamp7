package com.spring.spring4.Controller;

import com.spring.spring4.DTOs.LinkDTO;
import com.spring.spring4.LinkMapper;
import com.spring.spring4.Service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/link/{url}/{pwd}")
    public ResponseEntity<LinkDTO> createLink(@PathVariable String url, @PathVariable String pwd) {
        iLinkService.createLink(url,pwd);
        return new ResponseEntity<>(LinkMapper.getLinkDTO(iLinkService.getLinkByUrl(url)),HttpStatus.CREATED);
    }

    @GetMapping ("/link/{id}/{pass}")
    public ResponseEntity<Object> redirectTo(@PathVariable int id, @PathVariable String pass) throws URISyntaxException {
        iLinkService.addLinkVisit(id);
       return iLinkService.getLinkByIDandPassword(id, pass);
    }

    @GetMapping ("/metrics/{id}")
    public ResponseEntity<Integer> linkMetrics(@PathVariable int id) {
        return new ResponseEntity<>(iLinkService.getLinkByID(id).getTimesAcceded(), HttpStatus.OK);
    }


    @PostMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidateLink(@PathVariable int id) {
        iLinkService.invalidateLink(id);
        return new ResponseEntity<>("Link with ID " + id + " has been disabled", HttpStatus.OK);
    }


}
