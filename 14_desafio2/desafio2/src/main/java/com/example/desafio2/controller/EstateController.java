package com.example.desafio2.controller;

import com.example.desafio2.dto.*;
import com.example.desafio2.service.IEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/property")
public class EstateController {

	@Autowired
	IEstateService estateService;

	@PostMapping("/add")
	ResponseEntity<HttpStatus> add(@Valid @RequestBody EstateDTO estate) {
		estateService.add(estate);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	// US-0001
	@GetMapping("/square_meters/{name}")
	ResponseEntity<SquareMetersDTO> squareMeters(@PathVariable String name) {
		SquareMetersDTO sqm = estateService.getEstateSquareMeters(name);
		return new ResponseEntity<>(sqm, HttpStatus.OK);
	}

	// US-0002
	@GetMapping("/value/{name}")
	ResponseEntity<Double> value(@PathVariable String name) {
		Double value = estateService.getEstateValue(name);
		return new ResponseEntity<>(value, HttpStatus.OK);
	}

	// US-0003
	@GetMapping("/biggest_env/{name}")
	ResponseEntity<LargestEnvironmentDTO> biggestEnvironment(@PathVariable String name) {
		LargestEnvironmentDTO environment = estateService.getLargestEnvironment(name);
		return new ResponseEntity<>(environment, HttpStatus.OK);
	}

	// US-0004
	@GetMapping("/env_sqm/{name}")
	ResponseEntity<EnvironmentsSquareMetersDTO> environmentsSquaremeters(@PathVariable String name) {
		EnvironmentsSquareMetersDTO sqm = estateService.getEnvironmentsSquareMeters(name);
		return new ResponseEntity<>(sqm, HttpStatus.OK);
	}
}
