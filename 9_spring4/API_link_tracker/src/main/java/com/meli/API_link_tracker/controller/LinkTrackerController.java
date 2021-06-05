package com.meli.API_link_tracker.controller;

import com.meli.API_link_tracker.model.dto.LinkRequest;
import com.meli.API_link_tracker.model.dto.LinkRespond;
import com.meli.API_link_tracker.model.exception.*;
import com.meli.API_link_tracker.model.service.ServiceLinkTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class LinkTrackerController {
    @Autowired
    private ServiceLinkTracker serviceLinkTracker;

    @GetMapping("/")
    public ResponseEntity<String> getMain() {
        String message = "Welcome to the API Link Tracker";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<LinkRespond> createLink(@RequestBody LinkRequest linkRequest, @RequestParam String password,
                                                  HttpServletRequest request)
            throws FormatLinkNotValidateException, PasswordNotEnteredException, LinkAlreadyCreatedException {
        return new ResponseEntity<>(serviceLinkTracker.createLinktoDataBase(linkRequest, password, request.
                getRequestURL().toString()), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Object> redirecLink(@PathVariable int linkId) throws LinkAlreadyInvalidatedException,
            IDNotFoundException, URISyntaxException {
        return new ResponseEntity<>(serviceLinkTracker.changeToHttpHeader(linkId), HttpStatus.SEE_OTHER) ;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable int linkId) throws IDNotFoundException {
        return new ResponseEntity<>(serviceLinkTracker.getMetricsOfLink(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId) throws LinkAlreadyInvalidatedException,
            IDNotFoundException {
        serviceLinkTracker.invalidateLink(linkId);
        return new ResponseEntity<>("Link Invalidate", HttpStatus.OK);
    }
}