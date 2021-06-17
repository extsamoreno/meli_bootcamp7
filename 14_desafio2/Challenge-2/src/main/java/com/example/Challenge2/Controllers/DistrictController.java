package com.example.Challenge2.Controllers;

import com.example.Challenge2.Exceptions.DistrictNotFoundException;
import com.example.Challenge2.Exceptions.PropertyNotFoundException;
import com.example.Challenge2.Models.District;
import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Services.DTOs.*;
import com.example.Challenge2.Services.IDistrictService;
import com.example.Challenge2.Services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class DistrictController {

    @Autowired
    IDistrictService iDistrictService;


    @PostMapping("/districts")
    public ResponseEntity<Boolean>store(@Valid @RequestBody DistrictDTO districtDTO) {
        return new ResponseEntity<>(iDistrictService.storeDistrict(districtDTO),HttpStatus.OK);
    }

    @GetMapping("/districts")
    public ResponseEntity<List<District>>getall() {
        return new ResponseEntity<>(iDistrictService.getall(),HttpStatus.OK);
    }
}
