package com.example.demo.controller;


import com.example.demo.service.Conversions;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


import java.util.Map;

@RestController
public class MainController {

    @Autowired
    private Conversions conversions;
    @ApiOperation("Convert decimal to roman")
    @GetMapping("/decimal-to-roman/{num}")
    public ResponseEntity<?> decimalToRoman(@PathVariable Integer num) {

        //http://localhost:8080/first-api/v1/swagger-ui/index.html#/
        Map<String, Object> response = new HashMap<>();
        response.put("decimal", num);
        response.put("roman", conversions.integerToRoman(num));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

