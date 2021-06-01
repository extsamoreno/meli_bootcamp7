package com.meli.exercise.controller;

import com.meli.exercise.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/morse")
    public ResponseEntity<?> decodeMorse(@RequestBody Map<String, String> body){
        Map<String, Object> response = new HashMap<>();
        response.put("morse", body.get("code"));
        response.put("message", conversionService.decodeMorse(body.get("code")));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
