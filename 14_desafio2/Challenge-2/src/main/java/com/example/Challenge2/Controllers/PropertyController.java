package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PropertyController {

    @Autowired
    IPropertyService iPropertyService;

    @GetMapping("/properties/{propertyId}/biggestRoom")
    public ResponseEntity<RoomDTO>getBiggestRoom(@PathVariable Long propertyId) throws  PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getBiggestRoom(propertyId),HttpStatus.OK);
    }

    @GetMapping("/properties/{propertyId}/value")
    public ResponseEntity<ValueDTO>getValue(@PathVariable Long propertyId) throws PropertyNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.getPropertyValue(propertyId),HttpStatus.OK);
    }

    @GetMapping("/properties/{propertyId}/dimensions")
    public ResponseEntity<StructureDTO>getDimensions(@PathVariable Long propertyId) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getPropertyDimensions(propertyId),HttpStatus.OK);
    }

    @GetMapping("/properties/{propertyId}/rooms")
    public ResponseEntity<List<StructureDTO>>getRooms(@PathVariable Long propertyId) throws PropertyNotFoundException {
        return new ResponseEntity<>(iPropertyService.getDimensionedRooms(propertyId),HttpStatus.OK);
    }

    @PostMapping("/properties")
    public ResponseEntity<Boolean>store(@Valid @RequestBody PropertyDTO property) throws DistrictNotFoundException {
        return new ResponseEntity<>(iPropertyService.storeProperty(property),HttpStatus.OK);
    }

}
