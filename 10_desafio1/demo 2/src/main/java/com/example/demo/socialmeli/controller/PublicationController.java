package com.example.demo.socialmeli.controller;

import com.example.demo.socialmeli.repository.Publication;
import com.example.demo.socialmeli.service.IPublicationService;
import com.example.demo.socialmeli.service.dto.PublicationListDTO;
import com.example.demo.socialmeli.service.dto.PublicationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PublicationController {
    @Autowired
    IPublicationService iPublicationService;
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost (@RequestBody PublicationRequestDTO publicationRequestDTO) {
        iPublicationService.addNewPost(publicationRequestDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationListDTO> publicationList (@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<PublicationListDTO>(iPublicationService.getPublicationList(userId, order),HttpStatus.OK);
    }
}
