package com.example.demo.ex1.controller;

import com.example.demo.ex1.dto.HouseDto;
import com.example.demo.ex1.dto.HouseResponseDto;
import com.example.demo.ex1.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseController {

    HouseService hs = new HouseService();

    @PostMapping("/info")
    public ResponseEntity<HouseResponseDto> getHouseResponse(@RequestParam HouseDto hd) {
        return new ResponseEntity<>(hs.getInfoHouse(hd), HttpStatus.OK);
    }
}
