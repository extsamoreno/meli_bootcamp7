package com.desafio2.demo.Controller;

import com.desafio2.demo.Model.DTO.*;
import com.desafio2.demo.Exception.DistrictNotExistException;
import com.desafio2.demo.Service.IPropService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TuCasita")
public class PropController {


    @Autowired
    IPropService propService;

    @ApiOperation("Total square meters of property")
    @PostMapping("/totalMeters")
    public ResponseEntity<PropDTOTMeters> totalMeters(
            @ApiParam(value = "Property with district and environments. The name must start with upperCase and cant be empty.")
            @Valid  @RequestBody PropRequest propRequest) {

        return new ResponseEntity<>(propService.totalSquareMeters(propRequest), HttpStatus.OK);
    }

    @ApiResponses({@ApiResponse(code=400, message = "District not exist in database")})
    @ApiOperation("Total price of one property")
    @PostMapping("/totalPrice")
    public ResponseEntity<PropDTOTPrice> totalPrice(
            @ApiParam(value = "Property with district and environments. The name must start with upperCase and cant be empty.")
            @Valid @RequestBody PropRequest propRequest) throws DistrictNotExistException {
        return new ResponseEntity<>(propService.priceProp(propRequest), HttpStatus.OK);
    }

    @ApiOperation("One or more bigger environment of property")
    @PostMapping("/bigEnvironment")
    public ResponseEntity<List<EnvironmentDTOResponse>> bigEnvironment(
            @ApiParam(value = "Property with district and environments. The name must start with upperCase and cant be empty.")
            @Valid @RequestBody PropRequest propRequest){
        return new ResponseEntity<>(propService.bigEnvironment(propRequest), HttpStatus.OK);
    }

    @ApiOperation("Total square meters by environment of property")
    @PostMapping("/totalMetersByEnvironments")
    public ResponseEntity<PropDTOTMeterByEnvironment> totalMetersByEnvironments(
            @ApiParam(value = "Property with district and environments. The name must start with upperCase and cant be empty.")
            @Valid @RequestBody PropRequest propRequest){
        return new ResponseEntity<>(propService.meterByEnvironment(propRequest), HttpStatus.OK);
    }

}
