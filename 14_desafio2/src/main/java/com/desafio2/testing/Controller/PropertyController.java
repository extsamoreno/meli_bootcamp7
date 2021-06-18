package com.desafio2.testing.Controller;


import com.desafio2.testing.Dto.*;
import com.desafio2.testing.Exception.DistrictNonExistentException;
import com.desafio2.testing.Exception.PropertyNonExistentException;
import com.desafio2.testing.Exception.ExistenPropertyException;
import com.desafio2.testing.Service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController

public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;


    @PostMapping("/crearPropiedad")
    public ResponseEntity<?> createProperty(@Valid @RequestBody PropiedadRequestDTO property) throws DistrictNonExistentException, ExistenPropertyException {
        return new ResponseEntity<>(iPropertyService.createNewProperty(property), HttpStatus.OK);
    }


    @GetMapping("/m2Propiedad/{name}")  //CU0001
    public ResponseEntity<PropertyM2DTO> m2Property(@PathVariable String name) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcM2PropDTO(name), HttpStatus.OK);
    }


    @GetMapping("/valorProp/{name}") //CU0002
    public ResponseEntity<PropertyValueDTO> valueProp(@PathVariable String name) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcPropValueDTO(name), HttpStatus.OK);
    }


    @GetMapping("/ambienteMasGrande/{name}")  //CU0003
    public ResponseEntity<RoomDTO> biggestRoom(@PathVariable String name) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcBiggestRoom(name), HttpStatus.OK);
    }


    @GetMapping("/listaM2/{name}") //CU0004
    public ResponseEntity<PropertyRoomListM2DTO> calcRoomListM2(@PathVariable String name) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcRoomListM2(name), HttpStatus.OK);
    }


}
