package com.linktracker.linktracker.controllers;
import com.linktracker.linktracker.exceptions.InvalidLinkException;
import com.linktracker.linktracker.exceptions.LinkAlreadyExistException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.exceptions.LinkNotValidToRedirectException;
import com.linktracker.linktracker.services.LinkService;
import com.linktracker.linktracker.services.dtos.LinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/linktracker")
public class LinkTrackerController {

    @Autowired
    LinkService linkService;

    @PostMapping(value = "/{url}",params = {"password"})
    public ResponseEntity<LinkDTO> insertLink(@PathVariable String url,@RequestParam("password") String password) throws LinkAlreadyExistException, InvalidLinkException {
        return new ResponseEntity<>(linkService.insertLink(url,password), HttpStatus.OK);
    }

    @GetMapping(value = "/link/{linkId}",params = {"password"})
    public void redirectLink(@PathVariable int linkId, @RequestParam("password") String password, HttpServletResponse response)  throws IOException, LinkNotFoundException, LinkNotValidToRedirectException {
        LinkDTO linkDto = linkService.redirectLink(linkId,password);
        if(linkDto!=null){
            response.sendRedirect(linkDto.getLink());
        }else{
            response.sendError(404);
        }
    }

    @PostMapping("/link/invalidate/{linkId}")
    public ResponseEntity<LinkDTO> invalidateLink(@PathVariable int linkId) throws LinkNotFoundException {
        return new ResponseEntity<>(linkService.invalidateLink(linkId),HttpStatus.OK);
    }


}
