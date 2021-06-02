package com.meli.spring2;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api")

public class ApiController {

    @GetMapping("/hola")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/getHouse")
    public HouseResponseDTO getHouse(@RequestBody HouseRequestDTO houseRequestDTO){

        ApiService apiService = new ApiService();
        return apiService.getHouse(houseRequestDTO);
    }

    @GetMapping("/age/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){

        Period period = Period.between(LocalDate.of(year, month, day), LocalDate.now());

        return period.getYears();
    }

    @PostMapping("/degree")
    public Degree getDegree(@RequestBody StudentHistoryDTO studentHistoryDTO){

        return studentHistoryDTO.getDegree();

    }
}