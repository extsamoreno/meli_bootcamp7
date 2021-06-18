package com.meli.tuCasita.controller;

import com.meli.tuCasita.exception.HouseNotFoundException;
import com.meli.tuCasita.model.AmbientDTO;
import com.meli.tuCasita.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.HashMap;

@RestController
@RequestMapping("/houses")
public class HousesController {

    @Autowired
    IHouseService iHouseService;

    @GetMapping("/getmeter2/{id}")
    public ResponseEntity<?> getMeter2(@Valid @PathVariable Long id) throws HouseNotFoundException {
        Double value = this.iHouseService.getMeter2(id);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/getprice/{id}")
    public ResponseEntity<?> getPrice(@Valid @PathVariable Long id) throws HouseNotFoundException {
        Double value = this.iHouseService.getPrice(id);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/getmaxambient/{id}")
    public ResponseEntity<?> getMaxAmbient(@Valid @PathVariable Long id) throws HouseNotFoundException{
        AmbientDTO value = this.iHouseService.getMaxAmbient(id);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/{idHouse}/ambient/{nameAmbient}/getmaxambient")
    public ResponseEntity<?> getmaxambient(@Valid @PathVariable Long idHouse,@PathVariable String nameAmbient) throws HouseNotFoundException {
        HashMap value = this.iHouseService.getmaxambientforambient(idHouse, nameAmbient);
        return ResponseEntity.ok(value);
    }




}
