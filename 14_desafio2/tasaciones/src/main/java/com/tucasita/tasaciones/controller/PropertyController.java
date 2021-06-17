package com.tucasita.tasaciones.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.dto.RoomSquareMetersDTO;
import com.tucasita.tasaciones.exception.NeighborhoodNotFoundException;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.service.PropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("")
    public ResponseEntity<?> saveProperty(@Valid @RequestBody PropertyDTO property) throws IOException, NeighborhoodNotFoundException {
        propertyService.saveProperty(property);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/area/{id}")
    public ResponseEntity<Double> getSquareMeters(@PathVariable int id) throws PropertyNotFoundException {
        return ResponseEntity.ok(propertyService.calculateSquareMeters(id));
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Double> getPropertyPrice(@PathVariable int id)  throws PropertyNotFoundException {
        return ResponseEntity.ok(propertyService.getPropertyPrice(id));
    }

    @GetMapping("/biggest-room/{id}")
    public ResponseEntity<RoomDTO> getBiggestRoom(@PathVariable int id) throws PropertyNotFoundException {
        return ResponseEntity.ok(propertyService.getBiggestRoom(id));
    }

    @GetMapping("/rooms/area/{id}")
    public ResponseEntity<List<RoomSquareMetersDTO>> getRoomsSquareMeters(@PathVariable int id) throws PropertyNotFoundException {
        return ResponseEntity.ok(propertyService.getRoomsSquareMeters(id));
    }
}
