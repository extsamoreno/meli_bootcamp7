package com.example.LinkTracker.controller;

import com.example.LinkTracker.service.ILinkService;
import com.example.LinkTracker.service.dto.LinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("link")
public class LinkController {
    @Autowired
    ILinkService iLinkService;

    @PostMapping("/create")
    public LinkDTO create(@RequestBody LinkDTO link){
        return iLinkService.create(link);
    }
    @GetMapping("/{linkId}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkDTO link = iLinkService.redirect(linkId);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping(value = "/{linkId}", params = {"password"})
    public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        LinkDTO link = iLinkService.redirect(linkId, password);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping("metrics/{linkId}")
    public LinkDTO metrics(@PathVariable Integer linkId) throws IOException {
        return iLinkService.metrics(linkId);
    }

    @PostMapping("invalidate/{linkId}")
    public void invalidate(@PathVariable Integer linkId) throws IOException {
        iLinkService.invalidate(linkId);
    }

}
