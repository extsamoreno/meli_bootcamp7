package com.meli.muelitas.controller;

import com.meli.muelitas.dto.DentistAvailabilityDTO;
import com.meli.muelitas.service.IDentistAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentistAvailability")
public class DentistAvailabilityController {

    @Autowired
    IDentistAvailabilityService dentistAvailabilityService;

    @PostMapping("/newDentistAvailability")
    ResponseEntity<Void> newDentistAvailability(@RequestBody DentistAvailabilityDTO dentistAvailabilityDTO) {
        dentistAvailabilityService.addDentistAvailability(dentistAvailabilityDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<DentistAvailabilityDTO>> getDentistAvailabilityList() {
        return new ResponseEntity<>(dentistAvailabilityService.getDentistAvailabilityDTOList(), HttpStatus.OK);
    }

    @GetMapping("/dentistId/{dentistId}")
    ResponseEntity<List<DentistAvailabilityDTO>> getDentistAvailabilityListByDentistId(@PathVariable Long dentistId) {
        return new ResponseEntity<>(dentistAvailabilityService.getDentistAvailabilityByDentistId(dentistId), HttpStatus.OK);
    }

    @GetMapping("/dayOfWeek/{dayOfWeek}")
    ResponseEntity<List<DentistAvailabilityDTO>> getDentistAvailabilityListByDayOfWeek(@PathVariable String dayOfWeek) {
        return new ResponseEntity<>(dentistAvailabilityService.getDentistAvailabilityByDayOfWeekAndDentistIsActive(dayOfWeek), HttpStatus.OK);
    }

}
