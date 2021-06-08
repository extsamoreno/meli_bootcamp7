package com.example.demo.project.controller;

import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.models.Publication;
import com.example.demo.project.service.IPublicationService;
import com.example.demo.project.service.dto.PublicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class PublicationController {

    @Autowired
    IPublicationService iPublicationService;

    //US 0001
    @PostMapping("/newpost")
    public HttpStatus newPost(@RequestBody PublicationDTO publicationDTO) throws DuplicatedPublicationIdException {
        iPublicationService.newPost(publicationDTO);
        return HttpStatus.OK;
    }
}
