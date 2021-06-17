package com.desafio.TuCasitaTasacionesApp.controllers;

import com.desafio.TuCasitaTasacionesApp.model.dto.RoomDTO;
import com.desafio.TuCasitaTasacionesApp.model.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/propiety")
public class CalculateRestController {

    @Autowired
    ICalculateService iCalculateService;

    @GetMapping("/calculate/squearemeter/{name}")
    public ResponseEntity<String> getSquareMeterForPropiety(@RequestParam String name) {
        return new ResponseEntity<String>(iCalculateService.getSquareMeterForPropiety(name), HttpStatus.OK);
    }

    @GetMapping("calculate/value/{name}")
    public ResponseEntity<String> getValueForPropiety(@RequestParam String name) {
        return new ResponseEntity<String>(iCalculateService.getValueForPropiety(name), HttpStatus.OK);
    }

    @GetMapping("room/obtain/biggest/{name}")
    public ResponseEntity<RoomDTO> getBiggestRoom(@RequestParam String name) {
        return new ResponseEntity<RoomDTO>(iCalculateService.getBiggestRoom(name), HttpStatus.OK);
    }

    @GetMapping("room/calculate/squearemeter/{name}")
    public ResponseEntity<String> getSquareMeterForRoom(@RequestParam String name) {
        return new ResponseEntity<String>(iCalculateService.getSquareMeterForRoom(name), HttpStatus.OK);
    }

}
