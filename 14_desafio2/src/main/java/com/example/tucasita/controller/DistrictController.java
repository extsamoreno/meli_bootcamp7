package com.example.tucasita.controller;

import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.ResponseDTO;
import com.example.tucasita.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * TuCasita REST API - District Controller
 *
 * @author Macarena Agostina Pomerantz
 */

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    /**
     * Creates a new district in local repository
     *
     * @param district the district you want to create in local repository
     * @return validation of district creation
     */

    @PostMapping("/addOne")
    public ResponseEntity<ResponseDTO> addOneDistrict(@RequestBody @Valid DistrictDTO district) {
        return new ResponseEntity<>(districtService.addOneDistrict(district), HttpStatus.CREATED);
    }

}
