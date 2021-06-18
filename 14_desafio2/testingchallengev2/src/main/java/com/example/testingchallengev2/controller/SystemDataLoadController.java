package com.example.testingchallengev2.controller;

import com.example.testingchallengev2.model.request.DistrictDTO;
import com.example.testingchallengev2.model.request.HouseDTO;
import com.example.testingchallengev2.model.response.DistrictCreatedResponseDTO;
import com.example.testingchallengev2.model.response.DistrictUpdatedResponseDTO;
import com.example.testingchallengev2.model.response.NewHouseResponseDTO;
import com.example.testingchallengev2.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tuCasitaAdmin")
public class SystemDataLoadController {

    @Autowired
    IAdminService iAdminService;

    @PostMapping("/newDistrict")
    public ResponseEntity<DistrictCreatedResponseDTO> createDistrict(
            @Valid @RequestBody DistrictDTO districtDTO)
    {
        return new ResponseEntity<>(iAdminService.newDistrict(districtDTO)
                , HttpStatus.OK);
    }

    @PostMapping("/updateDistrict")
    public ResponseEntity<DistrictUpdatedResponseDTO> updateDistrict(
            @Valid @RequestBody DistrictDTO districtDTO)
    {
        return new ResponseEntity<>(iAdminService.updateDistrict(districtDTO)
                , HttpStatus.OK);
    }

    @PostMapping("/newHouse")
    public ResponseEntity<NewHouseResponseDTO> createHouse(
            @Valid @RequestBody HouseDTO houseDTO)
    {
        return new ResponseEntity<>(iAdminService.createHouse(houseDTO)
                , HttpStatus.OK);
    }

}
