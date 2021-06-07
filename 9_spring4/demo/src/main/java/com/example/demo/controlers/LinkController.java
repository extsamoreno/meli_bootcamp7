package com.example.demo.controlers;


import com.example.demo.dtos.LinkDTO;
import com.example.demo.dtos.UrlDTO;
import com.example.demo.exceptions.LinkDeactivetedException;
import com.example.demo.exceptions.NotAuthorizedException;
import com.example.demo.exceptions.UrlNotValidException;
import com.example.demo.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;

@RestController
//@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService linkService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity("pong", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUri(@RequestBody UrlDTO req) throws UrlNotValidException {
        return new ResponseEntity(linkService.add(req), HttpStatus.ACCEPTED);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectTo(@PathVariable int linkId, @RequestParam("password") String psw) throws LinkDeactivetedException, NotAuthorizedException {
        return linkService.redirect(linkId, psw);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkDTO> getMetrics(@PathVariable int linkId){
        return new ResponseEntity(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PatchMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId){
        return new ResponseEntity(linkService.invalidateLink(linkId), HttpStatus.OK);
    }

}
