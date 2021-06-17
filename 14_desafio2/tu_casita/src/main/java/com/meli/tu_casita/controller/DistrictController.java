package com.meli.tu_casita.controller;

import com.meli.tu_casita.service.IDistrictService;
import com.meli.tu_casita.model.dto.DistrictDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    IDistrictService districtService;

    @GetMapping("/districtList")
    public ResponseEntity<List<DistrictDTO>> getDistrictList() {
        return new ResponseEntity<>(districtService.getDistrictList(), HttpStatus.OK);
    }

    @PostMapping("/newDistrict")
    public ResponseEntity<Void> newDistrict(@RequestBody @Valid DistrictDTO districtDTO) {
        districtService.saveDistrict(districtDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
