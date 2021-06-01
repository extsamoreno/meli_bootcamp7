package com.meli.exercise.controller;

import com.meli.exercise.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("conversion")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping("roman/{num}")
    public ResponseEntity<?> decimalToRoman(@PathVariable Integer num){
        Map<String, Object> response = new HashMap<>();
        response.put("decimal", num);
        response.put("roman", conversionService.decimalToRoman(num));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
