package com.meli.socialmeli.controller;

import com.meli.socialmeli.context.Context;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/context")
public class ContextController {

    /**
     * Loads a context scenario to emulate the pre-existing data in the data storage sources.
     * The context is reinitialized each time this method is called
     *
     * @return a String indicating that the context has been loaded successfully
     */
    @PostMapping("/loadContext")
    public ResponseEntity<String> loadContext() {
        Context.loadContext();
        return new ResponseEntity<>("The Context has been generated successfully", HttpStatus.OK);
    }

}
