package com.example.APIStarwars.controller;

import com.example.APIStarwars.service.IStarwarsService;
import com.example.APIStarwars.service.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {
    @Autowired
    IStarwarsService iStarwarsService;

    @GetMapping("/info/{name}")
    public List<SubjectDTO> getSubjects(@PathVariable String name){
        return iStarwarsService.getSubject(name);
    }

}
