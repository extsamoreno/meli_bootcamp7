package com.meli.desafio2.controller;

import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.exception.PropertyIdAlreadyExistException;
import com.meli.desafio2.exception.PropertyIdNotFoundException;
import com.meli.desafio2.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/prop")
public class PropertyController {

    @Autowired
    IPropertyService propertyService;

    // 1- Calculate property total Area (m2)
    @GetMapping("/calcTotalM2/{propId}")
    public ResponseEntity<ResponsePropTotalAreaDTO> calcTotalArea(@PathVariable Integer propId) throws PropertyIdNotFoundException {
        return new ResponseEntity<>(propertyService.calcTotalArea(propId), HttpStatus.OK);
    }

    // 2- Calculate property value ($$)
    @GetMapping("/calcValue/{propId}")
    public ResponseEntity<ResponsePropValueDTO> calcPropValue(@PathVariable Integer propId) throws PropertyIdNotFoundException, DistrictIdNotFoundException {
        return new ResponseEntity<>(propertyService.calcPropValue(propId), HttpStatus.OK);
    }

    // 3- Get property biggest environment
    @GetMapping("/getBiggestEnv/{propId}")
    public ResponseEntity<ResponseBigEnvironmentDTO> getBigEnvironment(@PathVariable Integer propId) throws PropertyIdNotFoundException {
        return new ResponseEntity<>(propertyService.getBigEnvironment(propId), HttpStatus.OK);
    }

    // 4- Get a list with environments Area of a property
    @GetMapping("/listEnvInM2/{propId}")
    public ResponseEntity<List<ResponseEnvironmentDTO>> listEnvArea(@PathVariable Integer propId) throws PropertyIdNotFoundException {
        return new ResponseEntity<>(propertyService.listEnvironmentsArea(propId), HttpStatus.OK);
    }

    // Create a new property
    @PostMapping("/newProp")
    public ResponseEntity<String> createNewProp(@Valid @RequestBody PropertyDTO propDTO) throws PropertyIdAlreadyExistException, DistrictIdNotFoundException {
        return new ResponseEntity<>(propertyService.createNewProperty(propDTO), HttpStatus.OK);
    }
}
