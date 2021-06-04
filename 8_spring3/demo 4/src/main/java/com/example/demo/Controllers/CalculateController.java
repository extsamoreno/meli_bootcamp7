package com.example.demo.Controllers;

import com.example.demo.Repository.Plato;
import com.example.demo.Services.DTO.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/calculate")
public class CalculateController {


    @Autowired
    com.example.demo.ServiceDTO.CalculateService calculateService;

    @PostMapping("/plato")
    public ResponseDTO getInfoPlato(@RequestBody Plato plato){
        return calculateService.calculate(plato);
    }

    @PostMapping("/platos")
    public List<ResponseDTO> getInfoPlatos(@RequestBody List<Plato> platos){
        return calculateService.calculate(platos);
    }


}
