package com.example.tucasita.controller;

import com.example.tucasita.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class TuCasitaController {

    @Autowired
    IHouseService houseService;


}
