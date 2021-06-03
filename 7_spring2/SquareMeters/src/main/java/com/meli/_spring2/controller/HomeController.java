package com.meli._spring2.controller;

import com.meli._spring2.dto.HomeDTO;
import com.meli._spring2.dto.HomeValueDTO;
import com.meli._spring2.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private IHomeService homeService;

    @PostMapping("/getHouseValue")
    public ResponseEntity<HomeValueDTO> getHouseValue(@RequestBody HomeDTO home){
        return new ResponseEntity<>(homeService.getHomeValue(home), HttpStatus.OK);
    }


}
