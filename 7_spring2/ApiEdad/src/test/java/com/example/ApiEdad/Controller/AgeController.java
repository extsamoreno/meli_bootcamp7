package com.example.ApiEdad.Controller;

import com.example.ApiEdad.Age;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<String> getAgeByDate(@PathVariable int day,@PathVariable int month, @PathVariable int year){
        String date = day+"/"+month+"/"+year;
        int age = Age.getAge(date);

        String result= String.valueOf(age) + "Years old";

        return new ResponseEntity<>(result, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("/{day}")
    public String getAgeByDate2(@PathVariable int day){

        return "hola";
    }



}
