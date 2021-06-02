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
}
