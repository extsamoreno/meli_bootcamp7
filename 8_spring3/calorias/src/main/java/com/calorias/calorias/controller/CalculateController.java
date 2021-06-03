package com.calorias.calorias.controller;
import com.calorias.calorias.repositories.Plato;
import com.calorias.calorias.services.CalculateService;
import com.calorias.calorias.services.dto.ResponseDTO;
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
    CalculateService calculateService;

    @PostMapping("/plato")
    public ResponseDTO getInfoPlato(@RequestBody Plato plato){
        return calculateService.calculate(plato);
    }

    @PostMapping("/platos")
    public List<ResponseDTO> getInfoPlatos(@RequestBody List<Plato> platos){
        return calculateService.calculate(platos);
    }


}
