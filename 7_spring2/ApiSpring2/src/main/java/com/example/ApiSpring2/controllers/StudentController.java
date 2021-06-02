package com.example.ApiSpring2.controllers;

import com.example.ApiSpring2.dto.DiplomaDTO;
import com.example.ApiSpring2.services.DiplomaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    DiplomaService service = new DiplomaService();
    @GetMapping("/note/{id}")
    public DiplomaDTO getDiploma(@PathVariable("id") Integer id) {
        return service.getDiploma(id);
    }
}
