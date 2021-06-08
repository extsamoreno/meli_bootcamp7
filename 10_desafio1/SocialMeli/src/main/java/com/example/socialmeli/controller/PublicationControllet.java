package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;
import com.example.socialmeli.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PublicationControllet {
    @Autowired
    IPublicationService iPostService;

    @PostMapping("/newpost")
    public ResponseEntity<PublicationCreateResponseDTO> addPost(@RequestBody PublicationDTO post) {
        return  new ResponseEntity<>(iPostService.addPost(post),HttpStatus.OK);
    }
    @PostMapping("/newpost/list")
    public ResponseEntity<List<PublicationCreateResponseDTO>> addPost(@RequestBody List<PublicationDTO> post) {
        return  new ResponseEntity<>(iPostService.addPost(post),HttpStatus.OK);
    }
    @GetMapping("/list")
    public List<PublicationDTO> getPosts (){
        return iPostService.getPosts();
    }

}
