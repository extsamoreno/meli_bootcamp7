package com.example.calculadora;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HouseController {

    @PostMapping("house")
    public ResponseEntity<HouseResponse> getBiggestRoom(@RequestBody House house){

        return new ResponseEntity<HouseResponse>(new HouseResponse(house),HttpStatus.OK);
    }
}
