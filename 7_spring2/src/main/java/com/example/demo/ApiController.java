package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class ApiController {

    @PostMapping("/getHouse")
    public HouseResponseDTO getHouse(@RequestBody HouseRequestDTO houseRequestDTO){

        ApiService apiService = new ApiService();
        return apiService.getHouse(houseRequestDTO);
    }

    @GetMapping("/hola")
    public String hello(){
        return "Hello";
    }
}
