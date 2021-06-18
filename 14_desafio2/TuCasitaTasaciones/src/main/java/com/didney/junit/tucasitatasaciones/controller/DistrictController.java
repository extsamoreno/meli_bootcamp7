package com.didney.junit.tucasitatasaciones.controller;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.service.DistrictService;
import com.didney.junit.tucasitatasaciones.service.IDistrictService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    IDistrictService iDistrictService;

    public DistrictController(IDistrictService iDistrictService) {
        this.iDistrictService = iDistrictService;
    }

    @PostMapping("/add")
    ResponseEntity<DistrictDTO> addDistrict(@RequestBody DistrictDTO districtDTO) {
        return new ResponseEntity<>(iDistrictService.addDistrict(districtDTO), HttpStatus.OK);
    }

    @PostMapping("/adds")
    ResponseEntity<List<DistrictDTO>> addDistricts(@RequestBody List<DistrictDTO> districtDTOList) {
        return new ResponseEntity<>(iDistrictService.addDistricts(districtDTOList), HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<List<DistrictDTO>> getDistricts() {
        return new ResponseEntity<>(iDistrictService.getDistricts(), HttpStatus.OK);
    }

}
