package com.tucasitatasaciones.tucasitatasaciones.controllers;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.DistrictNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.IOwnershipService;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithDataDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithPriceDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.OwnershipWithSquareMeterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ownerships")
public class OwnershipController {

    @Autowired
    private IOwnershipService ownershipService;

    @PostMapping
    public ResponseEntity<OwnershipWithDataDTO> addOwnership(@RequestBody @Valid OwnershipWithDataDTO ownership) throws DistrictNotFoundException {

        OwnershipWithDataDTO result = ownershipService.add(ownership);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{ownershipId}/square-meter")
    public ResponseEntity<OwnershipWithSquareMeterDTO> calculateSquareMeterByOwnership(@PathVariable int ownershipId) throws OwnershipNotFoundException {

        OwnershipWithSquareMeterDTO result = ownershipService.calculateSquareMeterByOwnership(ownershipId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{ownershipId}/price")
    public ResponseEntity<OwnershipWithPriceDTO> calculatePriceByOwnership(@PathVariable int ownershipId) throws DistrictNotFoundException, OwnershipNotFoundException {

        OwnershipWithPriceDTO result = ownershipService.calculatePriceByOwnership(ownershipId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
