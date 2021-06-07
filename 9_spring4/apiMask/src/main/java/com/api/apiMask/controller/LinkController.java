package com.api.apiMask.controller;

import com.api.apiMask.controller.dto.request.UrlDTO;
import com.api.apiMask.controller.dto.response.LinkDTO;
import com.api.apiMask.exception.LinkDontExistException;
import com.api.apiMask.exception.LinkValidationException;
import com.api.apiMask.exception.URLAlreadyUsedException;
import com.api.apiMask.repository.entity.Link;
import com.api.apiMask.service.contract.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private ILinkService iLinkService;

    @GetMapping("/test")
    public String test(){
        return "testOk";
    }

    @PostMapping()
    public ResponseEntity<LinkDTO> createLink(@RequestBody UrlDTO urlDTO) throws URLAlreadyUsedException {
        return new ResponseEntity<>(iLinkService.createLink(urlDTO), HttpStatus.OK);
    }

    @PostMapping("/{linkId}")
    public RedirectView redirectTo(@PathVariable long linkId, @RequestParam(name = "password", required = false) String password) throws LinkValidationException {
        return iLinkService.redirect(linkId, password);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getRedirectCount(@PathVariable long linkId) throws LinkDontExistException {
        return new ResponseEntity<>(iLinkService.getRedirectCount(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkDTO> invalidateLink(@PathVariable long linkId) throws LinkDontExistException{
        return new ResponseEntity<>(iLinkService.invalidateLink(linkId), HttpStatus.OK);
    }
}