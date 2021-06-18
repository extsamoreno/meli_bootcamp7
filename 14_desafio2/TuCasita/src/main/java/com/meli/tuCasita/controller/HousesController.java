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

    /**
     *
     * @param id by house
     * @return returns square meters of a house
     * @throws HouseNotFoundException
     */
    @GetMapping("/getmeter2/{id}")
    public ResponseEntity<?> getMeter2(@Valid @PathVariable Long id) throws HouseNotFoundException {
        Double value = this.iHouseService.getMeter2(id);
        return ResponseEntity.ok(value);
    }

    /**
     *
     * @param id by house
     * @return returns price of a house
     * @throws HouseNotFoundException
     */
    @GetMapping("/getprice/{id}")
    public ResponseEntity<?> getPrice(@Valid @PathVariable Long id) throws HouseNotFoundException {
        Double value = this.iHouseService.getPrice(id);
        return ResponseEntity.ok(value);
    }


    /**
     *
     * @param id by house
     * @return returns the largest ambient of a house
     * @throws HouseNotFoundException
     */
    @GetMapping("/getmaxambient/{id}")
    public ResponseEntity<?> getMaxAmbient(@Valid @PathVariable Long id) throws HouseNotFoundException{
        AmbientDTO value = this.iHouseService.getMaxAmbient(id);
        return ResponseEntity.ok(value);
    }

    /**
     *
     * @param idHouse by house
     * @param nameAmbient by ambient
     * @return returns the square meters an ambient
     * @throws HouseNotFoundException
     */
    @GetMapping("/{idHouse}/ambient/{nameAmbient}/getmaxambient")
    public ResponseEntity<?> getmaxambient(@Valid @PathVariable Long idHouse,@PathVariable String nameAmbient) throws HouseNotFoundException {
        HashMap value = this.iHouseService.getmaxambientforambient(idHouse, nameAmbient);
        return ResponseEntity.ok(value);
    }




}
