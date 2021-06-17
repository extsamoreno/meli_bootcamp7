package com.tucasitatasaciones.tucasitatasaciones.controllers;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.IRoomService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/any")
    public ResponseEntity<RoomWithSquareMeterDTO> getBiggestRoomByOwnership(@RequestParam("ownership") int ownershipId) throws OwnershipNotFoundException {

        RoomWithSquareMeterDTO result = roomService.getBiggestRoomByOwnership(ownershipId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoomWithSquareMeterDTO>> getRoomsByOwnership(@RequestParam("ownership") int ownershipId) throws OwnershipNotFoundException {

        List<RoomWithSquareMeterDTO> result = roomService.getRoomsByOwnership(ownershipId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
