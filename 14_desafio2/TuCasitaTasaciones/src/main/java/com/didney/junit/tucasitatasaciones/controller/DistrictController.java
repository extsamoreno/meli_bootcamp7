package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.service.DistrictService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping("/add")
    ResponseEntity<?> addDistrict(@RequestBody DistrictDTO districtDTO) {
        return new ResponseEntity<>(districtService.addDistrict(districtDTO), HttpStatus.OK);
    }

    @PostMapping("/adds")
    ResponseEntity<?> addDistricts(@RequestBody List<DistrictDTO> districtDTOList) {
        return new ResponseEntity<>(districtService.addDistricts(districtDTOList), HttpStatus.OK);
    }

}
