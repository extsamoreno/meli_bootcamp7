package com.meli.codigo_morse.controller;

import com.meli.codigo_morse.service.MorseDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    MorseDecoder decoder;

    @PostMapping("/decode-morse")
    public ResponseEntity<?> decodeMorse(@RequestBody Map<String, String> code) {
        Map<String, Object> response = new HashMap<>();
        response.put("morse", code.get("code"));
        response.put("decoding", decoder.decode(code.get("code")));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
