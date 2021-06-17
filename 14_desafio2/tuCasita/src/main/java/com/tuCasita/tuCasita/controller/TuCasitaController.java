package com.tuCasita.tuCasita.controller;

import com.tuCasita.tuCasita.models.DTO.HouseDTO;
import com.tuCasita.tuCasita.models.DTO.ResponseRoomsDTO;
import com.tuCasita.tuCasita.models.House;
import com.tuCasita.tuCasita.models.Room;
import com.tuCasita.tuCasita.service.iTuCasitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tuCasita")
public class TuCasitaController {

    @Autowired
    iTuCasitaService service;

    @PostMapping("/totalM2")
    public ResponseEntity<HouseDTO> calculateTotalM2(@RequestBody @Valid House house){
        return (new ResponseEntity<>(service.calculateTotalM2(house), HttpStatus.OK));
    }

    @PostMapping("/houseValue")
    public ResponseEntity<HouseDTO> calculateHouseValue (@RequestBody @Valid House house) {
        return (new ResponseEntity<>(service.calculateHouseValue(house), HttpStatus.OK));
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<Room> biggestRoom (@RequestBody @Valid House house){
        return (new ResponseEntity<>(service.biggestRoom(house), HttpStatus.OK));
    }

    @PostMapping("/roomM2")
    public ResponseEntity<ResponseRoomsDTO> calculateRoomM2(@RequestBody @Valid House house){
        return (new ResponseEntity<>(service.calculateRoomM2(house), HttpStatus.OK));
    }
}
