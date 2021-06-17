package com.desafrio2.Desafio1.Controller;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.DTO.*;
import com.desafrio2.Desafio1.Service.IPropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/TuCasita")
public class PropController {

    @Autowired
    IPropService propService;

    @PostMapping("/totalMeters")
    public ResponseEntity<PropDTOTMeters> totalMeters(@Valid  @RequestBody PropRequest propRequest){
        return new ResponseEntity<>(propService.totalSquareMeters(propRequest), HttpStatus.OK);
    }

    @PostMapping("/totalPrice")
    public ResponseEntity<PropDTOTPrice> totalPrice(@Valid @RequestBody PropRequest propRequest) throws DistrictNotExist {
        return new ResponseEntity<>(propService.priceProp(propRequest), HttpStatus.OK);
    }

    @PostMapping("/bigEnvironment")
    public ResponseEntity<EnvironmentDTO> bigEnvironment(@Valid @RequestBody PropRequest propRequest){
        return new ResponseEntity<>(propService.bigEnvironment(propRequest), HttpStatus.OK);
    }

    @PostMapping("/totalMetersByMeters")
    public ResponseEntity<PropDTOTMeterByEnvironment> totalMetersByEnvironments(@Valid @RequestBody PropRequest propRequest){
        return new ResponseEntity<>(propService.meterByEnvironment(propRequest), HttpStatus.OK);
    }

    //Revisar si hay dos con la misma medida

}
