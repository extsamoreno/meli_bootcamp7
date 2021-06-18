package com.testingchallenge.tucasita.controller;

import com.testingchallenge.tucasita.dto.*;
import com.testingchallenge.tucasita.exception.NeighborhoodNotFoundException;
import com.testingchallenge.tucasita.exception.PropertyNotFoundException;
import com.testingchallenge.tucasita.service.iPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("property")
public class PropertyController {

    @Autowired
    iPropertyService iPropertyService;

    // US001 - get a property's area
    @GetMapping("/area/{propertyName}")
    public ResponseEntity<PropertyDTO> getPropertyArea(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getArea(propertyName), HttpStatus.OK);
    }

    // US002 - get a property's value
    @GetMapping("/value/{propertyName}")
    public ResponseEntity<PropertyValueDTO> getPropertyValue(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getValue(propertyName), HttpStatus.OK);
    }

    // US003 - get the bigger room in the property
    @GetMapping("/bigger-room/{propertyName}")
    public ResponseEntity<BiggerRoomDTO> getPropertyBiggerRoom(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getTheBiggerRoom(propertyName), HttpStatus.OK);
    }

    // US004 - get area by room
    @GetMapping("/area-by-room/{propertyName}")
    public ResponseEntity<PropertyRoomsDTO> getEveryRoomArea(@PathVariable String propertyName) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getRoomArea(propertyName), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addProperty (@RequestBody PropertyReqDTO propertyReqDTO) throws NeighborhoodNotFoundException {
        HttpStatus status = iPropertyService.addProperty(propertyReqDTO);
        return new ResponseEntity<>(status, status);
    }


}
