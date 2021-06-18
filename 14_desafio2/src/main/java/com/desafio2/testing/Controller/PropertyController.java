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
    public ResponseEntity<?> crearPropiedad (@Valid @RequestBody PropiedadRequestDTO propiedad) throws DistrictNonExistentException, ExistenPropertyException {
        return new ResponseEntity<>(iPropertyService.createNewProperty(propiedad),HttpStatus.OK);
    }


    @GetMapping("/m2Propiedad/{nombre}")  //CU0001
    public ResponseEntity<PropertyM2DTO> m2Propiedad(@PathVariable String nombre) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcM2PropDTO(nombre), HttpStatus.OK);
    }


    @GetMapping("/valorProp/{nombre}") //CU0002
    public ResponseEntity<PropertyValueDTO> valorProp(@PathVariable String nombre) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcPropValueDTO(nombre), HttpStatus.OK);
    }


    @GetMapping("/ambienteMasGrande/{nombre}")  //CU0003
    public ResponseEntity<RoomDTO> ambienteMasGrande(@PathVariable String nombre) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcBiggestRoom(nombre), HttpStatus.OK);
    }


    @GetMapping("/listaM2/{nombre}") //CU0004
    public ResponseEntity<PropertyRoomListM2DTO> calcularListaAmbientesM2(@PathVariable String nombre) throws PropertyNonExistentException {
        return new ResponseEntity<>(iPropertyService.calcRoomListM2(nombre), HttpStatus.OK);
    }



}
