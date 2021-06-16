package com.tucasitatasaciones.tucasitatasaciones.controllers;

import com.tucasitatasaciones.tucasitatasaciones.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    //@Autowired
    //private IRoomService roomService;

    @GetMapping("/any")
    public ResponseEntity<?> getBiggestRoomByOwnership(@RequestParam("ownership") int ownershipId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getRoomsByOwnership(@RequestParam("ownership") int ownershipId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
