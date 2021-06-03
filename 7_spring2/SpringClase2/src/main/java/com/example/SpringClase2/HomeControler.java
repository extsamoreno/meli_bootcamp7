package com.example.SpringClase2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class HomeControler {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @PostMapping("/getHouse")
    public HomeDTO area(@RequestBody House house) {

        return ApiService.getHouse(house);
    }

    @GetMapping("/{year}/{month}/{day}")
    public int age(@PathVariable int year,
                    @PathVariable int month,
                    @PathVariable int day){

        return ApiService.getAge(year,month,day);
    }

    @PostMapping("/getAverage")
    public Degreed degreed(@RequestBody Student student){
        return ApiService.degreed(student);
    }
}
