package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/year")
public class AgeController {
    @GetMapping("/{day}/{month}/{year}")

    //public ResponseEntity<AgeDTO> getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
    public String  getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        Age age = new Age();
        //AgeDTO ageDTO = new AgeDTO(day+"/"+month+"/"+year,age.age(year,month,day));
        //ResponseEntity<AgeDTO> responseEntity = new ResponseEntity<>(ageDTO, HttpStatus.OK);
        return age.age(year,month,day);
        //return responseEntity;
    }


}
