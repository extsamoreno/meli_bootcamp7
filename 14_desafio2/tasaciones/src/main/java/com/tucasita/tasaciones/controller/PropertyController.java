package com.tucasita.tasaciones.controller;

import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.service.PropertyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/")
    public ResponseEntity<?> saveProperty(@Valid @RequestBody PropertyDTO property) throws IOException {
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
}
