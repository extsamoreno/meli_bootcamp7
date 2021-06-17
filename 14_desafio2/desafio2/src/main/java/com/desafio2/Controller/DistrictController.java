package com.desafio2.Controller;

import com.desafio2.Model.District;
import com.desafio2.Service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/district/")
public class DistrictController {

    @Autowired
    IDistrictService iDistrictService;

    @PostMapping("/create")
    public ResponseEntity<?> createDistrict(@RequestBody @Valid District district) {
        this.iDistrictService.create(district);
        return ResponseEntity.ok(null);
    }
}