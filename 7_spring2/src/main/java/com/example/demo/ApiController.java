package com.example.demo;

import com.example.demo.dtos.HouseRequestDTO;
import com.example.demo.dtos.HouseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/getHouse")
    public HouseResponseDTO getHouse(@RequestBody HouseRequestDTO houseRequestDTO){

        return apiService.getHouse(houseRequestDTO);
    }

    @GetMapping("/age/{day}/{month}/{year}")
    public int getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){

        Period period = Period.between(LocalDate.of(year, month,day), LocalDate.now());
        return period.getYears();
    }
}
