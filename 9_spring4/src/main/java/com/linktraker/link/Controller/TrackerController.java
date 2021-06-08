package com.linktraker.link;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracker")
public class Controller {

    @PostMapping("/url")
    public ResponseEntity<Integer> getById(@RequestBody Integer id)  throws ProductIdNotFoundException {
        return new ResponseEntity<>(iProductService.getProductById(id), HttpStatus.OK);
    }




}
