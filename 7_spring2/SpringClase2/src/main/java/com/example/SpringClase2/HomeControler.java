package com.example.SpringClase2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeControler {

    @GetMapping("/hello")
    public String hello() {
        return "hola";
    }

    @PostMapping("/getHouse")
    public HomeDTO area(@RequestBody Home home) {
        return ApiService.getHouse(home);
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
